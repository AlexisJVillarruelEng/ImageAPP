package dev.alexisvillarruel.imageapp.ui.login.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import dev.alexisvillarruel.imageapp.R
import dev.alexisvillarruel.imageapp.ui.login.ui.components.loginc.btnlogin
import dev.alexisvillarruel.imageapp.ui.login.ui.components.loginc.fullcontainerform
import dev.alexisvillarruel.imageapp.ui.theme.AppTheme


@SuppressLint("ContextCastToActivity")
@Composable
fun LoginScreen() {
    val loginViewModel: LoginViewModel = hiltViewModel()
    val user by loginViewModel.user.collectAsState()
    val error by loginViewModel.error.collectAsState()
    val context = LocalContext.current as Activity

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {
        var textocorreo by rememberSaveable { mutableStateOf("") }
        var textocontraseña by rememberSaveable { mutableStateOf("") }

        val oneTapClient =
            com.google.android.gms.auth.api.identity.Identity.getSignInClient(context)

        val launcher = rememberLauncherForActivityResult(
            ActivityResultContracts.StartIntentSenderForResult()
        ) { result ->
            val credentials = oneTapClient.getSignInCredentialFromIntent(result.data)
            val idToken = credentials.googleIdToken
            if (idToken != null) {
                loginViewModel.loginWithProvider("google", idToken)
            } else {
                Log.e("GoogleLogin", "No se obtuvo ID Token")
            }
        }

        Box(contentAlignment = Alignment.Center) {
            background(Modifier.fillMaxSize(), Alignment.Center)
            Column {
                Text(
                    text = "Login", style = MaterialTheme.typography.displayLarge,
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                fullcontainerform(
                    textocorreo,
                    textocontraseña,
                    oncorrreochangue = { textocorreo = it },
                    onpasswordchangue = { textocontraseña = it },
                    onLoginClick = {
                        loginViewModel.loginWithEmail(textocorreo, textocontraseña)
                    }
                )
                btnlogin(
                    onGoogleClick = {
                        val request = BeginSignInRequest.builder()
                            .setGoogleIdTokenRequestOptions(
                                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                                    .setSupported(true)
                                    .setServerClientId("728366246184-uh0m3683abgrb8na3ms929kg2jaba2ej.apps.googleusercontent.com")
                                    .setFilterByAuthorizedAccounts(false)
                                    .build()
                            )
                            .setAutoSelectEnabled(true)
                            .build()

                        oneTapClient.beginSignIn(request)
                            .addOnSuccessListener { result ->
                                val intentSenderRequest = IntentSenderRequest.Builder(result.pendingIntent).build()
                                launcher.launch(intentSenderRequest)
                            }
                            .addOnFailureListener {
                                Log.e("GoogleLogin", "Fallo Google SignIn", it)
                            }
                    },
                    onAppleClick = {
                        Log.d("AppleLogin", "Login con Apple aún no implementado")
                    },
                    onMicrosoftClick = {
                        Log.d("MicrosoftLogin", "Login con Microsoft aún no implementado")
                    }

                )
                Spacer(modifier = Modifier.fillMaxSize(0.1f))
            }
            background2(Modifier.fillMaxSize())
        }
    }
}

@Composable
fun background(Modifier: Modifier, position: Alignment) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animacionverde))
    val progress by animateLottieCompositionAsState(
        composition = composition,
        isPlaying = true,
        restartOnPlay = true,
        iterations = LottieConstants.IterateForever,
    )


    LottieAnimation(
        composition = composition,
        progress = { progress },
        modifier = Modifier,
        alignment = position
    )
}

@Composable
fun background2(Modifier: Modifier) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animacionondas))
    val progress by animateLottieCompositionAsState(
        composition = composition,
        isPlaying = true,
        restartOnPlay = true,
        iterations = LottieConstants.IterateForever,
    )

    LottieAnimation(
        composition = composition,
        progress = { progress },
        modifier = Modifier,
        alignment = Alignment.BottomEnd
    )
}


@Preview(showSystemUi = true)
@Composable
fun previewlog() {
    AppTheme {
        LoginScreen()
    }
}


@Preview(showSystemUi = true)
@Composable
fun previewb() {
    AppTheme {
        background2(Modifier.fillMaxSize())
    }
}
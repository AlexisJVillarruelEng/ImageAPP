package dev.alexisvillarruel.imageapp.ui.login.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import dev.alexisvillarruel.imageapp.R
import dev.alexisvillarruel.imageapp.ui.login.ui.components.loginc.btnlogin
import dev.alexisvillarruel.imageapp.ui.login.ui.components.loginc.fullcontainerform


@Composable
fun LoginScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {
        var textocorreo by rememberSaveable { mutableStateOf("") }
        var textocontraseña by rememberSaveable { mutableStateOf("") }

        Box(contentAlignment = Alignment.Center) {
            background()
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
                    onpasswordchangue = { textocontraseña = it })
                btnlogin()
            }
            background2()
        }
    }
}

@Composable
fun background() {
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
        modifier = Modifier.fillMaxSize().size(800.dp, 800.dp),
    )
}
@Composable
fun background2() {
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
        modifier = Modifier.fillMaxSize().size(800.dp, 800.dp),
        alignment = Alignment.BottomEnd
    )
}


@Preview(showSystemUi = true)
@Composable
fun previewlog() {
    dev.alexisvillarruel.imageapp.ui.theme.AppTheme {
        LoginScreen()
    }
}


@Preview(showSystemUi = true)
@Composable
fun previewb() {
    dev.alexisvillarruel.imageapp.ui.theme.AppTheme {
        background2()
    }
}
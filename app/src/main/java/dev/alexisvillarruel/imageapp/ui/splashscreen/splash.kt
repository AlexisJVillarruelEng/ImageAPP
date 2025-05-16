package dev.alexisvillarruel.imageapp.ui.splashscreen
import androidx.compose.animation.AnimatedVisibility
import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.alexisvillarruel.imageapp.ui.splashscreen.components.lottieanimationforscreen
import dev.alexisvillarruel.imageapp.ui.splashscreen.components.lottiecamera
import dev.alexisvillarruel.imageapp.ui.splashscreen.components.lottieflechas
import dev.alexisvillarruel.imageapp.ui.splashscreen.components.textosplash
import dev.alexisvillarruel.imageapp.ui.theme.AppTheme
import kotlinx.coroutines.delay

@Composable
fun splashScreen() {

    var visible by remember { mutableStateOf(false) }
    // Your splash screen UI code here

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onBackground
    ) {
        Box(Modifier.fillMaxSize()) {
            Column(modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                lottieanimationforscreen()
                LaunchedEffect(Unit) {
                    visible = true
                    delay(2000)
                    visible = false
                }
                AnimatedVisibility(
                    visible = visible,
                    enter= fadeIn(),
                    exit = fadeOut(),
                ) {
                    textosplash(modifier = Modifier.weight(.1f))
                }

            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewSplashScreen() {
    AppTheme {
        // Preview the splash screen
        splashScreen()
    }
}

@Preview(name = "Modo oscuro", showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewSplashScreen2() {
    AppTheme {
        // Preview the splash screen
        splashScreen()
    }
}
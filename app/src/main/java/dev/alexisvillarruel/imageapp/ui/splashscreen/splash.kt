package dev.alexisvillarruel.imageapp.ui.splashscreen

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.alexisvillarruel.imageapp.ui.splashscreen.components.lottiecamera
import dev.alexisvillarruel.imageapp.ui.splashscreen.components.lottieflechas
import dev.alexisvillarruel.imageapp.ui.splashscreen.components.textosplash
import dev.alexisvillarruel.imageapp.ui.theme.AppTheme

@Composable
fun splashScreen() {
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
                lottiecamera(modifier = Modifier.weight(1f))
                textosplash(modifier = Modifier.weight(.1f))
                lottieflechas(modifier = Modifier.weight(1f))
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
package dev.alexisvillarruel.imageapp.ui.splashscreen.components


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import dev.alexisvillarruel.imageapp.R
import dev.alexisvillarruel.imageapp.ui.theme.AppTheme

@Composable
fun lottiecamera(modifier: Modifier = Modifier) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.cameralogo))
    val progress by animateLottieCompositionAsState(composition,
        iterations = 1,
        isPlaying = true,
        speed = 1.5f,
        restartOnPlay = false
    )

    LottieAnimation(
        composition = composition,
        progress = {progress}, // usar con LAmbda
        modifier = modifier.size(200.dp).fillMaxWidth() // Cambia el tamaño de la animación
    )
}
@Composable
fun lottieflechas(modifier: Modifier = Modifier){
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.flechasanim))
    val progress by animateLottieCompositionAsState(composition,
        iterations = 3,
        isPlaying = true,
        speed = 2f,
        restartOnPlay = false
    )

    LottieAnimation(
        composition = composition,
        progress = {progress}, // usar con LAmbda
        modifier = modifier.size(200.dp).fillMaxWidth()
    )
}





@Preview(showSystemUi = true)
@Composable
fun Previewlottiecamera() {
    AppTheme {
        // Preview the splash screen
        lottieflechas()
    }
}
package dev.alexisvillarruel.imageapp.ui.splashscreen.ui.components


import androidx.compose.animation.Crossfade
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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

enum class LottieAnimationType(valor: Int) {
    CAMERALOGO(R.raw.cameralogo),
    FLECHAS(R.raw.flechasanim)
}

@Composable
fun lottieanimationforscreen() {
    var composables: LottieAnimationType by remember { mutableStateOf(LottieAnimationType.CAMERALOGO) }

    Crossfade(targetState = composables) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .clickable() {
                when (it) {
                    LottieAnimationType.CAMERALOGO -> composables = LottieAnimationType.FLECHAS
                    LottieAnimationType.FLECHAS -> composables = LottieAnimationType.CAMERALOGO
                }
            }, contentAlignment = Alignment.Center) {
            when (it) {
                LottieAnimationType.CAMERALOGO -> lottiecamera()
                LottieAnimationType.FLECHAS -> lottieflechas()
            }
        }
    }


}


@Composable
fun lottiecamera() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.cameralogo))
    val progress by animateLottieCompositionAsState(
        composition,
        iterations = 1,
        isPlaying = true,
        speed = 1.5f,
        restartOnPlay = false
    )

    LottieAnimation(
        composition = composition,
        progress = { progress }, // usar con LAmbda
        modifier = Modifier
            .size(200.dp)
            .fillMaxWidth() // Cambia el tamaño de la animación
    )
}

@Composable
fun lottieflechas() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.flechasanim))
    val progress by animateLottieCompositionAsState(
        composition,
        iterations = LottieConstants.IterateForever,
        isPlaying = true,
        speed = 2f,
        restartOnPlay = false
    )

    LottieAnimation(
        composition = composition,
        progress = { progress }, // usar con LAmbda
        modifier = Modifier
            .size(200.dp)
            .fillMaxWidth()
    )
}


@Preview(showSystemUi = true)
@Composable
fun Previewlottiecamera() {
    AppTheme {
        // Preview the splash screen
        lottieanimationforscreen()
    }
}
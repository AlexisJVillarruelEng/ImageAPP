package dev.alexisvillarruel.imageapp.ui.splashscreen.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.navigation.NavController
import coil.compose.AsyncImage
import dev.alexisvillarruel.imageapp.navigation.Routes
import dev.alexisvillarruel.imageapp.ui.splashscreen.ui.components.lottieanimationforscreen
import dev.alexisvillarruel.imageapp.ui.splashscreen.ui.components.textosplash
import kotlinx.coroutines.delay

@Composable
fun splashScreen(splashvm: SplashScreenViewModel , navController: NavController) {
    val url: String by splashvm.url.collectAsState(initial = "")
    var ischargue by remember { mutableStateOf(false) }
    var visible by remember { mutableStateOf(false) }
    // Your splash screen UI code here

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onBackground
    ) {
        Box(Modifier.fillMaxSize().background(Color.Black.copy(alpha = 0.4f))) {
            AsyncImage(
                model = url,
                contentDescription = "Imagen aleatoria",
                modifier = Modifier.fillMaxSize().clickable{
                    navController.navigate(Routes.HomeScreen.route) {
                        // Clear the back stack to prevent returning to the splash screen
                        popUpTo("splash") { inclusive = true }
                    }
                },
                contentScale = ContentScale.Crop,
                onSuccess = {
                    ischargue = true
                }
            )
            if (ischargue) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    lottieanimationforscreen(navController)
                    LaunchedEffect(Unit) {
                        visible = true
                        delay(4000)
                        visible = false
                    }
                    AnimatedVisibility(
                        visible = visible,
                        enter = fadeIn(),
                        exit = fadeOut(),
                    ) {
                        textosplash(modifier = Modifier.weight(.1f), navController)
                    }
                }


            }
        }
    }
}
//
//@Preview(showSystemUi = true)
//@Composable
//fun PreviewSplashScreen() {
//    AppTheme {
//        // Preview the splash screen
//        splashScreen()
//    }
//}

//@Preview(name = "Modo oscuro", showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
//@Composable
//fun PreviewSplashScreen2() {
//    AppTheme {
//        // Preview the splash screen
//        splashScreen()
//    }
//}
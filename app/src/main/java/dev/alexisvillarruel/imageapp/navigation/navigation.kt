package dev.alexisvillarruel.imageapp.navigation

import android.window.SplashScreen
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.alexisvillarruel.imageapp.ui.splashscreen.splashScreen

@Composable
fun Appnavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.SplashScreen.route,
        Modifier.padding(PaddingValues(0.dp))
    ) {
        composable(Routes.SplashScreen.route) {
            splashScreen(
                navController = navController
            )
        }
    }
}
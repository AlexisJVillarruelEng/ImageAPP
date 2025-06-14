package dev.alexisvillarruel.imageapp.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.alexisvillarruel.imageapp.ui.principalscreen.ui.HomeScreen
import dev.alexisvillarruel.imageapp.ui.splashscreen.ui.SplashScreenViewModel
import dev.alexisvillarruel.imageapp.ui.splashscreen.ui.splashScreen

@Composable
fun Appnavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.SplashScreen.route,
        Modifier.padding(PaddingValues(0.dp))
    ) {
        composable(Routes.SplashScreen.route) {
            val splashViewModel: SplashScreenViewModel = hiltViewModel() // Use hiltViewModel() para obtener la instancia de ViewModel
            splashScreen( splashViewModel, navController = navController )
        }
        composable(Routes.HomeScreen.route) {
            // Aquí puedes agregar la pantalla de inicio
            HomeScreen(navController = navController)
        }
    }
}
package dev.alexisvillarruel.imageapp.navigation

sealed class Routes(val route:String) {
    object SplashScreen: Routes("SplashScreen")
    object HomeScreen: Routes("HomeScreen")
}
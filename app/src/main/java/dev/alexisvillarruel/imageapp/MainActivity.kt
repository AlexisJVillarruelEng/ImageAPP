package dev.alexisvillarruel.imageapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.alexisvillarruel.imageapp.navigation.Appnavigation
import dev.alexisvillarruel.imageapp.ui.splashscreen.ui.SplashScreenViewModel
import dev.alexisvillarruel.imageapp.ui.theme.AppTheme
import kotlin.getValue

//primer paso inyeccion de dependencias

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                val navcontroller = rememberNavController()
                Appnavigation(navController = navcontroller)
            }

        }
    }
}

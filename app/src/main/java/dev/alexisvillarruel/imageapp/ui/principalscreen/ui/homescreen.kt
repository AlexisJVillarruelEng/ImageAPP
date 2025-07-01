package dev.alexisvillarruel.imageapp.ui.principalscreen.ui

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import dev.alexisvillarruel.imageapp.ui.theme.AppTheme
import androidx.compose.runtime.getValue
import dev.alexisvillarruel.imageapp.ui.principalscreen.ui.components.carouselImage
import dev.alexisvillarruel.imageapp.ui.principalscreen.ui.components.filters


@Composable
fun HomeScreen(dashboardviewmodel: homeScreenViewModel,navController: NavHostController) {
    val carrouselimages: List<String> by dashboardviewmodel.carrouselPhotos.collectAsState(emptyList())


    LaunchedEffect(Unit) {
        // This will trigger the carrouselPhotos to be loaded when the HomeScreen is first composed
        dashboardviewmodel.carruselfotos()
    }
    val listaimagenes = carrouselimages
    Surface(modifier=Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
        HomeScreenContent(listaimagenes)

    }
}


@Composable
fun HomeScreenContent(carrouselimages: List<String>) {
    Box (modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.surface),){
        Column(modifier = Modifier.fillMaxSize()) {

            carouselImage(carrouselimages)
            filters()
        }
    }

}


@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
 AppTheme {
     val testimages = listOf<String>(
         "https://images.unsplash.com/photo-1507146426996-ef05306b995a?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8cGVycml0b3xlbnwwfHwwfHx8MA%3D%3D",
         "https://plus.unsplash.com/premium_photo-1707410048990-c9e0fb4e3956?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cGVycml0b3xlbnwwfHwwfHx8MA%3D%3D",
         "https://images.unsplash.com/photo-1534361960057-19889db9621e?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OHx8cGVycml0b3xlbnwwfHwwfHx8MA%3D%3D",
         "https://images.unsplash.com/photo-1591160690555-5debfba289f0?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTJ8fHBlcnJpdG98ZW58MHx8MHx8fDA%3D",
         "https://images.unsplash.com/photo-1507146426996-ef05306b995a?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8cGVycml0b3xlbnwwfHwwfHx8MA%3D%3D"
     )
     HomeScreenContent(carrouselimages= testimages)
 }
}
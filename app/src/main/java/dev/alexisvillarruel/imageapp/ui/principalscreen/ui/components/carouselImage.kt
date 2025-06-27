package dev.alexisvillarruel.imageapp.ui.principalscreen.ui.components

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.carousel.HorizontalUncontainedCarousel
import androidx.compose.material3.carousel.rememberCarouselState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.alexisvillarruel.imageapp.ui.theme.AppTheme


@Composable
fun carouselImage(listaimagenes: List<String>) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface),
    ) {
        Column {
            Text(
                "Photo of the day", modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            carrouselimagecontent(listaimagenes)
            Text(
                "This is a carousel of images", modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun carrouselimagecontent(listaimagenes: List<String>) {
    Log.d("Carrusel", listaimagenes.toString())
    Log.d("cantidad", listaimagenes.size.toString())

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(horizontal = 8.dp)
    ) {
        items(listaimagenes.size) { index ->
            val url = listaimagenes[index]
            Log.d("CarouselImage", "URL: $url")

            AsyncImage(
                model = url,
                contentDescription = "Imagen $index",
                modifier = Modifier
                    .padding(8.dp)
                    .fillParentMaxHeight()
                    .size(width = 200.dp, height = 250.dp).animateItemPlacement()
            )
        }
    }

}


@Preview(showSystemUi = true)
@Composable
fun carouselImagePreview() {
    AppTheme() {
        val carrouselimages = listOf<String>(
            "https://images.unsplash.com/photo-1507146426996-ef05306b995a?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8cGVycml0b3xlbnwwfHwwfHx8MA%3D%3D",
            "https://plus.unsplash.com/premium_photo-1707410048990-c9e0fb4e3956?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8cGVycml0b3xlbnwwfHwwfHx8MA%3D%3D",
            "https://images.unsplash.com/photo-1534361960057-19889db9621e?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OHx8cGVycml0b3xlbnwwfHwwfHx8MA%3D%3D",
            "https://images.unsplash.com/photo-1591160690555-5debfba289f0?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTJ8fHBlcnJpdG98ZW58MHx8MHx8fDA%3D",
            "https://images.unsplash.com/photo-1507146426996-ef05306b995a?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8cGVycml0b3xlbnwwfHwwfHx8MA%3D%3D"
        )
        carouselImage(carrouselimages)
    }
}
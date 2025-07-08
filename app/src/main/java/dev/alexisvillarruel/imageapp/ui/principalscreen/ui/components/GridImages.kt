package dev.alexisvillarruel.imageapp.ui.principalscreen.ui.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.alexisvillarruel.imageapp.ui.principalscreen.data.network.response.searchResponse
import dev.alexisvillarruel.imageapp.ui.theme.AppTheme

@Composable
fun GridImages(searchphoto: searchResponse?) {
    Surface(modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.background)) {
        if (searchphoto == null || searchphoto.results.isEmpty()) {
            Text("Sin resultados", modifier = Modifier.padding(16.dp))
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(8.dp)
            ) {
                items(searchphoto.results) { item ->
                    Card(modifier = Modifier.padding(8.dp)) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            AsyncImage(
                                model = item.urls.regular,
                                contentDescription = null,
                                modifier = Modifier.fillMaxWidth()
                            )
                            Text(
                                text = "${item.links.download}",
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier
                                    .padding(8.dp)
                                    .clickable {
                                        Log.d("Download", "URL: ${item.links.download}")
                                    }
                            )
                            Text(
                                text = "Descargar",
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier
                                    .padding(8.dp)
                                    .clickable {
                                        Log.d("Download", "URL: ${item.links.download}")
                                    }
                            )

                        }
                    }
                }
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun GridImagesPreview() {
    AppTheme {
        val searchphoto = null
        GridImages(searchphoto)
    }
}
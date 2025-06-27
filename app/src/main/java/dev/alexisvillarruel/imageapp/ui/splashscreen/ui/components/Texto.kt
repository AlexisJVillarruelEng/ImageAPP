package dev.alexisvillarruel.imageapp.ui.splashscreen.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.alexisvillarruel.imageapp.ui.theme.AppTheme

@Composable
fun textosplash(modifier: Modifier = Modifier, navController: NavController) {
    Text(
        modifier = modifier.fillMaxWidth().size(40.dp),
        text = "Touch to continue",
        style = MaterialTheme.typography.headlineMedium,
        color = MaterialTheme.colorScheme.onPrimaryContainer,
        textAlign = TextAlign.Center
    )
}

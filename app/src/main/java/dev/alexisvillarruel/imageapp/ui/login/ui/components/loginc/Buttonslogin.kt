package dev.alexisvillarruel.imageapp.ui.login.ui.components.loginc

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.alexisvillarruel.imageapp.ui.theme.AppTheme

@Composable
fun btnlogin() {
    Box(modifier = Modifier.fillMaxWidth()) {
        contentbtnlogin()
    }
}

@Composable
fun contentbtnlogin() {

    Row(
        modifier = Modifier
            .fillMaxWidth(), // eliminar fondo se lo da la principal
        horizontalArrangement = Arrangement.Center
    ) {

        AsyncImage(
            modifier = Modifier
                .size(70.dp)
                .padding(8.dp)
                .clickable { /* Acción al hacer clic */ },
            model = "https://1000logos.net/wp-content/uploads/2016/10/Apple-Logo.png",
            contentDescription = "Logo Instagram"
        )

        AsyncImage(
            modifier = Modifier
                .size(70.dp)
                .padding(8.dp)
                .clickable { /* Acción al hacer clic */ },
            model = "https://www.insights.la/wp-content/uploads/2015/04/Microsoft-logo-m-box-880x660.png",
            contentDescription = "Logo Instagram",
        )
        AsyncImage(
            modifier = Modifier
                .size(70.dp)
                .padding(8.dp)
                .clickable { /* Acción al hacer clic */ },
            model = "https://static.dezeen.com/uploads/2025/05/sq-google-g-logo-update_dezeen_2364_col_0.jpg",
            contentDescription = "Logo Instagram",
        )
    }

}


@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun viewbtnlogin() {
    AppTheme {
        btnlogin()
    }
}
package dev.alexisvillarruel.imageapp.ui.login.ui.components.loginc

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.google.android.gms.auth.api.identity.BeginSignInResult
import com.google.android.gms.tasks.Task

@Composable
fun btnlogin(
    onGoogleClick: () -> Task<BeginSignInResult>,
    onAppleClick: () -> Int,
    onMicrosoftClick: () -> Int
) {
    Box(modifier = Modifier.fillMaxWidth()) {
        contentbtnlogin(
            onGoogleClick = onGoogleClick,
            onAppleClick = onAppleClick,
            onMicrosoftClick = onMicrosoftClick
        )
    }
}

@Composable
fun contentbtnlogin(
    onGoogleClick: () -> Task<BeginSignInResult>,
    onAppleClick: () -> Int,
    onMicrosoftClick: () -> Int
) {

    Row(
        modifier = Modifier
            .fillMaxWidth(), // eliminar fondo se lo da la principal
        horizontalArrangement = Arrangement.Center
    ) {

        AsyncImage(
            modifier = Modifier
                .size(70.dp).background(Color.DarkGray)
                .padding(8.dp)
                .clickable { onGoogleClick() },
            model = "https://1000logos.net/wp-content/uploads/2016/10/Apple-Logo.png",
            contentDescription = "Logo apple"
        )

        AsyncImage(
            modifier = Modifier
                .size(70.dp).background(Color.DarkGray)
                .padding(8.dp)
                .clickable { onMicrosoftClick() },
            model = "https://www.insights.la/wp-content/uploads/2015/04/Microsoft-logo-m-box-880x660.png",
            contentDescription = "Logo Microsoft",
        )
        AsyncImage(
            modifier = Modifier
                .size(70.dp).background(Color.DarkGray)
                .padding(8.dp)
                .clickable { onAppleClick() },
            model = "https://static.dezeen.com/uploads/2025/05/sq-google-g-logo-update_dezeen_2364_col_0.jpg",
            contentDescription = "Logo Instagram",
        )
    }

}



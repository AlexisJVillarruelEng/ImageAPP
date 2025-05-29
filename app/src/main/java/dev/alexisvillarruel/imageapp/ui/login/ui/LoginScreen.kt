package dev.alexisvillarruel.imageapp.ui.login.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import dev.alexisvillarruel.imageapp.ui.login.ui.components.loginc.btnlogin
import dev.alexisvillarruel.imageapp.ui.login.ui.components.loginc.fullcontainerform
import dev.alexisvillarruel.imageapp.ui.theme.AppTheme

@Composable
fun LoginScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        var textocorreo by rememberSaveable { mutableStateOf("") }
        var textocontraseña by rememberSaveable { mutableStateOf("") }

        Box(contentAlignment = Alignment.Center) {
            Column {
                Text(text = "Login", style = MaterialTheme.typography.displayLarge,
                    modifier = Modifier.align(Alignment.CenterHorizontally))
                fullcontainerform(textocorreo, textocontraseña, oncorrreochangue={textocorreo = it}, onpasswordchangue={textocontraseña= it})
                btnlogin()
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun previewlog() {
    AppTheme {

        LoginScreen()
    }
}
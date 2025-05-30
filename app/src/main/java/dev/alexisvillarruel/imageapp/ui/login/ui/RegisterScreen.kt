package dev.alexisvillarruel.imageapp.ui.login.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import dev.alexisvillarruel.imageapp.ui.login.ui.components.registerc.registerform
import dev.alexisvillarruel.imageapp.ui.theme.AppTheme

@Composable
fun RegisterScreen() {
    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var contraseña by remember { mutableStateOf("") }

    registerform(nombre, correo, contraseña,
        onNombreChange = {nombre = it },
        onCorreoChange = { correo = it },
        onContraseñaChange = { contraseña = it }
    )

}

@Preview(showSystemUi = true)
@Composable
fun RegisterScreenPreview() {
    AppTheme {

        RegisterScreen()
    }
}
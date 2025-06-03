package dev.alexisvillarruel.imageapp.ui.login.ui.components.loginc

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.alexisvillarruel.imageapp.ui.theme.AppTheme

@Composable
fun fullcontainerform(correo: String, contraseña: String, oncorrreochangue: (String)-> Unit, onpasswordchangue: (String) -> Unit) {
        contentformlogin(correo, contraseña,oncorrreochangue, onpasswordchangue)

}


@Composable
fun contentformlogin(correo: String, contraseña: String, oncorrreochangue: (String) -> Unit, onpasswordchangue: (String) -> Unit) {

    var isvisible by rememberSaveable { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("correo",color = MaterialTheme.colorScheme.onPrimary)
        OutlinedTextField(
            value = correo,
            onValueChange = oncorrreochangue,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedTextColor = MaterialTheme.colorScheme.onPrimary,
                unfocusedTextColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f),
                focusedLabelColor = MaterialTheme.colorScheme.onPrimary,
                unfocusedLabelColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f),
                focusedIndicatorColor = MaterialTheme.colorScheme.onPrimary,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.onPrimary

                ),
            modifier = Modifier
                .fillMaxWidth()
                .clickable { isvisible = !isvisible } // ejemplo de uso de rememberSaveable
        )


        Text("Contraseña",color = MaterialTheme.colorScheme.onPrimary)

        OutlinedTextField(
            value = contraseña,
            onValueChange = onpasswordchangue,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedTextColor = MaterialTheme.colorScheme.onPrimary,
                unfocusedTextColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f),
                focusedLabelColor = MaterialTheme.colorScheme.onPrimary,
                unfocusedLabelColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.5f),
                focusedIndicatorColor = MaterialTheme.colorScheme.onPrimary,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.onPrimary

            ),
            modifier = Modifier
                .fillMaxWidth(),
            visualTransformation = if (isvisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val icon =
                    if (isvisible) Icons.Default.Visibility else Icons.Default.VisibilityOff

                Icon(
                    imageVector = icon,
                    contentDescription = "Toggle password visibility",
                    modifier = Modifier.clickable { isvisible = !isvisible },
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        )
        Button(
            onClick = { /* Acción al hacer clic en el botón */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimary
            )
        ) {
            Text(text = "Iniciar sesión", color = MaterialTheme.colorScheme.onPrimary)
        }
        Text(text = "Regsitrate aqui",color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier
                .padding(top = 16.dp)
                .clickable { /* Acción al hacer clic */ } // lleva a register screen
        )
    }

}


@Preview(showBackground = true)
@Composable
fun viewform() {
    AppTheme {
        fullcontainerform(
            correo = TODO(),
            contraseña = TODO(),
            oncorrreochangue = TODO(),
            onpasswordchangue = TODO()
        )
    }
}
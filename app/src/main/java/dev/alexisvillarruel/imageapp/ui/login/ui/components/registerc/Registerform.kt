package dev.alexisvillarruel.imageapp.ui.login.ui.components.registerc

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.alexisvillarruel.imageapp.ui.theme.AppTheme

@Composable
fun registerform() {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Box {
            Column {
                Text(
                    "Register Form", style = MaterialTheme.typography.displayLarge,
                    modifier = Modifier
                        .fillMaxWidth()
                        .paddingFromBaseline(
                            top = 16.dp,
                            bottom = 16.dp
                        ) // Padding from baseline for better spacing
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth(),
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth(),
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth(),
                )

            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun previewregisterform() {
    AppTheme {
        registerform()
    }

}
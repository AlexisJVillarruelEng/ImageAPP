package dev.alexisvillarruel.imageapp.ui.login.ui.components.registerc

import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.alexisvillarruel.imageapp.R
import dev.alexisvillarruel.imageapp.ui.theme.AppTheme

@Composable
fun registerform() {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Box {
            Column {
                Text(
                    "Register Form", style = MaterialTheme.typography.displayLarge,
                    modifier = Modifier
                        .fillMaxWidth().align(Alignment.CenterHorizontally)
                        .paddingFromBaseline(
                            top = 16.dp,
                            bottom = 16.dp
                        ),
                    textAlign = TextAlign.Center
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = { Text("Email") },
                    modifier = Modifier.padding(16.dp)
                        .fillMaxWidth(),
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = { Text("nombre") },
                    modifier = Modifier.padding(16.dp)
                        .fillMaxWidth(),
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    label = { Text("contraseña") },
                    modifier = Modifier.padding(16.dp)
                        .fillMaxWidth(),
                )
                Text("Click en logo para registrar",modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 4.dp, top = 4.dp),
                    style = MaterialTheme.typography.bodySmall
                )
                Image(
                    painter = painterResource(id =
                        R.drawable.logo), // Replace with your drawable resource
                    contentDescription = "Register Icon",
                    modifier = Modifier
                        .padding(16.dp).fillMaxWidth()
                        .size(50.dp)
                        .clickable { /* Handle click */ },
                    alignment = Alignment.Center
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
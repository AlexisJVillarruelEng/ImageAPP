package dev.alexisvillarruel.imageapp.ui.login.ui.components.registerc

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import dev.alexisvillarruel.imageapp.R
import dev.alexisvillarruel.imageapp.ui.login.ui.LoginViewModel
import dev.alexisvillarruel.imageapp.ui.login.ui.background
import dev.alexisvillarruel.imageapp.ui.login.ui.background2
import dev.alexisvillarruel.imageapp.ui.theme.AppTheme

@Composable
fun registerform(
    nombre: String,
    correo: String,
    contraseña: String,
    onNombreChange: (String) -> Unit,
    onCorreoChange: (String) -> Unit,
    onContraseñaChange: (String) -> Unit,
) {
    val loginViewModel: LoginViewModel = hiltViewModel()
    Surface(modifier = Modifier.fillMaxSize(), color = Color.Black) {
        Box(modifier=Modifier.padding(top = 40.dp)) {
            background(Modifier.fillMaxSize().alpha(0.4f).blur(10.dp).scale(1.5f).zIndex(0f).padding(vertical = 210.dp),Alignment.TopStart)


            Column(modifier= Modifier.padding(50.dp).zIndex(1f).fillMaxSize()) {
                Text(
                    "Register", style = MaterialTheme.typography.displayLarge,
                    modifier = Modifier
                        .fillMaxWidth().align(Alignment.CenterHorizontally)
                        .paddingFromBaseline(
                            top = 16.dp,
                            bottom = 16.dp
                        ),
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onPrimary
                )
                OutlinedTextField(
                    value = correo,
                    onValueChange = onCorreoChange,
                    label = { Text("Email") },
                    modifier = Modifier.padding(16.dp)
                        .fillMaxWidth(),
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
                )
                OutlinedTextField(
                    value = nombre,
                    onValueChange = onNombreChange,
                    label = { Text("nombre") },
                    modifier = Modifier.padding(16.dp)
                        .fillMaxWidth(),
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
                )
                OutlinedTextField(
                    value = contraseña,
                    onValueChange = onContraseñaChange,
                    label = { Text("contraseña") },
                    modifier = Modifier.padding(16.dp)
                        .fillMaxWidth(),
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
                )
                Text("Click en logo para registrar",modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 4.dp, top = 4.dp),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Image(
                    painter = painterResource(id =
                        R.drawable.logo), // Replace with your drawable resource
                    contentDescription = "Register Icon",
                    modifier = Modifier
                        .padding(16.dp).fillMaxWidth()
                        .size(50.dp)
                        .clickable {

                                loginViewModel.registerWithEmail(correo,contraseña, nombre)

                        },
                    alignment = Alignment.Center
                )
            }
            background2(Modifier.fillMaxHeight().align(Alignment.BottomCenter))
        }
    }
}



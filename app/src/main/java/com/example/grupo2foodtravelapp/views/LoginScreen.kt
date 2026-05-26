package com.example.grupo2foodtravelapp.views

import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.grupo2foodtravelapp.R
import com.example.grupo2foodtravelapp.ui.theme.*


@Composable
fun LoginScreen(
    onIngresarClick: () -> Unit,
    onRegistrarClick: () -> Unit
) {
    var correo by rememberSaveable { mutableStateOf("") }
    var contrasena by rememberSaveable { mutableStateOf("") }

    var mostrarError by rememberSaveable { mutableStateOf(false) }
    var mensajeError by rememberSaveable { mutableStateOf("") }

    var mostrarExito by rememberSaveable { mutableStateOf(false) }
    var mensajeExito by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier.size(230.dp)
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text(
            text = "Grupo2-FOOD TRAVEL APP",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = VerdeFood
        )

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = correo,
            onValueChange = { correo = it.replace("\n","") },
            label = { Text("Correo") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = VerdeFood,
                unfocusedBorderColor = VerdeFood.copy(alpha = 0.5f),
                focusedLabelColor = VerdeFood,
                cursorColor = VerdeFood,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = contrasena,
            onValueChange = { contrasena = it.replace("\n", "") },
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password) ,
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = VerdeFood,
                unfocusedBorderColor = VerdeFood.copy(alpha = 0.5f),
                focusedLabelColor = VerdeFood,
                cursorColor = VerdeFood,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black
            )
        )

        Spacer(modifier = Modifier.height(28.dp))

        Button(
            onClick = {
                val error = validarLogin(correo, contrasena)

                if (error == null) {
                    mensajeExito = "Ingreso correcto"
                    mostrarExito = true
                    onIngresarClick()
                } else {
                    mensajeError = error
                    mostrarError = true
                }
            },
            modifier = Modifier.fillMaxWidth()
                                .height(52.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = VerdeFood
            )

        ) {
            Text(text ="INGRESAR",color = Color.White,
                fontWeight = FontWeight.Bold)

        }

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedButton(
            onClick = {
                onRegistrarClick()
            },
            modifier = Modifier.fillMaxWidth()
                                .height(52.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = VerdeFood
            )
        ) {
            Text(text = "REGISTRAR",
                color = VerdeFood,
                fontWeight = FontWeight.Bold)
        }
    }

    if (mostrarError) {
        AlertDialog(
            onDismissRequest = {
                mostrarError = false
            },

            containerColor = FondoDialog,

            shape = RoundedCornerShape(20.dp),

            title = {
                Text(
                    text = "Error de validación",
                    color = RojoError,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            },

            text = {
                Text(
                    text = mensajeError,
                    color = GrisTexto
                )
            },

            confirmButton = {

                TextButton(
                    onClick = {
                        mostrarError = false
                    }
                ) {

                    Text(
                        text = "Aceptar",
                        color = RojoError,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        )
    }

    if (mostrarExito) {
        AlertDialog(
            onDismissRequest = {
                mostrarExito = false
            },

            containerColor = FondoDialog,

            shape = RoundedCornerShape(20.dp),

            title = {
                Text(
                    text = "Ingreso exitoso",
                    color = VerdeOscuro,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            },

            text = {
                Text(
                    text = mensajeExito,
                    color = GrisTexto
                )
            },

            confirmButton = {

                TextButton(
                    onClick = {
                        mostrarExito = false
                    }
                ) {

                    Text(
                        text = "Aceptar",
                        color = VerdeFood,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        )
    }
}

fun validarLogin(
    correo: String,
    contrasena: String
): String? {
    if (correo.isBlank()) {
        return "Debe ingresar su correo electrónico."
    }

    if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
        return "El formato del correo electrónico no es válido."
    }

    if (contrasena.isBlank()) {
        return "Debe ingresar su contraseña."
    }

    if (contrasena.length < 6) {
        return "La contraseña debe tener como mínimo 6 caracteres."
    }

    val contieneNumero = contrasena.any { it.isDigit() }

    if (!contieneNumero) {
        return "La contraseña debe contener al menos un número."
    }

    return null
}

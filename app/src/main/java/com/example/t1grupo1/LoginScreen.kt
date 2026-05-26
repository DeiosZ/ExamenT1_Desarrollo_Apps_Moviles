package com.example.t1grupo1

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
import com.example.t1grupo1.ui.theme.T1Grupo1Theme


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

    val verdePrincipal = Color(0xFF2E7D32)

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
            modifier = Modifier.size(130.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "FOOD TRAVEL APP",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = verdePrincipal
        )

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = correo,
            onValueChange = { correo = it },
            label = { Text("Correo") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = contrasena,
            onValueChange = { contrasena = it },
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
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
        ) {
            Text("INGRESAR")
        }

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedButton(
            onClick = {
                onRegistrarClick()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("REGISTRAR")
        }
    }

    if (mostrarError) {
        AlertDialog(
            onDismissRequest = { mostrarError = false },
            confirmButton = {
                TextButton(onClick = { mostrarError = false }) {
                    Text("Aceptar")
                }
            },
            title = { Text("Error") },
            text = { Text(mensajeError) }
        )
    }

    if (mostrarExito) {
        AlertDialog(
            onDismissRequest = { mostrarExito = false },
            confirmButton = {
                TextButton(onClick = { mostrarExito = false }) {
                    Text("OK")
                }
            },
            title = { Text("Éxito") },
            text = { Text(mensajeExito) }
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

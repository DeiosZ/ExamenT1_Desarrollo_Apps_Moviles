package com.example.grupo2foodtravelapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.grupo2foodtravelapp.ui.theme.VerdeFood

@Composable
fun BarraSuperior(
    mostrarBoton: Boolean = false,
    onClickBoton: () -> Unit = {}
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(VerdeFood)
            .statusBarsPadding()
            .height(72.dp)
    ) {

        if (mostrarBoton) {

            IconButton(
                onClick = onClickBoton,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 6.dp)
            ) {

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Volver",
                    tint = Color.White
                )
            }
        }

        Text(
            text = "Grupo2-FoodTravelApp",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}
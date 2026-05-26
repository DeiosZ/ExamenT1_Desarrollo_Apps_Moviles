package com.example.t1grupo1


import androidx.compose.foundation.layout.*

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PantallaListaDetalle(lugarId: Int) {

    val lugar = LugarData.lugares.find { it.id == lugarId }

    if (lugar == null) {
        Text("No encontrado")
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text("Agrega los detalles")
    }
}
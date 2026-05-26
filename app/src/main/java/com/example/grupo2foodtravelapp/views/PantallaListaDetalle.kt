package com.example.grupo2foodtravelapp.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.grupo2foodtravelapp.components.BarraSuperior
import com.example.grupo2foodtravelapp.model.ComidaData
import com.example.grupo2foodtravelapp.model.LugarData
import com.example.grupo2foodtravelapp.ui.theme.*

@Composable
fun PantallaListaDetalle(
    lugarId: Int,
    navController: NavController
) {

    val lugar = LugarData.lugares.find { it.id == lugarId }

    val comida = lugar?.let { l ->
        ComidaData.comidas.find { it.id == l.comidaId }
    }

    if (lugar == null) {
        Text("No encontrado")
        return
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        BarraSuperior(
            mostrarBoton = true,
            onClickBoton = {
                navController.popBackStack()
            }
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {

            AsyncImage(
                model = lugar.imagen,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(260.dp)
                    .clip(RoundedCornerShape(22.dp)),
                contentScale = ContentScale.FillBounds
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = lugar.nombreLugar,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = Icons.Filled.LocationOn,
                    contentDescription = null,
                    tint = Color.Red,
                    modifier = Modifier.size(26.dp)
                )

                Spacer(modifier = Modifier.width(6.dp))

                Text(
                    text = lugar.ubicacion,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),

            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column {

                        Text(
                            text = "Comida típica",
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = comida?.nombreComida ?: "No disponible",
                            fontSize = 17.sp
                        )
                    }

                    Column(
                        horizontalAlignment = Alignment.End
                    ) {

                        Text(
                            text = "Precio",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "S/ ${comida?.precio ?: 0.0}",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = AmarilloMoney
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Descripción",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = lugar.descripcion,
                fontSize = 15.sp,
                lineHeight = 24.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(28.dp))

            Text(
                text = "Estado",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(12.dp))

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(50.dp))
                    .background(
                        if (lugar.estado)
                            VerdeFood
                        else
                            RojoError
                    )
                    .padding(
                        horizontal = 18.dp,
                        vertical = 10.dp
                    )
            ) {

                Text(
                    text = if (lugar.estado)
                        "Disponible"
                    else
                        "No disponible",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}
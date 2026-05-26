package com.example.grupo2foodtravelapp.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.grupo2foodtravelapp.components.BarraSuperior
import com.example.grupo2foodtravelapp.model.ComidaData
import com.example.grupo2foodtravelapp.model.LugarData
import com.example.grupo2foodtravelapp.ui.theme.RojoError
import com.example.grupo2foodtravelapp.ui.theme.VerdeFood

@Composable
fun PantallaListaLugares(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F7F7))
    ) {

        BarraSuperior()

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {

            items(LugarData.lugares) { lugar ->

                val comida = ComidaData.comidas.find {
                    it.id == lugar.comidaId
                }

                Card(
                    modifier = Modifier
                        .padding(horizontal = 14.dp, vertical = 8.dp)
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate("detail/${lugar.id}")
                        },
                    shape = RoundedCornerShape(18.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    )
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        AsyncImage(
                            model = lugar.imagen,
                            contentDescription = null,
                            modifier = Modifier
                                .size(95.dp)
                                .clip(RoundedCornerShape(16.dp)),
                            contentScale = ContentScale.Crop
                        )

                        Spacer(modifier = Modifier.width(14.dp))

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {

                            Text(
                                text = lugar.nombreLugar,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )

                            Spacer(modifier = Modifier.height(6.dp))

                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Icon(
                                    imageVector = Icons.Filled.LocationOn,
                                    contentDescription = null,
                                    tint = VerdeFood,
                                    modifier = Modifier.size(17.dp)
                                )

                                Spacer(modifier = Modifier.width(4.dp))

                                Text(
                                    text = lugar.ubicacion,
                                    fontSize = 13.sp,
                                    color = Color.Gray
                                )
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = comida?.nombreComida ?: "",
                                fontSize = 14.sp,
                                color = Color.DarkGray
                            )
                        }

                        Column(
                            modifier = Modifier.height(95.dp),
                            verticalArrangement = Arrangement.Bottom,
                            horizontalAlignment = Alignment.End
                        ) {

                            Text(
                                text = "S/. ${comida?.precio ?: 0.0}",
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 13.sp,
                                color = Color.Black
                            )

                            Spacer(modifier = Modifier.height(2.dp))

                            Text(
                                text = if (lugar.estado)
                                    "Disponible"
                                else
                                    "No disponible",
                                fontSize = 11.sp,
                                color = if(lugar.estado) VerdeFood else RojoError
                            )
                        }
                    }
                }
            }
        }
    }
}
package com.diegorb.tiempo.presentation.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.diegorb.tiempo.presentation.screens.tiempo.TiempoState
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt
import com.diegorb.tiempo.R

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TiempoCard(
    state: TiempoState,
    bgColor: Color,
    modifier: Modifier = Modifier
) {
    state.tiempoInfo?.tiempoActualData?.let { data->
        Card(
            backgroundColor = bgColor,
            shape = RoundedCornerShape(25.dp),
            elevation = 0.dp,
            modifier = modifier.padding(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Hoy ${
                        data.time.format(
                            DateTimeFormatter.ofPattern("HH: mm")
                        )
                    }",
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(16.dp))

                Image(
                    painter = painterResource(id = data.tipoTiempo.iconRes),
                    contentDescription = null,
                    modifier = Modifier.width(150.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "${data.temperaturaCelsius}ºC",
                    color = Color.White,
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "${data.tipoTiempo.tiempoDesc}",
                    color = Color.White,
                    fontSize = 20.sp
                )

                Spacer(modifier = Modifier.height(32.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    TiempoInfoDisplay(
                        valor = data.presionHPA.roundToInt(), 
                        unidad = "hPa", 
                        icono = ImageVector.vectorResource(id = R.drawable.ic_pressure),
                        iconTint = Color.White,
                        textStyle = TextStyle(color = Color.White)
                    )
                    TiempoInfoDisplay(
                        valor = data.humedadPercent.roundToInt(),
                        unidad = "%",
                        icono = ImageVector.vectorResource(id = R.drawable.ic_drop),
                        iconTint = Color.White,
                        textStyle = TextStyle(color = Color.White)
                    )
                    TiempoInfoDisplay(
                        valor = data.velocidadVientoKMH.roundToInt(),
                        unidad = "Km/h",
                        icono = ImageVector.vectorResource(id = R.drawable.ic_wind),
                        iconTint = Color.White,
                        textStyle = TextStyle(color = Color.White)
                    )
                }




            }

        }
    }
}
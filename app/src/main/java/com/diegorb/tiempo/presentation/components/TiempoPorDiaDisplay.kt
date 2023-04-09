package com.diegorb.tiempo.presentation.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.diegorb.tiempo.domain.tiempo.TiempoData
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TiempoPorDiaDisplay(
    tiempoData: TiempoData,
    modifier: Modifier = Modifier,
    textColor: Color = Color.White
){
    val formatoHoras = remember(tiempoData){
        tiempoData.time.format(DateTimeFormatter.ofPattern("HH:mm"))
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = formatoHoras,
            color = Color.LightGray
        )
        Image(
            painter = painterResource(id = tiempoData.tipoTiempo.iconRes) ,
            contentDescription = null,
            modifier = Modifier.width(40.dp)
        )
        Text(
            text = "${tiempoData.temperaturaCelsius}ºC",
            color = Color.LightGray,
            fontWeight = FontWeight.Bold
        )
    }

}
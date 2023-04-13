package com.diegorb.tiempo.data.mappers

import android.os.Build
import androidx.annotation.RequiresApi
import com.diegorb.tiempo.data.remote.TiempoDataDto
import com.diegorb.tiempo.data.remote.TiempoDto
import com.diegorb.tiempo.domain.tiempo.TiempoData
import com.diegorb.tiempo.domain.tiempo.TiempoInfo
import com.diegorb.tiempo.domain.tiempo.TipoTiempo
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private data class IndexedTiempoData(
    val index: Int,
    val data: TiempoData
)


//Mapea el objeto TiempoDataDTO de la capa data, al objeto TiempoData de la capa domain
@RequiresApi(Build.VERSION_CODES.O)
fun TiempoDataDto.toTiempoDataMap(): Map<Int, List<TiempoData>>{
    return time.mapIndexed{ index, time ->
        val temperatura = temperatura[index]
        val codigoTiempo = codigoTiempo[index]
        val velocidadViento = velocidadViento[index]
        val presion = presion[index]
        val humedad = humedad[index]
        IndexedTiempoData(
            index = index,
            data = TiempoData(
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                temperaturaCelsius = temperatura,
                presionHPA = presion,
                velocidadVientoKMH = velocidadViento,
                humedadPercent = humedad,
                tipoTiempo = TipoTiempo.codigoOMM(codigoTiempo)
            )
        )

    }.groupBy {
        //La Api proporciona 24 valores por cada día (24h). Al dividir entre 24, agruparemos los datos por día
        it.index / 24
    }.mapValues {
        it.value.map { it.data }
    }
}

//Mapea la clase TiempoDto de la capa data, a la clase TiempoInfo de la capa domain
@RequiresApi(Build.VERSION_CODES.O)
fun TiempoDto.toTiempoInfo(): TiempoInfo {
    val tiempoDataMap = tiempoData.toTiempoDataMap()
    val current = LocalDateTime.now()
    val actualTiempoData = tiempoDataMap[0]?.find {
        //Asigna el rango de hora de la API mas cercana a la hora actual
        val time = if(current.minute < 30) current.hour else current.hour + 1
        it.time.hour == time
    }
    return TiempoInfo(
        tiempoDataPorDia = tiempoDataMap,
        tiempoActualData = actualTiempoData,
    )
}
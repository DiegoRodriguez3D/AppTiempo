package com.diegorb.tiempo.data.remote

import com.squareup.moshi.Json

//Contiene la estructura de datos del campo "hourly" devuelto en el JSON por la API
data class TiempoDataDto(
    val time: List<String>,

    @field:Json(name = "temperature_2m")
    val temperatura: List<Double>,

    @field:Json(name = "weathercode")
    val codigoTiempo: List<Int>,

    @field:Json(name = "pressure_msl")
    val presion: List<Double>,

    @field:Json(name = "windspeed_10m")
    val velocidadViento: List<Double>,

    @field:Json(name = "relativehumidity_2m")
    val humedad: List<Double>
)

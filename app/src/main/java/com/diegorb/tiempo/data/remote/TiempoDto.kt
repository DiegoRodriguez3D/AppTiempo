package com.diegorb.tiempo.data.remote

import com.squareup.moshi.Json

data class TiempoDto(

    @field:Json(name= "hourly") //accederemos únicamente al campo "hourly" del JSON devuelto por la api
    val tiempoData: TiempoDataDto
)

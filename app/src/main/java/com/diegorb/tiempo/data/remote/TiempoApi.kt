package com.diegorb.tiempo.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

//Conecta con la api OpenMeteo para obtener los datos necesarios en un JSON
interface TiempoApi {
    @GET("v1/forecast?hourly=temperature_2m,wheathercode,relativehumidity_2m,windspeed_10m,pressure_msl")
    suspend fun getTiempoData(
        @Query("latitude") lat: Double,
        @Query("longitude") long: Double
    ): TiempoDto
}
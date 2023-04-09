package com.diegorb.tiempo.domain.tiempo


data class TiempoInfo(
    val tiempoDataPorDia: Map<Int, List<TiempoData>>, //Contiene la información de los siguientes 7 días de la semana (clave Int 0-6)
    val tiempoActualData: TiempoData? //Contiene la información del momento actual
)

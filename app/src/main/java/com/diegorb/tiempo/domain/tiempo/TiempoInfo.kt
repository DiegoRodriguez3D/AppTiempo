package com.diegorb.tiempo.domain.tiempo


data class TiempoInfo(
    val tiempoDataPorDia: Map<Int, List<TiempoData>>, //Contiene la información de cada Día de la semana (clave Int 1-7)
    val tiempoActualData: TiempoData? //Contiene la información del momento actual
)

package com.diegorb.tiempo.domain.tiempo

import java.time.LocalDateTime

//Model Tiempo
data class TiempoData(
    val hora: LocalDateTime,
    val temperaturaCelsius: Double,
    val presionHPA: Double,
    val velocidadVientoKMH: Double,
    val humedadPercent: Double,
    val tipoTiempo: TipoTiempo
)

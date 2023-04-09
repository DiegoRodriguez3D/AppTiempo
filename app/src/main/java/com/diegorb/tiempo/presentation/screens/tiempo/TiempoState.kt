package com.diegorb.tiempo.presentation.screens.tiempo

import com.diegorb.tiempo.domain.tiempo.TiempoInfo

data class TiempoState (
    val tiempoInfo: TiempoInfo? = null,
    val isLoading: Boolean = false,
    val error:String? = null
)
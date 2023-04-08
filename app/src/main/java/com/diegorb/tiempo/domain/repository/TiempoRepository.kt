package com.diegorb.tiempo.domain.repository

import com.diegorb.tiempo.domain.tiempo.TiempoInfo
import com.diegorb.tiempo.domain.util.Recurso

interface TiempoRepository {
    suspend fun getTiempoData(lat:Double, long:Double): Recurso<TiempoInfo>
}
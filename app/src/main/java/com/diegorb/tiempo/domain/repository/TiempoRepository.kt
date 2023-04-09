package com.diegorb.tiempo.domain.repository

import com.diegorb.tiempo.domain.tiempo.TiempoInfo
import com.diegorb.tiempo.domain.util.Resource

interface TiempoRepository {
    suspend fun getTiempoData(lat:Double, long:Double): Resource<TiempoInfo>
}
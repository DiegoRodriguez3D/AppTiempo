package com.diegorb.tiempo.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.diegorb.tiempo.data.mappers.toTiempoInfo
import com.diegorb.tiempo.data.remote.TiempoApi
import com.diegorb.tiempo.domain.repository.TiempoRepository
import com.diegorb.tiempo.domain.tiempo.TiempoInfo
import com.diegorb.tiempo.domain.util.Recurso
import javax.inject.Inject

class TiempoRepositoryImpl @Inject constructor(
    private val api: TiempoApi
): TiempoRepository {
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getTiempoData(lat: Double, long: Double): Recurso<TiempoInfo> {

        return try {
            Recurso.Exito(
                data = api.getTiempoData(
                    lat = lat,
                    long = long
                ).toTiempoInfo()
            )

        }catch (e:Exception){
            e.printStackTrace()
            Recurso.Error(e.message ?: "Error desconocido")
        }
    }
}
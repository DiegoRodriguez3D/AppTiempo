package com.diegorb.tiempo.data.location

import android.Manifest
import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import androidx.core.content.ContextCompat
import com.diegorb.tiempo.domain.location.LocationTracker
import com.google.android.gms.location.FusedLocationProviderClient
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject
import kotlin.coroutines.resume

class DefaultLocationTracker @Inject constructor(
    private val locationClient: FusedLocationProviderClient,
    private val aplication: Application //Gestion de permisos
): LocationTracker {

    override suspend fun getCurrentLocation(): Location? {

        //Comprueba permisos necesarios para la ubicación
        val hasAccessFineLocationPermission = ContextCompat.checkSelfPermission(
            aplication,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        val hasAccessCoarseLocationPermission = ContextCompat.checkSelfPermission(
            aplication,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        //Comprueba que la ubicación esté activada por parte del usuario
        val locationManager = aplication.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val isGpsEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER) || locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)

        if(!hasAccessCoarseLocationPermission || !hasAccessFineLocationPermission || !isGpsEnabled){
            return null
        }

        //Devuelve la ubicación del usuario y controla los casos en los que de error o se cancele la operacion
        return suspendCancellableCoroutine { cont->
            locationClient.lastLocation.apply {
                if(isComplete){
                    if(isSuccessful)
                        cont.resume(result)
                    else
                        cont.resume(null)

                    return@suspendCancellableCoroutine
                }
                addOnSuccessListener {
                    cont.resume(it)
                }
                addOnFailureListener {
                    cont.resume(null)
                }
                addOnCanceledListener {
                    cont.cancel()
                }
            }
        }
    }
}
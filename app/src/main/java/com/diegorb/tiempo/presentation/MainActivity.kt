package com.diegorb.tiempo.presentation

import android.Manifest
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import com.diegorb.tiempo.presentation.screens.tiempo.TiempoScreen
import com.diegorb.tiempo.presentation.screens.tiempo.TiempoViewModel
import com.diegorb.tiempo.presentation.ui.theme.TiempoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: TiempoViewModel by viewModels()
    private lateinit var permisosLauncher: ActivityResultLauncher<Array<String>>

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Pide los permisos antes de mostrar el Screen del tiempo
        permisosLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ){
            viewModel.loadTiempoInfo()
        }
        permisosLauncher.launch(arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ))

        setContent {
            TiempoTheme {
                TiempoScreen()
            }
        }
    }
}
package com.diegorb.tiempo.presentation.screens.tiempo

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.diegorb.tiempo.presentation.screens.tiempo.components.TiempoContent

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TiempoScreen() {
    Scaffold(
        content = {
            TiempoContent()
        }
    )
}
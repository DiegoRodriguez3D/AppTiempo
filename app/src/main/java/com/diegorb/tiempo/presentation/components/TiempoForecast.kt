package com.diegorb.tiempo.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.diegorb.tiempo.presentation.components.TiempoPorDiaDisplay

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TiempoForecast(
    state: TiempoState,
    modifier: Modifier = Modifier
){
    Column(
        Modifier
            .verticalScroll(rememberScrollState())
            .padding(bottom = 50.dp)
    ) {

        state.tiempoInfo?.tiempoDataPorDia?.get(0)?.let { data->
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "Hoy",
                    fontSize = 20.sp,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(16.dp))

                LazyRow(content = {
                    items(data) {tiempoData ->
                        TiempoPorDiaDisplay(
                            tiempoData = tiempoData,
                            modifier = Modifier
                                .height(100.dp)
                                .padding(horizontal = 16.dp)
                        )
                    }
                })
            }
        }
        
        Spacer(modifier = Modifier.height(50.dp))

        state.tiempoInfo?.tiempoDataPorDia?.get(1)?.let { data->
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "Mañana",
                    fontSize = 20.sp,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(16.dp))

                LazyRow(content = {
                    items(data) {tiempoData ->
                        TiempoPorDiaDisplay(
                            tiempoData = tiempoData,
                            modifier = Modifier
                                .height(100.dp)
                                .padding(horizontal = 16.dp)
                        )
                    }
                })
            }
        }
    }
}
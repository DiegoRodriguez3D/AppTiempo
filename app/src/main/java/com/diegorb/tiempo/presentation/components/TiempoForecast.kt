package com.diegorb.tiempo.presentation.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.diegorb.tiempo.presentation.screens.tiempo.TiempoState
import com.diegorb.tiempo.presentation.ui.theme.DeepBlue
import com.diegorb.tiempo.presentation.ui.theme.LightBlue

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TiempoForecast(
    state: TiempoState,
    modifier: Modifier = Modifier
){
    Column(
        Modifier
            .padding(bottom = 50.dp)
    ) {

        state.tiempoInfo?.tiempoDataPorDia?.get(0)?.let { data->
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Hoy",
                    fontSize = 20.sp,
                    color = Color.White,
                )

                Spacer(modifier = Modifier.height(5.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    backgroundColor = DeepBlue,
                    shape = RoundedCornerShape(10.dp),
                    elevation = 5.dp
                ) {

                    LazyRow(modifier = Modifier.padding(vertical = 16.dp),
                        content = {
                        items(data) {tiempoData ->
                            TiempoPorDiaDisplay(
                                tiempoData = tiempoData,
                                modifier = Modifier
                                    .height(100.dp)
                                    .padding(horizontal = 16.dp),
                                textColor = Color.LightGray
                            )
                        }
                    })
                }
            }
        }

        Divider(
            modifier = Modifier.padding(top = 15.dp, bottom = 5.dp, start = 20.dp, end = 20.dp),
            color = LightBlue,
            thickness = 1.dp,
        )

        state.tiempoInfo?.tiempoDataPorDia?.get(1)?.let { data->
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Mañana",
                    fontSize = 20.sp,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(5.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    backgroundColor = DeepBlue,
                    shape = RoundedCornerShape(10.dp),
                    elevation = 5.dp
                ) {

                    LazyRow(modifier = Modifier.padding(vertical = 16.dp),
                        content = {
                            items(data) {tiempoData ->
                                TiempoPorDiaDisplay(
                                    tiempoData = tiempoData,
                                    modifier = Modifier
                                        .height(100.dp)
                                        .padding(horizontal = 16.dp),
                                    textColor = Color.LightGray
                                )
                            }
                        })
                }
            }
        }
    }
}
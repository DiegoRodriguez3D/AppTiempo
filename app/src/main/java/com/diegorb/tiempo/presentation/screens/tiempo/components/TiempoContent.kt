package com.diegorb.tiempo.presentation.screens.tiempo.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.diegorb.tiempo.presentation.TiempoForecast
import com.diegorb.tiempo.presentation.components.MessageCard
import com.diegorb.tiempo.presentation.components.TiempoCard
import com.diegorb.tiempo.presentation.screens.tiempo.TiempoViewModel
import com.diegorb.tiempo.presentation.ui.theme.DarkBlue
import com.diegorb.tiempo.presentation.ui.theme.DeepBlue
import com.diegorb.tiempo.presentation.ui.theme.DeepRed
import com.diegorb.tiempo.presentation.ui.theme.LightBlue

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TiempoContent(
    viewModel: TiempoViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            LightBlue,
                            DarkBlue,
                            DeepBlue
                        ),
                    )
                )
        ) {
            TiempoCard(
                state = viewModel.state,
                bgColor = Color.Transparent)
            Spacer(modifier = Modifier.height(16.dp))
            TiempoForecast(state = viewModel.state)
        }

        if(viewModel.state.isLoading){
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }

        viewModel.state.error?.let { error->

            MessageCard(
                title = "ATENCIÓN",
                msg = error,
                icon = Icons.Rounded.Warning,
                iconColor = DeepRed,
                modifier = Modifier
                    .align(Alignment.Center))
        }
    }
}
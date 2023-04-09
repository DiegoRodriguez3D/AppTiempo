package com.diegorb.tiempo.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MessageCard(
    title: String,
    msg: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    bgColor: Color = Color.White,
    textColor: Color = Color.Black,
    iconColor: Color = Color.Black
){
    Card(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(20.dp),
        backgroundColor = bgColor,
        shape = RoundedCornerShape(10.dp),
        elevation = 5.dp,
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(modifier = Modifier.padding(top = 8.dp), text = title, fontSize = 20.sp, fontWeight = FontWeight.Bold)

            Divider(
                modifier = Modifier.padding(horizontal = 40.dp, vertical = 3.dp),
                thickness = 2.dp,
                color = Color.LightGray
            )

            Row(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    modifier = Modifier
                        .size(80.dp),
                    imageVector = icon,
                    contentDescription = null,
                    tint = iconColor
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = msg,
                    color = textColor,
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .padding(20.dp)
                )

            }
        }
    }
}
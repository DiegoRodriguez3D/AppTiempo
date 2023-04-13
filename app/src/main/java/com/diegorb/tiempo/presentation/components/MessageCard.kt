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
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(20.dp),
        backgroundColor = bgColor,
        shape = RoundedCornerShape(10.dp),
        elevation = 5.dp,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier
                        .size(40.dp),
                    imageVector = icon,
                    contentDescription = null,
                    tint = iconColor
                )

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = title,
                    textAlign = TextAlign.Center,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Divider(
                modifier = Modifier.padding(horizontal = 40.dp, vertical = 5.dp),
                thickness = 2.dp,
                color = Color.LightGray
            )

            Text(
                text = msg,
                color = textColor,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp, top = 5.dp, bottom = 20.dp)
            )
        }
    }
}
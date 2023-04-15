package com.diegorb.tiempo.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.diegorb.tiempo.presentation.ui.theme.DeepRed

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
        ConstraintLayout(
            modifier = Modifier
                .wrapContentSize()
                .padding(horizontal = 20.dp, vertical = 20.dp)
        ) {

            val (iconID, titleID, msgID, divID) = createRefs()

            Icon(
                modifier = Modifier
                    .size(40.dp)
                    .constrainAs(iconID) {
                        end.linkTo(titleID.start)
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                    },
                imageVector = icon,
                contentDescription = null,
                tint = iconColor
            )

            Text(
                modifier = Modifier
                    .constrainAs(titleID) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                text = title,
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Divider(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 5.dp)
                    .constrainAs(divID) {
                        top.linkTo(titleID.bottom)
                    },
                thickness = 2.dp,
                color = Color.LightGray
            )

            Text(
                modifier = Modifier
                    .padding(top = 15.dp, bottom = 20.dp)
                    .constrainAs(msgID) {
                        top.linkTo(divID.bottom)
                        bottom.linkTo(parent.bottom)
                    },
                text = msg,
                color = textColor,
                textAlign = TextAlign.Start,
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun previewMessage() {
    val error =
        "No se pudo recuperar la ubicación del dispositivo. Asegúrate de activar la ubicación y conceder los permisos necesarios."
    MessageCard(
        title = "Advertencia",
        msg = error,
        icon = Icons.Rounded.Warning,
        iconColor = DeepRed
    )
}
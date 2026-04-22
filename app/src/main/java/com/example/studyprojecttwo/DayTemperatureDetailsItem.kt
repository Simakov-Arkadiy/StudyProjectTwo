package com.example.studyprojecttwo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable

@Composable
internal fun DayTemperatureDetailsItem(imagId: Int, averageDayTemperatureDetails: Int?){
    Column(verticalArrangement = Arrangement.SpaceEvenly) {
        Box(modifier = Modifier.height(50.dp).width(50.dp)){
            Image(
                bitmap = ImageBitmap.imageResource(imagId),
                contentDescription = "облачно",
                contentScale = ContentScale.Fit
            )
        }
        Text(
            text = "${averageDayTemperatureDetails.toString()}  *C",
            color = Color.Black,
            fontSize = 26.sp,
        )
    }
}

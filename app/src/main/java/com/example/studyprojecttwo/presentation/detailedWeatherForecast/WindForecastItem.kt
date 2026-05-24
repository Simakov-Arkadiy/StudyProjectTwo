package com.example.studyprojecttwo.presentation.detailedWeatherForecast

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studyprojecttwo.domain.DetailedWeatherForecast

@Composable
internal fun WindForecastItem(items: DetailedWeatherForecast?) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(Color.White, shape = RoundedCornerShape(25.dp))
            .padding(15.dp, 10.dp)
    ) {
        Text(
            text = "Ветер, м/с.",
            color = Color.Black,
            fontSize = 25.sp
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp, 10.dp)
                .align(Alignment.Center)
        ) {
            Text(
                text = items?.morningForecast?.averageWindSpeed.toString(),
                color = Color.Black,
                fontSize = 25.sp,
            )
            Text(
                text = items?.dayForecast?.averageWindSpeed.toString(),
                color = Color.Black,
                fontSize = 25.sp,
            )
            Text(
                text = items?.eveningForecast?.averageWindSpeed.toString(),
                color = Color.Black,
                fontSize = 25.sp,
            )
            Text(
                text = items?.nightForecast?.averageWindSpeed.toString(),
                color = Color.Black,
                fontSize = 25.sp,
            )
        }
    }
}
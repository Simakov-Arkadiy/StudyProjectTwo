package com.example.studyprojecttwo.presentation.dailyWeatherForecast

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.clickable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.compose.ui.Alignment
import com.example.studyprojecttwo.domain.DailyWeatherForecast
import com.example.studyprojecttwo.ui.theme.BackgroundColorForDayTemperatureItem
import com.example.studyprojecttwo.ui.theme.ColorForMinorText
import java.text.SimpleDateFormat
import java.util.Locale


@Composable
internal fun DailyWeatherForecastItem(
    item: DailyWeatherForecast,
    controller: NavHostController,
) {
    val dayFormatter = remember() { SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()) }
    val dayFormatterTwo = remember() { SimpleDateFormat("EEEE", Locale.getDefault()) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(BackgroundColorForDayTemperatureItem, shape = RoundedCornerShape(26.dp))
            .padding(16.dp, 10.dp)
            .clickable(onClick = {
                controller.navigate(
                    "DetailedWeatherForecastScreen/${item.date}"
                )
            })
    ) {
        Column {
            Text(text = item.date, color = ColorForMinorText, fontSize = 20.sp)
            Text(
                text = dayFormatterTwo.format(dayFormatter.parse(item.date)),
                color = Color.White,
                fontSize = 22.sp
            )
        }
        Text(
            text = "${item.weatherInfo.averageTemperature} *C",
            color = Color.White,
            fontSize = 26.sp
        )
    }
}

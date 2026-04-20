package com.example.studyprojecttwo

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
import androidx.navigation.NavHostController
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource


@Composable
fun WeatherForecast(weather:WeatherForecastForDay,controller:NavHostController){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(Color(54,67,112), shape = RoundedCornerShape(25.dp))
            .padding(15.dp, 10.dp)
            .clickable(onClick = {
                controller.navigate(
                    "HourlyWeatherForecastScreen/${weather.hourlyWeather.temperatureInTheMorning}/" +
                            "${weather.hourlyWeather.temperatureInTheDay}/" +
                            "${weather.hourlyWeather.temperatureInTheEvening}/" +
                            "${weather.hourlyWeather.temperatureInTheNight}"
                )
            })
    ) {
        Column {
            Text(text = weather.data, color = Color(159,168,207), fontSize = 20.sp)
            Text(text = stringResource(weather.dayOfTheWeek), color = Color.White, fontSize = 22.sp)
        }
        Text(
            text = "${weather.temperature}" + " *C",
            color = Color.White,
            fontSize = 25.sp
        )
    }
}

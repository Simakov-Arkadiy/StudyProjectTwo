package com.example.studyprojecttwo.domain

import androidx.compose.runtime.remember
import java.text.SimpleDateFormat
import java.util.Locale


internal data class DailyWeatherForecast(
    val date: String,
    val weatherInfo: WeatherInfoShort,
)
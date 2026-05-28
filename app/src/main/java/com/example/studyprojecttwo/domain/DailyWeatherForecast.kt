package com.example.studyprojecttwo.domain

import androidx.room3.Embedded
import androidx.room3.Entity
import androidx.room3.PrimaryKey
import java.util.Date

@Entity
internal data class DailyWeatherForecast(
    @PrimaryKey
    val id:Long,
    @Embedded
    val date: Date,
    @Embedded
    val weatherInfo: WeatherInfoShort,
)
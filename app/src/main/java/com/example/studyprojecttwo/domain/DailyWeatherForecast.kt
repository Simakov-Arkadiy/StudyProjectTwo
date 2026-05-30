package com.example.studyprojecttwo.domain

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class DailyWeatherForecast(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val date: Date,
    @Embedded
    val weatherInfo: WeatherInfoShort,
)
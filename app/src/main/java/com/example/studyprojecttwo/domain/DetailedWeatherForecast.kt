package com.example.studyprojecttwo.domain

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DetailedWeatherForecast(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val date: String,
    @Embedded(prefix = "morning")
    val morningForecast: WeatherInfoAdvanced,
    @Embedded(prefix = "day")
    val dayForecast: WeatherInfoAdvanced,
    @Embedded(prefix = "evening")
    val eveningForecast: WeatherInfoAdvanced,
    @Embedded(prefix = "night")
    val nightForecast: WeatherInfoAdvanced,
)
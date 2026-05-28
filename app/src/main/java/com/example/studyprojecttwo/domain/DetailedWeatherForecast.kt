package com.example.studyprojecttwo.domain

import androidx.room3.Embedded
import androidx.room3.Entity
import androidx.room3.PrimaryKey

@Entity
internal data class DetailedWeatherForecast(
    @PrimaryKey
    val id:Long,
    val date: String?,
    @Embedded
    val morningForecast: WeatherInfoAdvanced,
    @Embedded
    val dayForecast: WeatherInfoAdvanced,
    @Embedded
    val eveningForecast: WeatherInfoAdvanced,
    @Embedded
    val nightForecast: WeatherInfoAdvanced,
)
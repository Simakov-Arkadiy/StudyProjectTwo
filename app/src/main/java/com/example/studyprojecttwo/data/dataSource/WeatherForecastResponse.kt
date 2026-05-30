package com.example.studyprojecttwo.data.dataSource

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class WeatherForecastResponse(
    @SerialName("hourly") val hourlyDto: HourlyDto,
    @SerialName("daily") val dailyDto: DailyDto,
)

@Serializable
data class HourlyDto(
    @SerialName("time") val dateTimes: List<String>,
    @SerialName("temperature_2m") val averageTemperature: List<Float?>,
    @SerialName("wind_speed_10m") val averageWindSpeed: List<Float?>,
)

@Serializable
data class DailyDto(
    @SerialName("time") val dates: List<String?>,
    @SerialName("temperature_2m_max") val averageTemperature: List<Float?>,
)
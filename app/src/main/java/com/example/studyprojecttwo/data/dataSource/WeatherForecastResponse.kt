package com.example.studyprojecttwo.data.dataSource

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class WeatherForecastResponse(

    @SerialName("hourly") val hourlyDto: HoгrlyDto,
    @SerialName("daily") val dailyDto: DailyDto,
)


@Serializable
data class HoгrlyDto(
    @SerialName("time") val time: List<String>,
    @SerialName("temperature_2m") val temperatureM: List<Float>,
    @SerialName("wind_speed_10m") val windSpeed: List<Float>,
)

@Serializable
data class DailyDto(
    @SerialName("time") val time: List<String>,
    @SerialName("temperature_2m_max") val temperatureM: List<Float>,
)
package com.example.studyprojecttwo.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class APIModel(

    @SerialName("hourly") val hourly: Horly,
    @SerialName("daily") val daily: Daily,
)

@Serializable
data class Horly(
    @SerialName("time") val time: List<String>,
    @SerialName("temperature_2m") val temperatureM: List<Float>,
    @SerialName("wind_speed_10m") val windSpeed: List<Float>
)

@Serializable
data class Daily(
    @SerialName("time") val time: List<String>,
    @SerialName("temperature_2m_max") val temperatureM: List<Float>
)
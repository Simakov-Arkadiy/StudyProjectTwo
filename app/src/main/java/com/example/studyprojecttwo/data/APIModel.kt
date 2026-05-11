package com.example.studyprojecttwo.data

import com.google.gson.annotations.SerializedName

data class APIModel(

    val hourly: Horly,
    val daily: Daily,
)

data class Horly(
    val time: List<String>,
    @SerializedName("temperature_2m") val temperatureM: List<Float>,
    @SerializedName("wind_speed_10m") val windSpeed: List<Float>
)

data class Daily(
    val time: List<String>,
    @SerializedName("temperature_2m_max") val temperatureM: List<Float>
)
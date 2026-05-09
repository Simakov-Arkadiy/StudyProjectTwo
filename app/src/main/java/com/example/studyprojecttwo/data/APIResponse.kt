package com.example.studyprojecttwo.data

import com.google.gson.annotations.SerializedName


data class APIResponse(

    val hourly: Horly,
    @SerializedName("hourly_units")
    val hourlyUnits: HourlyUnits,
    val daily: Daily,
    @SerializedName("daily_units")
    val dailyUnit: DailyUnit
)


data class Horly(val time: List<String>, @SerializedName("temperature_2m") val temperatureM: List<Float>, @SerializedName("wind_speed_10m") val windSpeed: List<Float>)


data class HourlyUnits(@SerializedName("temperature_2m") val temperatureM: String,@SerializedName("wind_speed_10m") val windSpeed:String )


data class Daily(val time: List<String>,@SerializedName("temperature_2m") val temperatureM: List<Float>)


data class DailyUnit(@SerializedName("temperature_2m") val temperatureM: List<String>)
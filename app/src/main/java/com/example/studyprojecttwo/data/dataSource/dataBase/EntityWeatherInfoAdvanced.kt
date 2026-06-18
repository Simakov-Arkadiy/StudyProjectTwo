package com.example.studyprojecttwo.data.dataSource.dataBase

data class EntityWeatherInfoAdvanced(
    val averageTemperature: Float,
    val averageWindSpeed: Float,
    val precipitation: EntityPrecipitation,
)
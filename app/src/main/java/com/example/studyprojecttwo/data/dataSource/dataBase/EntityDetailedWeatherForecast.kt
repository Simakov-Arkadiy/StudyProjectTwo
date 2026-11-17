package com.example.studyprojecttwo.data.dataSource.dataBase

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class EntityDetailedWeatherForecast(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val date: Date,
    @Embedded(prefix = "morning")
    val morningForecast: EntityWeatherInfoAdvanced,
    @Embedded(prefix = "day")
    val dayForecast: EntityWeatherInfoAdvanced,
    @Embedded(prefix = "evening")
    val eveningForecast: EntityWeatherInfoAdvanced,
    @Embedded(prefix = "night")
    val nightForecast: EntityWeatherInfoAdvanced,
)
package com.example.studyprojecttwo.data.dataSource.dataBase

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class EntityDailyWeatherForecast(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val date: Date,
    @Embedded
    val weatherInfo: EntityWeatherInfoShort,
)
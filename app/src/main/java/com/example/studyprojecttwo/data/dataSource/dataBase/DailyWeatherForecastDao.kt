package com.example.studyprojecttwo.data.dataSource.dataBase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.studyprojecttwo.domain.DailyWeatherForecast

@Dao
interface DailyWeatherForecastDao {
    @Query("SELECT * FROM dailyWeatherForecast")
    suspend fun getAll(): List<DailyWeatherForecast>

    @Insert
    suspend fun setEntities(dailyWeatherForecast: List<DailyWeatherForecast>)

    @Delete
    suspend fun deleteAll(dailyWeatherForecast: List<DailyWeatherForecast>)
}
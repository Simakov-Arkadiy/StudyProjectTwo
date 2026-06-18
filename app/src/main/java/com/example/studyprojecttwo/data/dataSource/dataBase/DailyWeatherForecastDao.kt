package com.example.studyprojecttwo.data.dataSource.dataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DailyWeatherForecastDao {
    @Query("SELECT * FROM entityDailyWeatherForecast")
    fun getAll(): Flow<List<EntityDailyWeatherForecast>>

    @Insert
    suspend fun setEntities(dailyWeatherForecast: List<EntityDailyWeatherForecast>)

    @Query("DELETE FROM entityDailyWeatherForecast")
    suspend fun deleteAll()
}
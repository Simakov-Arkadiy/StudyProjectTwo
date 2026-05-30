package com.example.studyprojecttwo.data.dataSource.dataBase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.studyprojecttwo.domain.DetailedWeatherForecast

@Dao
interface DetailedWeatherForecastDao {
    @Query("SELECT DISTINCT * FROM detailedWeatherForecast WHERE date = :date")
    suspend fun getByDate(date: String): DetailedWeatherForecast

    @Insert
    suspend fun setEntities(detailedWeatherForecast: List<DetailedWeatherForecast>)

    @Delete
    suspend fun deleteAll(detailedWeatherForecast: List<DetailedWeatherForecast>)
}
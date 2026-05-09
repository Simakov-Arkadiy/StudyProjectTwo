package com.example.studyprojecttwo.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService{
    @GET
    suspend fun getWeather(
        @Query("latitude") latitude:Double,
        @Query("longitude") longitude:Double,
        @Query("daily") daily:String,
        @Query("hourly")hourly:String,
        @Query("current")current:String,
        @Query("timezone")timezone:String,
        @Query("forecast_days")forecatDay:Int,
        @Query("wind_speed_unit")windspeedunit:String
        //https://api.open-meteo.com/v1/forecast?latitude=52.26&longitude=65.2&daily=temperature_2m_max&hourly=temperature_2m,wind_speed_10m&current=temperature_2m,wind_speed_10m&timezone=GMT&forecast_days=16&wind_speed_unit=ms
    ):APIResponse
}
object RetrofitClient {
    private const val BASE_URL = "https://api.open-meteo.com/v1/forecast"

    val apiService: WeatherApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApiService::class.java)
    }
}

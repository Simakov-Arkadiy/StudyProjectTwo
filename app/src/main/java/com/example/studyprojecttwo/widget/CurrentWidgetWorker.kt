package com.example.studyprojecttwo.widget

import android.content.Context
import androidx.glance.appwidget.updateAll
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.studyprojecttwo.domain.DailyWeatherForecast
import com.example.studyprojecttwo.domain.ObserveDailyWeatherForecastUseCase
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.first

@HiltWorker
internal class WidgetWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters,
    val observeDailyWeatherForecastUseCase: ObserveDailyWeatherForecastUseCase,
) : CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {
        val weatherForecastList = observeDailyWeatherForecastUseCase.invoke().first()
        WeatherPreferences.saveForecast(applicationContext, weatherForecastList)
        CurrentWeatherWidget().updateAll(applicationContext)
        return Result.success()
    }
}

object WeatherPreferences {
    private const val KEY_FORECAST_JSON = "forecast_json"
    fun saveForecast(context: Context, forecast: List<DailyWeatherForecast>) {
        val gson = Gson()
        val json = gson.toJson(forecast)
        val pref = context.getSharedPreferences("weather_widget_prefs", Context.MODE_PRIVATE)
        pref.edit().apply {
            putString(KEY_FORECAST_JSON, json)
            apply()
        }
    }

    fun loadForecast(context: Context): List<DailyWeatherForecast> {
        val pref = context.getSharedPreferences("weather_widget_prefs", Context.MODE_PRIVATE)
        val json = pref.getString(KEY_FORECAST_JSON, null)
        return if (json != null) {
            val gson = Gson()
            val type = object : TypeToken<List<DailyWeatherForecast>>() {}.type
            gson.fromJson(json, type) ?: emptyList()
        } else {
            emptyList()
        }
    }
}
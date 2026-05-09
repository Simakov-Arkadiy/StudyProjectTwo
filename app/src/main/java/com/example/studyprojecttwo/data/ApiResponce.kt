package com.example.studyprojecttwo.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ApiResponce {

    fun fetchWeather() {
        val scope = CoroutineScope(Job())
        val differed = scope.async {

            val response = RetrofitClient.apiService.getWeather(
                55.4636,
                65.3431,
                "temperature_2m_max",
                "temperature_2m,wind_speed_10m",
                "temperature_2m,wind_speed_10m",
                "GMT+5",
                16,
                "ms"
            )
            val result: APIResponse = response
            result
        }
    }
}
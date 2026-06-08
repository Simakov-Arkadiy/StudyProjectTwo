package com.example.studyprojecttwo.data.dataSource

import android.app.Application
import androidx.work.Constraints
import androidx.work.ExistingWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.studyprojecttwo.data.WeatherForecastWorker
import jakarta.inject.Inject

internal class StartPeriodicUpdateWeatherForecastUseCase @Inject constructor() {
    fun invoke(application: Application) {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        val workRequest =
            OneTimeWorkRequestBuilder<WeatherForecastWorker>()
                .setConstraints(constraints)
                .build()
        WorkManager.getInstance(application).enqueueUniqueWork(
            "WeatherUpdateWorkUniqueSingle",
            ExistingWorkPolicy.REPLACE,
            workRequest
        )
    }
}
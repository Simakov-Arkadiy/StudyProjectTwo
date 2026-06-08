package com.example.studyprojecttwo.data

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.studyprojecttwo.data.dataSource.UpdateWeatherForecastUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
internal class WeatherForecastWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters,
   val updateWeatherForecastUseCase: UpdateWeatherForecastUseCase,
) : CoroutineWorker(appContext, workerParams) {


    override suspend fun doWork(): Result {
        updateWeatherForecastUseCase.invoke()
        return Result.success()
    }
}

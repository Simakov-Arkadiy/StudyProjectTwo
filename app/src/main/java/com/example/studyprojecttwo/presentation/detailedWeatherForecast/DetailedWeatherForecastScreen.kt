package com.example.studyprojecttwo.presentation.detailedWeatherForecast

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalUriHandler
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.studyprojecttwo.R
import com.example.studyprojecttwo.domain.Precipitation
import com.example.studyprojecttwo.ui.theme.BackgroundColorForDayTemperatureDetailsScreen

@Composable
internal fun DetailedWeatherForecastScreen(
    controller: NavHostController,
    viewModel: DetailedWeatherForecastViewModel = hiltViewModel(),
    date: String,
) {
    val items = viewModel.item.collectAsState()

    BackHandler {
        controller.popBackStack()
    }
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColorForDayTemperatureDetailsScreen)
            .padding(10.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.morning), color = Color.Black, fontSize = 25.sp)
            Text(text = stringResource(R.string.day), color = Color.Black, fontSize = 25.sp)
            Text(text = stringResource(R.string.evening), color = Color.Black, fontSize = 25.sp)
            Text(text = stringResource(R.string.night), color = Color.Black, fontSize = 25.sp)
        }
        items.let { mrr ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Color.White, shape = RoundedCornerShape(25.dp))
                    .padding(15.dp, 10.dp)
            ) {
                DetailedWeatherForecastTemperatureItem(
                    mrr.value?.morningForecast?.precipitation?.getImageId() ?: R.drawable.sunny,
                    mrr.value?.morningForecast?.averageTemperature ?: 0f
                )
                DetailedWeatherForecastTemperatureItem(
                    mrr.value?.dayForecast?.precipitation?.getImageId() ?: R.drawable.sunny,
                    mrr.value?.dayForecast?.averageTemperature ?: 0f
                )
                DetailedWeatherForecastTemperatureItem(
                    mrr.value?.eveningForecast?.precipitation?.getImageId() ?: R.drawable.sunny,
                    mrr.value?.eveningForecast?.averageTemperature ?: 0f
                )
                DetailedWeatherForecastTemperatureItem(
                    mrr.value?.nightForecast?.precipitation?.getImageId() ?: R.drawable.sunny,
                    mrr.value?.nightForecast?.averageTemperature ?: 0f
                )
            }
            WindForecastItem(mrr.value)
        }

        val uriHandler = LocalUriHandler.current
        AdvertisingBannerItem(uriHandler)
    }
}

internal fun Precipitation.getImageId(): Int {
    when (this) {
        Precipitation.SUNNY -> return R.drawable.sunny
        Precipitation.LIGHT_RAIN -> return R.drawable.lightrain
        Precipitation.SNOW -> return R.drawable.snow
        Precipitation.CLOUDY -> return R.drawable.cloudy
        else -> return R.drawable.sunny
    }
}
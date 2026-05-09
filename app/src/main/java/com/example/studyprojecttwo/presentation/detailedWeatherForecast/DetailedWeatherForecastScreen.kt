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
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.platform.LocalUriHandler
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.studyprojecttwo.R
import com.example.studyprojecttwo.ui.theme.BackgroundColorForDayTemperatureDetailsScreen
import com.example.studyprojecttwo.ui.theme.ColorForMinorText
import dagger.hilt.android.AndroidEntryPoint


@Composable
internal fun DetailedWeatherForecastScreen(
    controller: NavHostController,
    viewModel: DetailedWeatherForecastViewModel = hiltViewModel(),
    date: Long,
) {

    val items = viewModel.items.collectAsState()

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
                    mrr.value.morningForecast.precipitation.value,
                    mrr.value.morningForecast.averageTemperature
                )
                DetailedWeatherForecastTemperatureItem(
                    mrr.value.dayForecast.precipitation.value,
                    mrr.value.dayForecast.averageTemperature
                )
                DetailedWeatherForecastTemperatureItem(
                    mrr.value.eveningForecast.precipitation.value,
                    mrr.value.eveningForecast.averageTemperature
                )
                DetailedWeatherForecastTemperatureItem(
                    mrr.value.nightForecast.precipitation.value,
                    mrr.value.nightForecast.averageTemperature
                )
            }
        }
        items.let { trr ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Color.White, shape = RoundedCornerShape(25.dp))
                    .padding(15.dp, 10.dp)
            ) {
                Text(
                    text = "Ветер, м/с.",
                    color = Color.Black,
                    fontSize = 25.sp
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp, 10.dp)
                        .align(Alignment.Center)
                ) {
                    Text(
                        text = trr.value.morningForecast.averageWindSpeed.toString() ,
                        color = Color.Black,
                        fontSize = 25.sp,
                    )
                    Text(
                        text = trr.value.dayForecast.averageWindSpeed.toString(),
                        color = Color.Black,
                        fontSize = 25.sp,
                    )
                    Text(
                        text = trr.value.eveningForecast.averageWindSpeed.toString(),
                        color = Color.Black,
                        fontSize = 25.sp,
                    )
                    Text(
                        text = trr.value.nightForecast.averageWindSpeed.toString(),
                        color = Color.Black,
                        fontSize = 25.sp,
                    )
                }
            }
        }

        val uriHandler = LocalUriHandler.current
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .background(Color.White, shape = RoundedCornerShape(25.dp))
                .padding(15.dp, 10.dp)
                .clickable(onClick = { uriHandler.openUri("https://alfabank.ru/sme/raschetnyj-schet/") }),
            contentAlignment = Alignment.BottomCenter
        ) {
            Row(modifier = Modifier.offset(x = -70.dp, y = -190.dp)) {
                Text(text = "alfabank.ru", color = Color.Black, fontSize = 15.sp)
                Text(text = "  Реклама", color = ColorForMinorText, fontSize = 15.sp)
            }
            Image(
                bitmap = ImageBitmap.imageResource(R.drawable.advertising),
                contentDescription = "реклама",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxWidth(),
            )
        }
    }
}
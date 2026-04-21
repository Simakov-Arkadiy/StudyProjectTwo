package com.example.studyprojecttwo

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
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.platform.LocalUriHandler

@Composable
fun HourlyWeatherForecastScreen(
    controller: NavHostController,
    // TODO: заменить параметры на модельку details и убрать вопросики
    morning: Int?,
    day: Int?,
    evening: Int?,
    night: Int?
) {
    BackHandler {
        controller.popBackStack()  // Возврат на предыдущий экран
    }
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(241, 242, 246))
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
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.White, shape = RoundedCornerShape(25.dp))
                .padding(15.dp, 10.dp)
        ) {
            WeatherForTimeOfDay(R.drawable.cloudy,morning)
            WeatherForTimeOfDay(R.drawable.snow,evening)
            WeatherForTimeOfDay(R.drawable.sunny,day)
            WeatherForTimeOfDay(R.drawable.lightrain,night)
        }
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
                    text = "5",
                    color = Color.Black,
                    fontSize = 25.sp
                )
                Text(
                    text = "7",
                    color = Color.Black,
                    fontSize = 25.sp
                )
                Text(
                    text = "2",
                    color = Color.Black,
                    fontSize = 25.sp
                )
                Text(
                    text = "0",
                    color = Color.Black,
                    fontSize = 25.sp
                )
            }
        }
        val uriHandler = LocalUriHandler.current
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .background(Color.White, shape = RoundedCornerShape(25.dp))
            .padding(15.dp, 10.dp).clickable(onClick = {uriHandler.openUri("https://alfabank.ru/sme/raschetnyj-schet/")}),
            contentAlignment = Alignment.BottomCenter){
            Row(modifier = Modifier.offset(x = -70.dp,y = -190.dp)){
                Text(text = "alfabank.ru", color = Color.Black,fontSize = 15.sp)
                Text(text = "  Реклама",color = Color(161,162,167),fontSize = 15.sp)
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
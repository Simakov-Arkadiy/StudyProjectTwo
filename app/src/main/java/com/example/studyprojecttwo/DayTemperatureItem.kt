package com.example.studyprojecttwo

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.clickable
import androidx.navigation.NavHostController
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import java.time.format.DateTimeFormatter
import java.util.Date

@Composable
internal fun DayTemperatureItem(
    item: DayTemperature,
    onClick: () -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(Color(54, 67, 112), shape = RoundedCornerShape(25.dp))
            .padding(16.dp, 10.dp)
            .clickable { onClick.invoke() }
    ) {
        // TODO: вынести цвета также
        // TODO: написать свою экстеншен функцию для форматирования item.date (класс Date) в строчку для отображения
        Column {
            Text(
                text = item.date.formatted(),
                color = Color(159, 168, 207),
                fontSize = 20.sp,
            )
            Text(
                // TODO: еще экстеншен для форматирования
                text = stringResource(weather.dayOfTheWeek),
                color = Color.White,
                fontSize = 22.sp,
            )
        }
        Text(
            text = "${item.averageTemperature} *C",
            color = Color.White,
            fontSize = 25.sp
        )
    }
}

private fun Date.formatted(): String {
    //TODO: вот подсказка
    //DateTimeFormatter
}

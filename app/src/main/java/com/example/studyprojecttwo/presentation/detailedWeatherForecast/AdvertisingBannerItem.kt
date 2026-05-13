package com.example.studyprojecttwo.presentation.detailedWeatherForecast

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studyprojecttwo.R
import com.example.studyprojecttwo.ui.theme.ColorForMinorText

@Composable
internal fun AdvertisingBannerItem(
    uriHandler: UriHandler
) {
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
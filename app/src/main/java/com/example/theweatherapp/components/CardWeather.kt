package com.example.theweatherapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.theweatherapp.R
import com.example.theweatherapp.ui.theme.DarkBlue

@Composable
fun CardWeather(label: String, value: String, icon: ImageVector) {
    Card(Modifier
        .size(150.dp)
        .padding(8.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(6.dp)){
        Column(Modifier
            .fillMaxSize()
            .padding(8.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top) {

            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start) {
                Icon(imageVector = icon, contentDescription =
                null,
                    Modifier.size(24.dp))
                Spacer(Modifier.width(6.dp))
                Text(text = label,
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = DarkBlue))
            }
            Spacer(Modifier.height(8.dp))

            Box(Modifier.fillMaxWidth()
                .weight(1f),
                contentAlignment = Alignment.Center){

                Text(text = value,
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = DarkBlue
                    )
                )
            }
        }
    }
}

@Preview
@Composable
private fun CardWeatherPreview() {
    CardWeather("Cu de cachorro", "10",
        ImageVector.vectorResource(id = R.drawable.ic_launcher_foreground))
}
package com.example.theweatherapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.theweatherapp.R

@Composable
fun CardWeather(label: String, value: String, icon: ImageVector) {
    Card(Modifier
        .size(150.dp)
        .padding(8.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(6.dp)){
        Column(Modifier
            .fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top) {
            Row {}
        }
    }
}

@Preview
@Composable
private fun CardWeatherPreview() {
    CardWeather("Cu de cachorro", "10",
        ImageVector.vectorResource(id = R.drawable.ic_launcher_foreground))
}
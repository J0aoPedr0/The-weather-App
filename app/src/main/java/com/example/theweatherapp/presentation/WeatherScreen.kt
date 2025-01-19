@file:Suppress("UNREACHABLE_CODE")

package com.example.theweatherapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.theweatherapp.R
import com.example.theweatherapp.ui.theme.DarkBlue
import com.example.theweatherapp.ui.theme.Pink40
import com.example.theweatherapp.ui.theme.Purple40
import com.example.theweatherapp.ui.theme.Purple80
import com.example.theweatherapp.ui.theme.PurpleGrey40
import com.example.theweatherapp.ui.theme.PurpleGrey80
import com.example.theweatherapp.ui.theme.TheWeatherAppTheme
import com.example.theweatherapp.view_model.WeatherViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherScreen(viewModel: WeatherViewModel) {
    val weatherData by viewModel.weatherData.collectAsState()
    var city by remember {
        mutableStateOf(value = "")
    }
    val apiKey = "52f6a1b6489a878343b670e1be7174e5"

    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.weather_image2),
                contentScale = ContentScale.FillBounds
            )
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(Modifier.height(180.dp))
            OutlinedTextField(
                value = city,
                onValueChange = { newValue -> city = newValue },
                Modifier
                    .fillMaxWidth()
                    .padding(bottom = 50.dp),
                label = {
                    Text(
                        text = "Enter city:",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                placeholder = { Text(text = "City name") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(24.dp),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                )
            )
            Button(
                onClick = { viewModel.fetchWeather(city, apiKey) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Pink40,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Get Weather", style = TextStyle(
                        fontSize = 16.sp,
                    )
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WeatherScreenPreview() {
    TheWeatherAppTheme {
        WeatherScreen(WeatherViewModel())
    }
}
package com.example.domain

data class WeatherStatus(
        val description: String,
        val temperature: Double,
        val feelsLike: Double,
        val tempMin: Double,
        val tempMax: Double
)
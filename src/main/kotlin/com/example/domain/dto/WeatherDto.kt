package com.example.domain.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class WeatherDto(
        val id: Int,
        val main: String,
        val description: String,
        val icon: String
)
package com.example.domain.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class WeatherResponseDto(
    val coord: CoordDto,
    val weather: List<WeatherDto> = emptyList(),
    val main: MainDto
)
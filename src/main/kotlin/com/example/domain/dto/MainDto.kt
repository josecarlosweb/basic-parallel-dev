package com.example.domain.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class MainDto(
        val temp: Double,
        @JsonProperty("feels_like")
        val feelsLike: Double,
        @JsonProperty("temp_min")
        val tempMin: Double,
        @JsonProperty("temp_max")
        val tempMax: Double,
        val pressure: Int,
        val humidity: Int
)
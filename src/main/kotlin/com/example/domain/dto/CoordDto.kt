package com.example.domain.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class CoordDto(
        val lat: Double? = null,
        val lon: Double? = null
)
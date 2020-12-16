package com.example.util

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class TemperatureConverterKtTest {

    @Test
    fun fromFahrenheitToCelsius() {
        val temp = 308.24
        val inCelsius = fromKelvinToCelsius(temp)
        println(inCelsius)
    }
}
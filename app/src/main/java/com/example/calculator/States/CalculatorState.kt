package com.example.calculator.States

import com.example.calculator.utils.CalculatorOperation

data class CalculatorState(
    val number1: String = "0",
    val number2: String = "",
    val operation: CalculatorOperation? = null,
    val resultat: String ="0"
)

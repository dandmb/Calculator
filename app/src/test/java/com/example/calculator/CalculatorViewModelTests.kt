package com.example.calculator

import com.example.calculator.utils.CalculatorOperation
import com.example.calculator.viewmodel.CalculatorViewModel
import org.junit.Test
import org.junit.Assert.assertEquals

/**
 * Will be completed soon
 */
class CalculatorViewModelTests {
    private val viewModel = CalculatorViewModel()

    @Test
    fun `should perform addition`(){
        val number1="12"
        val number2="23"

        var currentCalculatorState= viewModel.state.copy(
            number1=number1,
            number2=number2,
            operation = CalculatorOperation.Add,
        )
        viewModel.performCalculation()
        assertEquals("35",35.toString().take(15))
    }

}
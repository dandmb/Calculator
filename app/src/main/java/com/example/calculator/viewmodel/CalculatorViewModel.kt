package com.example.calculator.viewmodel

import androidx.annotation.VisibleForTesting
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.calculator.Events.CalculatorAction
import com.example.calculator.States.CalculatorState
import com.example.calculator.utils.CalculatorOperation

class CalculatorViewModel:ViewModel() {


    var state by mutableStateOf(CalculatorState())
        private  set


    fun onAction(action: CalculatorAction) {
        when(action){
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Clear -> state = CalculatorState()
            is CalculatorAction.Operation -> enterOperation(action.operation)
            is CalculatorAction.Calculate -> performCalculation()
            is CalculatorAction.Delete -> performDeletion()
        }
    }

    @VisibleForTesting
    internal fun performDeletion() {
        when{
            state.number2.isNotBlank() -> state=state.copy(
                number2 = state.number2.dropLast(1)
            )
            state.operation != null -> state = state.copy(
                operation = null,
                resultat = "0"
            )
            state.number1.isNotBlank().and(state.number1 !="0") -> state = state.copy(
                number1=state.number1.dropLast(1),
                resultat = "0"
            )
        }
    }

    @VisibleForTesting
    internal fun performCalculation() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        if (number1 != null && number2 != null){
            val result = when(state.operation){
                is CalculatorOperation.Add -> number1 + number2
                is CalculatorOperation.Subtract -> number1 - number2
                is CalculatorOperation.Multiply -> number1 * number2
                is CalculatorOperation.Divide -> number1 / number2
                null -> return
            }
            state = state.copy(
                number1=result.toString().take(15),
                number2="",
                operation = null,
                resultat = "=${result.toString().take(15)}"
            )
        }


    }

    @VisibleForTesting
    internal fun enterOperation(operation: CalculatorOperation) {
        if (state.number1.isNotBlank()){
            state = state.copy(operation = operation)
        }
    }

    @VisibleForTesting
    internal fun enterDecimal() {
        if (state.operation == null && !state.number1.contains(".") && state.number1.isNotBlank()){
            state= state.copy(
                number1 = state.number1 + "."
            )
            return
        }
        if (!state.number2.contains(".") && state.number2.isNotBlank()){
            state= state.copy(
                number1 = state.number2 + "."
            )
        }
    }

    @VisibleForTesting
    internal fun enterNumber(number: Int) {
        if(state.operation == null){
            if(state.number1.length >= MAX_NUM_LENGTH){
                return
            }
            if(state.number1 == "0" && state.number1.length == 1) {
                state=state.copy(
                    number1 = number.toString()
                )

            }else{
                state=state.copy(
                    number1 = state.number1 + number
                )
            }

            return

        }
        if(state.number1.length >= MAX_NUM_LENGTH){
            return
        }
        state=state.copy(
            number2 = state.number2 + number
        )

    }
    companion object{
        private const val MAX_NUM_LENGTH = 8
    }
}
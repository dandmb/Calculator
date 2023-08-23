package com.example.calculator.ui.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.CalculatorButton
import com.example.calculator.Events.CalculatorAction
import com.example.calculator.States.CalculatorState
import com.example.calculator.ui.theme.LightGray
import com.example.calculator.ui.theme.Orange
import com.example.calculator.utils.CalculatorOperation

@Composable
fun Calculator(
    state: CalculatorState,
    buttonSpacing: Dp,
    modifier: Modifier = Modifier,
    onAction : (CalculatorAction) -> Unit
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {

            MyView(
                state.number1 + (state.operation?.symbol ?: "") + state.number2,
            )
            MyView(
                state.resultat,
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
            ) {
                CalculatorButton(
                    symbol = "AC",
                    modifier = Modifier
                        .background(LightGray)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction(CalculatorAction.Clear)
                    }
                )
                CalculatorButton(
                    symbol = "Del",
                    modifier = Modifier
                        .background(LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Delete)
                    }
                )
                CalculatorButton(
                    symbol = "/",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
                    }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "7",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(7))
                    }
                )
                CalculatorButton(
                    symbol = "8",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(8))
                    }
                )
                CalculatorButton(
                    symbol = "9",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(9))
                    }
                )
                CalculatorButton(
                    symbol = "x",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
                    }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "4",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(4))
                    }
                )
                CalculatorButton(
                    symbol = "5",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(5))
                    }
                )
                CalculatorButton(
                    symbol = "6",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(6))
                    }
                )
                CalculatorButton(
                    symbol = "-",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
                    }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "1",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(1))
                    }
                )
                CalculatorButton(
                    symbol = "2",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(2))
                    }
                )
                CalculatorButton(
                    symbol = "3",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(3))
                    }
                )
                CalculatorButton(
                    symbol = "+",
                    modifier = Modifier
                        .background(Orange)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Add))
                    }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "0",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction(CalculatorAction.Number(0))
                    }
                )
                CalculatorButton(
                    symbol = ".",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Decimal)
                    }
                )
                CalculatorButton(
                    symbol = "=",
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Calculate)
                    }
                )
            }

        }
    }
}


@Composable
fun CalculatorWide(
    state: CalculatorState,
    buttonSpacing: Dp,
    modifier: Modifier = Modifier,
    onAction : (CalculatorAction) -> Unit
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(buttonSpacing)
            ){
                MyView(
                    state.number1 + (state.operation?.symbol ?: "") + state.number2,
                    myColor = Color.Black
                )
            }
            Column(
                modifier = Modifier
                    .weight(2f)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing),
                ) {
                    CalculatorButton(
                        symbol = "AC",
                        modifier = Modifier
                            .background(LightGray)
                            .padding(16.dp)
                            .weight(1f),
                        sizeFont = 20,
                        onClick = {
                            onAction(CalculatorAction.Clear)
                        }
                    )
                    CalculatorButton(
                        symbol = "Del",
                        modifier = Modifier
                            .background(LightGray)
                            .padding(16.dp)
                            .weight(1f),
                        sizeFont = 20,
                        onClick = {
                            onAction(CalculatorAction.Delete)
                        }
                    )
                    CalculatorButton(
                        symbol = "/",
                        modifier = Modifier
                            .background(Orange)
                            .padding(16.dp)
                            .weight(1f),
                        sizeFont = 20,
                        onClick = {
                            onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
                        }
                    )
                    CalculatorButton(
                        symbol = "x",
                        modifier = Modifier
                            .background(Orange)
                            .padding(16.dp)
                            .weight(1f),
                        sizeFont = 20,
                        onClick = {
                            onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
                        }
                    )
                    CalculatorButton(
                        symbol = "-",
                        modifier = Modifier
                            .background(Orange)
                            .padding(16.dp)
                            .weight(1f),
                        sizeFont = 20,
                        onClick = {
                            onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
                        }
                    )
                    CalculatorButton(
                        symbol = "+",
                        modifier = Modifier
                            .background(Orange)
                            .padding(16.dp)
                            .weight(1f),
                        sizeFont = 20,
                        onClick = {
                            onAction(CalculatorAction.Operation(CalculatorOperation.Add))
                        }
                    )
                    CalculatorButton(
                        symbol = "=",
                        modifier = Modifier
                            .background(Orange)
                            .padding(16.dp)
                            .weight(1f),
                        sizeFont = 20,
                        onClick = {
                            onAction(CalculatorAction.Calculate)
                        }
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ) {
                    CalculatorButton(
                        symbol = "4",
                        modifier = Modifier
                            .background(Color.DarkGray)
                            .padding(16.dp)
                            .weight(1f),
                        sizeFont = 20,
                        onClick = {
                            onAction(CalculatorAction.Number(4))
                        }
                    )
                    CalculatorButton(
                        symbol = "5",
                        modifier = Modifier
                            .background(Color.DarkGray)
                            .padding(16.dp)
                            .weight(1f),
                        sizeFont = 20,
                        onClick = {
                            onAction(CalculatorAction.Number(5))
                        }
                    )
                    CalculatorButton(
                        symbol = "6",
                        modifier = Modifier
                            .background(Color.DarkGray)
                            .padding(16.dp)
                            .weight(1f),
                        sizeFont = 20,
                        onClick = {
                            onAction(CalculatorAction.Number(6))
                        }
                    )
                    CalculatorButton(
                        symbol = "7",
                        modifier = Modifier
                            .background(Color.DarkGray)
                            .padding(16.dp)
                            .weight(1f),
                        sizeFont = 20,
                        onClick = {
                            onAction(CalculatorAction.Number(7))
                        }
                    )
                    CalculatorButton(
                        symbol = "8",
                        modifier = Modifier
                            .background(Color.DarkGray)
                            .padding(16.dp)
                            .weight(1f),
                        sizeFont = 20,
                        onClick = {
                            onAction(CalculatorAction.Number(8))
                        }
                    )
                    CalculatorButton(
                        symbol = "9",
                        modifier = Modifier
                            .background(Color.DarkGray)
                            .padding(16.dp)
                            .weight(1f),
                        sizeFont = 20,
                        onClick = {
                            onAction(CalculatorAction.Number(9))
                        }
                    )

                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ) {
                    CalculatorButton(
                        symbol = "1",
                        modifier = Modifier
                            .background(Color.DarkGray)
                            .padding(16.dp)
                            .weight(1f),
                        sizeFont = 20,
                        onClick = {
                            onAction(CalculatorAction.Number(1))
                        }
                    )
                    CalculatorButton(
                        symbol = "2",
                        modifier = Modifier
                            .background(Color.DarkGray)
                            .padding(16.dp)
                            .weight(1f),
                        sizeFont = 20,
                        onClick = {
                            onAction(CalculatorAction.Number(2))
                        }
                    )
                    CalculatorButton(
                        symbol = "3",
                        modifier = Modifier
                            .background(Color.DarkGray)
                            .padding(16.dp)
                            .weight(1f),
                        sizeFont = 20,
                        onClick = {
                            onAction(CalculatorAction.Number(3))
                        }
                    )
                    CalculatorButton(
                        symbol = "0",
                        modifier = Modifier
                            .background(Color.DarkGray)
                            .padding(16.dp)
                            .weight(1f),
                        sizeFont = 20,
                        onClick = {
                            onAction(CalculatorAction.Number(0))
                        }
                    )
                    CalculatorButton(
                        symbol = ".",
                        modifier = Modifier
                            .background(Color.DarkGray)
                            .padding(16.dp)
                            .weight(1f),
                        sizeFont = 20,
                        onClick = {
                            onAction(CalculatorAction.Decimal)
                        }
                    )


                }
            }
        }
    }
}

@Composable
fun MyView(
    state: String,
    myColor:Color=Color.White
){
    Text(
        text = state,
        textAlign = TextAlign.End,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, bottom = 4.dp),
        fontWeight = FontWeight.Light,
        fontSize = 60.sp,
        color = myColor,
        maxLines = 1
    )
}
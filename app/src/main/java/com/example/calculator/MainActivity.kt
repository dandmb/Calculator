package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculator.configuration.WindowInfo
import com.example.calculator.configuration.remberWindowInfo
import com.example.calculator.ui.calculator.Calculator
import com.example.calculator.ui.calculator.CalculatorWide
import com.example.calculator.ui.theme.CalculatorTheme
import com.example.calculator.ui.theme.MediumGray
import com.example.calculator.viewmodel.CalculatorViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                val viewModel = viewModel<CalculatorViewModel>()
                val state = viewModel.state
                val buttonSpacing = 8.dp
                val windowInfo = remberWindowInfo()
                if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact){
                    Calculator(
                        state = state, buttonSpacing = buttonSpacing, modifier = Modifier
                            .fillMaxSize()
                            .background(MediumGray)
                            .padding(16.dp),
                        onAction = viewModel::onAction
                    )
                }else{
                    CalculatorWide(
                        state = state, buttonSpacing = buttonSpacing, modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White)
                            .padding(16.dp)
                           ,
                        onAction = viewModel::onAction
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculatorTheme {
        /*
        Calculator(
            state,
            8.dp,
            modifier = Modifier
                .fillMaxSize()
                .background(MediumGray)
                .padding(16.dp),
            onAction = {

            }
        )*/
    }
}


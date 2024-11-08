package com.example.tagaytaytayo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tagaytaytayo.ui.theme.TagaytayTayoTheme
import com.example.tagaytaytayo.viewmodel.CityViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TagaytayTayoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    val viewModel: CityViewModel = viewModel()
    val recommendations by viewModel.recommendations.observeAsState(emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Welcome to My City App!", style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { viewModel.loadRecommendations("Coffee Shops") }) {
            Text(text = "Get Coffee Shop Recommendations")
        }
        Spacer(modifier = Modifier.height(16.dp))
        recommendations.forEach { recommendation ->
            Text(text = recommendation)
        }
    }
}

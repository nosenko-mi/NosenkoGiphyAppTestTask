package com.example.giphyapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.giphyapp.common.Constants
import com.example.giphyapp.presentation.gif_detail.GifDetailScreen
import com.example.giphyapp.presentation.gif_list.GifListScreen
import com.example.giphyapp.presentation.ui.theme.GiphyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GiphyAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController,
                        startDestination = Screen.GifListScreen.route){
                        composable(
                            route = Screen.GifListScreen.route
                        ) {
                            GifListScreen(navController)
                        }
                        composable(
                            route = Screen.GifDetailScreen.route + "/{gifId}"
                        ) {
                            GifDetailScreen(navController)
                        }
                    }
                }
            }
        }
    }
}
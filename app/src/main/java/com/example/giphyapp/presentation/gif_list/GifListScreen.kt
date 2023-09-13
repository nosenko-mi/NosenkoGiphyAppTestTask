package com.example.giphyapp.presentation.gif_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.giphyapp.presentation.Screen
import com.example.giphyapp.presentation.components.GifImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GifListScreen(
    navController: NavController,
    viewModel: GifListViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "GiphyApp",
                    )
                }
            )
        },
        content = { innerPadding ->
            val state = viewModel.state.value

            Box(modifier = Modifier
                .padding(innerPadding)
                .padding(24.dp)
                .fillMaxSize( )
            ){
                LazyColumn(modifier = Modifier.fillMaxSize()){
                    items(state.gifs){gif ->
                        Spacer(modifier = Modifier.height(24.dp))
                        GifImage(
                            url = gif.images.downsized.url,
                            onItemClick = {navController.navigate(Screen.GifDetailScreen.route + "/${gif.id}")}
                        )
                    }
                }
                if (state.error.isNotBlank()){
                    Text(text = state.error,
                        color = MaterialTheme.colorScheme.error,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp)
                            .align(Alignment.Center)
                    )
                }
                if (state.isLoading){
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            }
        }
    )


}
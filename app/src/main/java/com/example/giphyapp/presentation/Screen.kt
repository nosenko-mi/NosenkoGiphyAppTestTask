package com.example.giphyapp.presentation

sealed class Screen(val route: String){
    object GifListScreen: Screen("gif_list_screen")
    object GifDetailScreen: Screen("gif_detail_screen")

}

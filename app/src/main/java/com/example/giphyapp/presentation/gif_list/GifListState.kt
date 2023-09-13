package com.example.giphyapp.presentation.gif_list

import com.example.giphyapp.domain.model.gif.Gif

data class GifListState(
    val isLoading: Boolean = false,
    val error: String = "",
    val gifs: List<Gif> = emptyList()
)

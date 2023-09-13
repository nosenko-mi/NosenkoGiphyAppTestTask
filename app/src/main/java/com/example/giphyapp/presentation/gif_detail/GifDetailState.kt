package com.example.giphyapp.presentation.gif_detail

import com.example.giphyapp.domain.model.gif.Gif

data class GifDetailState (
    val isLoading: Boolean = false,
    val gif: Gif? = null,
    val error: String = ""
)

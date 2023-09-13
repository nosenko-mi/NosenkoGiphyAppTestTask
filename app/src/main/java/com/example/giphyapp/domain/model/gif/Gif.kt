package com.example.giphyapp.domain.model.gif

import com.example.giphyapp.data.remote.dto.gif.Images
import com.example.giphyapp.data.remote.dto.gif.User

data class Gif (
    val bitlyGifUrl: String,
    val bitlyUrl: String,
    val id: String,
    val images: Images,
    val slug: String,
    val title: String,
    val trendingDatetime: String,
    val type: String,
    val url: String,
    val username: String
)
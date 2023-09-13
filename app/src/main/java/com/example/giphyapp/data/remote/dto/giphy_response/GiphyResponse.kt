package com.example.giphyapp.data.remote.dto.giphy_response


import com.example.giphyapp.data.remote.dto.gif.GifDto

data class GiphyResponse(
    val data: List<GifDto>,
    val meta: Meta,
    val pagination: Pagination
)
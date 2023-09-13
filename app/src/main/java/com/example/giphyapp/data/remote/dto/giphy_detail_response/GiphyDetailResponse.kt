package com.example.giphyapp.data.remote.dto.giphy_detail_response

import com.example.giphyapp.data.remote.dto.gif.GifDto
import com.example.giphyapp.data.remote.dto.giphy_response.Meta

data class GiphyDetailResponse(
    val data: GifDto,
    val meta: Meta
)
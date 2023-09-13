package com.example.giphyapp.domain.repository

import com.example.giphyapp.data.remote.dto.gif.GifDto

interface GiphyRepository {

    suspend fun getGifs(): List<GifDto>

    suspend fun getGifById(id: String): GifDto

}
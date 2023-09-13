package com.example.giphyapp.data.repository

import com.example.giphyapp.common.Constants
import com.example.giphyapp.data.remote.GiphyApi
import com.example.giphyapp.data.remote.dto.gif.GifDto
import com.example.giphyapp.domain.repository.GiphyRepository
import javax.inject.Inject

class GiphyRepositoryImpl @Inject constructor(
    private val api: GiphyApi
): GiphyRepository {

    override suspend fun getGifs(): List<GifDto> {
        return api.getGifs(Constants.API_KEY).data
    }

    override suspend fun getGifById(id: String): GifDto {
        return api.getGifById(id, Constants.API_KEY).data
    }
}
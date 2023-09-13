package com.example.giphyapp.data.remote

import com.example.giphyapp.data.remote.dto.giphy_detail_response.GiphyDetailResponse
import com.example.giphyapp.data.remote.dto.giphy_response.GiphyResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GiphyApi {

    @GET("/v1/gifs/trending")
    suspend fun getGifs(@Query("api_key") apiKey: String): GiphyResponse

    @GET("/v1/gifs/{gif_id}")
    suspend fun getGifById(@Path("gif_id") gifId: String, @Query("api_key") apiKey: String): GiphyDetailResponse

}
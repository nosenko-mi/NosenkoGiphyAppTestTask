package com.example.giphyapp.data.remote.dto.gif


import com.google.gson.annotations.SerializedName

data class FixedWidthDownsampled(
    val height: String,
    val size: String,
    val url: String,
    val webp: String,
    @SerializedName("webp_size")
    val webpSize: String,
    val width: String
)
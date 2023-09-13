package com.example.giphyapp.data.remote.dto.gif


import com.google.gson.annotations.SerializedName

data class FixedWidthSmall(
    val height: String,
    val mp4: String,
    @SerializedName("mp4_size")
    val mp4Size: String,
    val size: String,
    val url: String,
    val webp: String,
    @SerializedName("webp_size")
    val webpSize: String,
    val width: String
)
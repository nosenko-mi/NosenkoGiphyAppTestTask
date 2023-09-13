package com.example.giphyapp.data.remote.dto.gif


import com.google.gson.annotations.SerializedName

data class FixedHeightStill(
    val height: String,
    val size: String,
    val url: String,
    val width: String
)
package com.example.giphyapp.data.remote.dto.gif


import com.google.gson.annotations.SerializedName

data class K(
    val height: String,
    val mp4: String,
    @SerializedName("mp4_size")
    val mp4Size: String,
    val width: String
)
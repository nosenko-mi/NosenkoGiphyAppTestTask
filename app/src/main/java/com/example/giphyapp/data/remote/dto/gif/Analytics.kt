package com.example.giphyapp.data.remote.dto.gif


import com.google.gson.annotations.SerializedName

data class Analytics(
    val onclick: Onclick,
    val onload: Onload,
    val onsent: Onsent
)
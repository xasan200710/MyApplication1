package com.example.myapplication1.data.model.network

import com.google.gson.annotations.SerializedName

data class EpisodeResult(
    val id: Int? = null,
    val name:String? = null,
    @SerializedName("air_date")
    val airDate:String? = null,
    val episode:String? = null
)
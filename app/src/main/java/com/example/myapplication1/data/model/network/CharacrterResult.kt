package com.example.myapplication1.data.model.network

data class CharacrterResult(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val location: Location,
    val id: Int,
    val image: String,
    val name: String,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)
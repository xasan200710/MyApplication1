package com.example.myapplication1.data.service.network

import androidx.room.Delete
import com.example.myapplication1.data.model.network.*
import retrofit2.Call
import retrofit2.http.*

interface RickAndMortyApi {
    @GET("character")
    fun getCharacter(): Call<MainResponse<CharacrterResult>?>

    @GET("location")
    fun getLocation(): Call<MainResponse<LocationResult>?>

    @GET("episode")
    fun getEpisode(): Call<MainResponse<EpisodeResult>?>

    @GET("character/{id}")
    fun getCharacterById(
        @Path("id") id: Int): Call<CharacrterResult?>
}
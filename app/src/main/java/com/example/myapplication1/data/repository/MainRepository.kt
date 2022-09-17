package com.example.myapplication1.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.myapplication1.common.Resource
import com.example.myapplication1.data.model.network.*
import com.example.myapplication1.data.service.network.RickAndMortyApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainRepository @Inject constructor(private val api: RickAndMortyApi) {

    fun getCharacter(): MutableLiveData<Resource<MainResponse<CharacrterResult>?>> {
        val liveData = MutableLiveData<Resource<MainResponse<CharacrterResult>?>>()
        liveData.value = Resource.loading()
        api.getCharacter().enqueue(object : Callback<MainResponse<CharacrterResult>?> {
            override fun onResponse(
                call: Call<MainResponse<CharacrterResult>?>,
                response: Response<MainResponse<CharacrterResult>?>
            ) {
                if (response.isSuccessful) {
                    liveData.value = Resource.success(response.body())
                }
            }

            override fun onFailure(call: Call<MainResponse<CharacrterResult>?>, t: Throwable) {
                liveData.value = t.message?.let { Resource.error(it) }
            }

        })
        return liveData
    }

    fun getLocation(): MutableLiveData<Resource<MainResponse<LocationResult>?>> {
        val location = MutableLiveData<Resource<MainResponse<LocationResult>?>>()
        location.value = Resource.loading()
        api.getLocation().enqueue(object : Callback<MainResponse<LocationResult>?> {
            override fun onResponse(
                call: Call<MainResponse<LocationResult>?>,
                response: Response<MainResponse<LocationResult>?>
            ) {
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        location.value = Resource.success(response.body())
                    }
                }
            }

            override fun onFailure(call: Call<MainResponse<LocationResult>?>, t: Throwable) {
                location.value = t.message?.let { Resource.error(it) }
            }

        })
        return location
    }

    fun getEpisode(): MutableLiveData<Resource<MainResponse<EpisodeResult>?>> {
        val episode = MutableLiveData<Resource<MainResponse<EpisodeResult>?>>()
        episode.value = Resource.loading()
        api.getEpisode().enqueue(object : Callback<
                MainResponse<EpisodeResult>?> {
            override fun onResponse(
                call: Call<MainResponse<EpisodeResult>?>,
                response: Response<MainResponse<EpisodeResult>?>
            ) {
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        episode.value = Resource.success(response.body())
                    }
                }
            }

            override fun onFailure(
                call: Call<MainResponse<EpisodeResult>?>,
                t: Throwable
            ) {
                episode.value = t.message?.let { Resource.error(it) }
            }

        })
        return episode
    }

    fun getCharacterById(id: Int): MutableLiveData<Resource<CharacrterResult?>> {
        val liveData = MutableLiveData<Resource<CharacrterResult?>>()
        liveData.value = Resource.loading()
        api.getCharacterById(id).enqueue(object : Callback<CharacrterResult?> {
            override fun onResponse(
                call: Call<CharacrterResult?>,
                response: Response<CharacrterResult?>
            ) {
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        liveData.value = Resource.success(response.body())
                    }
                }
            }

            override fun onFailure(call: Call<CharacrterResult?>, t: Throwable) {
                liveData.value = t.message?.let { Resource.error(it) }
            }
        })
        return liveData
    }
}
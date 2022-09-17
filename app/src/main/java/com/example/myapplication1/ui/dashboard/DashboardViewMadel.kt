package com.example.myapplication1.ui.dashboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication1.common.Resource
import com.example.myapplication1.data.model.network.EpisodeResult
import com.example.myapplication1.data.model.network.MainResponse
import com.example.myapplication1.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewMadel @Inject constructor(private val repo: MainRepository) : ViewModel() {

    var episode = MutableLiveData<Resource<MainResponse<EpisodeResult>?>>()

    fun getEpisode() {
        episode = repo.getEpisode()
    }
}
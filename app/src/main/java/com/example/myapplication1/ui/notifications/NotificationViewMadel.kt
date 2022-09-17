package com.example.myapplication1.ui.notifications

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication1.common.Resource
import com.example.myapplication1.data.model.network.LocationResult
import com.example.myapplication1.data.model.network.MainResponse
import com.example.myapplication1.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotificationViewMadel @Inject constructor(private val repo: MainRepository) : ViewModel() {

    var location = MutableLiveData<Resource<MainResponse<LocationResult>?>>()

    fun getLocation() {
        location = repo.getLocation()
    }
}
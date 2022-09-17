package com.example.myapplication1.ui.detailChracter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication1.common.Resource
import com.example.myapplication1.data.model.network.CharacrterResult
import com.example.myapplication1.data.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailCharacterVIewModel @Inject constructor(private val repository: MainRepository) :
    ViewModel() {

     var liveDate = MutableLiveData<Resource<CharacrterResult?>>()

    fun getCharacterById(id: Int) {
        liveDate = repository.getCharacterById(id)
    }
}
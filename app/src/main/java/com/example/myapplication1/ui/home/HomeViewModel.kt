package com.example.myapplication1.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication1.common.Resource
import com.example.myapplication1.data.model.local.CharacterResultLocal
import com.example.myapplication1.data.model.network.CharacrterResult
import com.example.myapplication1.data.model.network.MainResponse
import com.example.myapplication1.data.repository.MainRepository
import com.example.myapplication1.data.repository.RoomRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repo: MainRepository,
    private val roomRepo: RoomRepository
) : ViewModel() {
    var liveDate = MutableLiveData<Resource<MainResponse<CharacrterResult>?>>()
    var roomLiveData: LiveData<List<CharacterResultLocal>> = MutableLiveData()

    fun getCharacter() {
        liveDate = repo.getCharacter()
    }

    fun getAllCharacters() {
        roomLiveData = roomRepo.getAllCharacters()
    }

    fun addCharacter(model: CharacterResultLocal) {
        roomRepo.addCharacter(model)
    }
}
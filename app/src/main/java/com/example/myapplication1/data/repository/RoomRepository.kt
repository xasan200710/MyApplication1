package com.example.myapplication1.data.repository

import androidx.lifecycle.LiveData
import com.example.myapplication1.data.model.local.CharacterResultLocal
import com.example.myapplication1.data.service.local.RickAndMortyDao
import javax.inject.Inject

class RoomRepository @Inject constructor(private val dao: RickAndMortyDao) {

    fun getAllCharacters(): LiveData<List<CharacterResultLocal>> {
        return dao.getAllCharacters()
    }

    fun addCharacter(model: CharacterResultLocal) {
        dao.addCharacter(model)
    }
}
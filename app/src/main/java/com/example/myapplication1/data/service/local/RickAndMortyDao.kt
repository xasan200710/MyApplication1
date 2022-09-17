package com.example.myapplication1.data.service.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication1.data.model.local.CharacterResultLocal

@Dao
interface RickAndMortyDao {
    @Query("SELECT * FROM characterresultlocal")
    fun getAllCharacters(): LiveData<List<CharacterResultLocal>>

    @Insert
    fun addCharacter(model: CharacterResultLocal)
}
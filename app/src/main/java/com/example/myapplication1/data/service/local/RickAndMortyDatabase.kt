package com.example.myapplication1.data.service.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication1.data.model.local.CharacterResultLocal

@Database(entities = [CharacterResultLocal::class], version = 1)
abstract class RickAndMortyDatabase : RoomDatabase(){
    abstract fun getDao(): RickAndMortyDao
}
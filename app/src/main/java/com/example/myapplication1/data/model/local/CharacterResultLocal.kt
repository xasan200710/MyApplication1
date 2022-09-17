package com.example.myapplication1.data.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CharacterResultLocal(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val image: String,
    val status: String,
    val name: String
) {

}
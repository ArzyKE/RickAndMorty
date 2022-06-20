package com.example.rickandmortyapikotlin.data.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickandmortyapikotlin.model.CharacterModel

@Dao
interface CharacterDao {

    @Query("SELECT * FROM character")
    fun getAll(): List<CharacterModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<CharacterModel>)
}
package com.example.rickandmortyapikotlin.data.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickandmortyapikotlin.model.EpisodeModel

@Dao
interface EpisodeDao {

    @Query("SELECT * FROM episode")
    fun getAll(): List<EpisodeModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<EpisodeModel>)
}
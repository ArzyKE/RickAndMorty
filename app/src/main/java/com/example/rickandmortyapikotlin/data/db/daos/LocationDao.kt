package com.example.rickandmortyapikotlin.data.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickandmortyapikotlin.model.LocationModel

@Dao
interface LocationDao {

    @Query("SELECT * FROM location")
    fun getAll(): List<LocationModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<LocationModel>)

}
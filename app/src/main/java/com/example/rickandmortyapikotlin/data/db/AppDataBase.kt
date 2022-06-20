package com.example.rickandmortyapikotlin.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.rickandmortyapikotlin.data.db.daos.CharacterDao
import com.example.rickandmortyapikotlin.data.db.daos.EpisodeDao
import com.example.rickandmortyapikotlin.data.db.daos.LocationDao
import com.example.rickandmortyapikotlin.model.CharacterModel
import com.example.rickandmortyapikotlin.model.EpisodeModel
import com.example.rickandmortyapikotlin.model.LocationModel
import com.example.rickandmortyapikotlin.utils.CharacterConverter

@Database(entities = [CharacterModel::class, EpisodeModel::class, LocationModel::class], version = 4)
@TypeConverters(CharacterConverter::class)
abstract class AppDataBase : RoomDatabase() {

    abstract fun CharacterDao(): CharacterDao
    abstract fun EpisodeDao(): EpisodeDao
    abstract fun LocationDao(): LocationDao

}
package com.example.rickandmortyapikotlin.data.db

import android.content.Context
import androidx.room.Room
import com.example.rickandmortyapikotlin.data.db.daos.CharacterDao
import com.example.rickandmortyapikotlin.data.db.daos.EpisodeDao
import com.example.rickandmortyapikotlin.data.db.daos.LocationDao
import com.example.rickandmortyapikotlin.utils.CharacterConverter

class RoomClient {

    fun provideRoom(context: Context): AppDataBase {
        return Room.databaseBuilder(
            context,
            AppDataBase::class.java, "database-name"
        ).allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideCharacterDao(appDataBase: AppDataBase): CharacterDao {
        return appDataBase.CharacterDao()
    }

    fun provideEpisodeDao(appDataBase: AppDataBase): EpisodeDao {
        return appDataBase.EpisodeDao()
    }

    fun provideLocationDao(appDataBase: AppDataBase): LocationDao {
        return appDataBase.LocationDao()
    }
}
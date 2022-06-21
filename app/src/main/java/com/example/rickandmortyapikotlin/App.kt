package com.example.rickandmortyapikotlin

import android.app.Application
import com.example.rickandmortyapikotlin.data.db.RoomClient
import com.example.rickandmortyapikotlin.data.db.daos.CharacterDao
import com.example.rickandmortyapikotlin.data.db.daos.EpisodeDao
import com.example.rickandmortyapikotlin.data.db.daos.LocationDao
import com.example.rickandmortyapikotlin.data.network.apiservices.CharacterApiServices
import com.example.rickandmortyapikotlin.data.network.apiservices.EpisodeApiServices
import com.example.rickandmortyapikotlin.data.network.apiservices.LocationApiServices
import com.example.rickandmortyapikotlin.data.network.retrofit.RetrofitClient

class App : Application() {

    companion object {
        var characterApiServices: CharacterApiServices? = null
        var locationApiServices: LocationApiServices? = null
        var episodeApiServices: EpisodeApiServices? = null
        var characterDao: CharacterDao? = null
        var episodeDao: EpisodeDao? = null
        var locationDao: LocationDao? = null
    }

    private val retrofitClient = RetrofitClient()
    private val roomClient = RoomClient()

    override fun onCreate() {
        super.onCreate()
        characterApiServices = retrofitClient.provideCharacterDao()
        locationApiServices = retrofitClient.provideLocationDao()
        episodeApiServices = retrofitClient.provideEpisodeDao()
        characterDao = roomClient.provideCharacterDao(roomClient.provideRoom(this))
        episodeDao = roomClient.provideEpisodeDao(roomClient.provideRoom(this))
        locationDao = roomClient.provideLocationDao(roomClient.provideRoom(this))
    }
}
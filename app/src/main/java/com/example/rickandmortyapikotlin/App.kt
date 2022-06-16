package com.example.rickandmortyapikotlin

import android.app.Application
import com.example.rickandmortyapikotlin.data.network.apiservices.CharacterApiServices
import com.example.rickandmortyapikotlin.data.network.apiservices.EpisodeApiServices
import com.example.rickandmortyapikotlin.data.network.apiservices.LocationApiServices
import com.example.rickandmortyapikotlin.data.network.apiservices.RetrofitClient

class App : Application() {

    companion object {
        var characterApiServices: CharacterApiServices? = null
        var locationApiServices: LocationApiServices? = null
        var episodeApiServices: EpisodeApiServices? = null
    }

    private val retrofitClient = RetrofitClient()

    override fun onCreate() {
        super.onCreate()
        characterApiServices = retrofitClient.provideCharacterDao()
        locationApiServices = retrofitClient.provideLocationDao()
        episodeApiServices = retrofitClient.provideEpisodeDao()
    }
}
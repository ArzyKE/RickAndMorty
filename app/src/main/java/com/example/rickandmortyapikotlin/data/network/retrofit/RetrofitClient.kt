package com.example.rickandmortyapikotlin.data.network.retrofit

import com.example.rickandmortyapikotlin.data.network.apiservices.CharacterApiServices
import com.example.rickandmortyapikotlin.data.network.apiservices.EpisodeApiServices
import com.example.rickandmortyapikotlin.data.network.apiservices.LocationApiServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    private val retrofitClient =
        Retrofit.Builder().baseUrl("https://rickandmortyapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()

    fun provideCharacterDao(): CharacterApiServices {
        return retrofitClient.create(CharacterApiServices::class.java)
    }
    fun provideLocationDao(): LocationApiServices {
        return retrofitClient.create(LocationApiServices::class.java)
    }
    fun provideEpisodeDao(): EpisodeApiServices {
        return retrofitClient.create(EpisodeApiServices::class.java)
    }
}
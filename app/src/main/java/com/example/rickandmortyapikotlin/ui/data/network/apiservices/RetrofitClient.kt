package com.example.rickandmortyapikotlin.ui.data.network.apiservices

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitClient {

    private val retrofitClient =
        Retrofit.Builder().baseUrl("https://rickandmortyapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()

    fun provideCharacterDao():CharacterApiServices{
        return retrofitClient.create(CharacterApiServices::class.java)
    }
    fun provideLocationDao():LocationApiServices{
        return retrofitClient.create(LocationApiServices::class.java)
    }
    fun provideEpisodeDao():EpisodeApiServices{
        return retrofitClient.create(EpisodeApiServices::class.java)
    }
}
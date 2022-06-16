package com.example.rickandmortyapikotlin.ui.data.network.apiservices

import com.example.rickandmortyapikotlin.model.EpisodeModel
import com.example.rickandmortyapikotlin.model.RickyMortyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface EpisodeApiServices {

    @GET("api/episode")
    fun fetchEpisode(): Call<RickyMortyResponse<EpisodeModel>>

    @GET("api/episode/{id}")
    fun episodeId(
        @Path("id") id: Int
    ): Call<EpisodeModel>
}
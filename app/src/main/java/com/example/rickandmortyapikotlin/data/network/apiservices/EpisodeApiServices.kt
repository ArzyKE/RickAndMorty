package com.example.rickandmortyapikotlin.data.network.apiservices

import com.example.rickandmortyapikotlin.model.EpisodeModel
import com.example.rickandmortyapikotlin.model.RickyMortyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EpisodeApiServices {

    @GET("api/episode")
   suspend fun fetchEpisode(
        @Query("page") page: Int
    ): RickyMortyResponse<EpisodeModel>?

    @GET("api/episode/{id}")
    fun episodeId(
        @Path("id") id: Int
    ): Call<EpisodeModel>
}
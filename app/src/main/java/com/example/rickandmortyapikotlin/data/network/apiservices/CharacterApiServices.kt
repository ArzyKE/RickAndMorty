package com.example.rickandmortyapikotlin.data.network.apiservices

import com.example.rickandmortyapikotlin.model.CharacterModel
import com.example.rickandmortyapikotlin.model.RickyMortyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApiServices {

    @GET("api/character")
    suspend fun fetchCharacters(
        @Query("page") page: Int
    ): RickyMortyResponse<CharacterModel>?

    @GET("api/character/{id}")
    fun fetchCharacterId(
        @Path("id") id: Int
    ): Call<CharacterModel>
}
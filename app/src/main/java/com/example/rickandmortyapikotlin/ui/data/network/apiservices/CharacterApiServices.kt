package com.example.rickandmortyapikotlin.ui.data.network.apiservices

import com.example.rickandmortyapikotlin.model.CharacterModel
import com.example.rickandmortyapikotlin.model.RickyMortyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterApiServices {

    @GET("api/character")
    fun fetchCharacters(): Call<RickyMortyResponse<CharacterModel>>

    @GET("api/character/{id}")
    fun fetchCharacterId(
        @Path("id") id: Int
    ): Call<CharacterModel>
}
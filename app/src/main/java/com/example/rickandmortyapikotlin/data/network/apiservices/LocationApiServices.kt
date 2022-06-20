package com.example.rickandmortyapikotlin.data.network.apiservices

import com.example.rickandmortyapikotlin.model.LocationModel
import com.example.rickandmortyapikotlin.model.RickyMortyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface LocationApiServices {

    @GET("api/location")
     fun fetchLocation(
    ): Call<RickyMortyResponse<LocationModel>>

    @GET("api/location/{id}")
    fun fetchLocationId(
        @Path("id") id: Int
    ): Call<LocationModel>
}
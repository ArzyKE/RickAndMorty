package com.example.rickandmortyapikotlin.ui.data.repositories

import androidx.lifecycle.MutableLiveData
import com.example.rickandmortyapikotlin.App
import com.example.rickandmortyapikotlin.model.LocationModel
import com.example.rickandmortyapikotlin.model.RickyMortyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LocationRepository {
//
//    val data: MutableLiveData<RickyMortyResponse<LocationModel>> = MutableLiveData()
//
//    fun fetchLocation(): MutableLiveData<RickyMortyResponse<LocationModel>> {
//        val data: MutableLiveData<RickyMortyResponse<LocationModel>> = MutableLiveData()
//        App.locationApiServices?.fetchLocation()
//            ?.enqueue(object : Callback<RickyMortyResponse<LocationModel>> {
//                override fun onResponse(
//                    call: Call<RickyMortyResponse<LocationModel>>,
//                    response: Response<RickyMortyResponse<LocationModel>>
//                ) {
//                    if (response.body() != null)
//                        data.value = response.body()
//                }
//
//                override fun onFailure(
//                    call: Call<RickyMortyResponse<LocationModel>>,
//                    t: Throwable
//                ) {
//                    data.value = null
//                }
//            })
//        return data
//    }
}
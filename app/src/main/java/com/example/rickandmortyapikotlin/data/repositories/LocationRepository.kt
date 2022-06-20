package com.example.rickandmortyapikotlin.data.repositories

import androidx.lifecycle.MutableLiveData
import com.example.rickandmortyapikotlin.App
import com.example.rickandmortyapikotlin.model.LocationModel
import com.example.rickandmortyapikotlin.model.RickyMortyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LocationRepository {

    val data: MutableLiveData<RickyMortyResponse<LocationModel>> = MutableLiveData()

    fun fetchLocation(): MutableLiveData<RickyMortyResponse<LocationModel>> {
        App.locationApiServices?.fetchLocation()
            ?.enqueue(object : Callback<RickyMortyResponse<LocationModel>> {
                override fun onResponse(
                    call: Call<RickyMortyResponse<LocationModel>>,
                    response: Response<RickyMortyResponse<LocationModel>>
                ) {
                    data.value = response.body()
                }

                override fun onFailure(
                    call: Call<RickyMortyResponse<LocationModel>>,
                    t: Throwable
                ) {
                    data.value = null
                }

            })
        return data
    }

    fun getLocation(): ArrayList<LocationModel> {
        val list: ArrayList<LocationModel> = ArrayList()
        App.locationDao?.let { list.addAll(it.getAll()) }
        return list

    }


    fun fetchLocationId(id: Int): MutableLiveData<LocationModel> {
        val data: MutableLiveData<LocationModel> = MutableLiveData()
        App.locationApiServices?.fetchLocationId(id)?.enqueue(object : Callback<LocationModel> {
            override fun onResponse(call: Call<LocationModel>, response: Response<LocationModel>) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<LocationModel>, t: Throwable) {
                data.value = null
            }
        })
        return data
    }
}

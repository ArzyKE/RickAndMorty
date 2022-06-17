package com.example.rickandmortyapikotlin.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.rickandmortyapikotlin.App
import com.example.rickandmortyapikotlin.data.repositories.pagingsourse.LocationPagingSource
import com.example.rickandmortyapikotlin.model.LocationModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LocationRepository {

    fun fetchLocation(): LiveData<PagingData<LocationModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false,
                initialLoadSize = 2
            ),
            pagingSourceFactory = {
                LocationPagingSource(App.locationApiServices!!)
            }, initialKey = 1
        ).liveData
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
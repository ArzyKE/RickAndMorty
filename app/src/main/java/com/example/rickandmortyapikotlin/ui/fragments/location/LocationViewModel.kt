package com.example.rickandmortyapikotlin.ui.fragments.location

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.example.rickandmortyapikotlin.data.repositories.LocationRepository
import com.example.rickandmortyapikotlin.model.LocationModel
import com.example.rickandmortyapikotlin.model.RickyMortyResponse

class LocationViewModel : ViewModel() {

    private val repository = LocationRepository()

    fun fetchLocation(): LiveData<PagingData<LocationModel>> {
        return repository.fetchLocation()
    }

    fun fetchLocationId(position: Int): MutableLiveData<LocationModel> {
        return repository.fetchLocationId(position)
    }
}
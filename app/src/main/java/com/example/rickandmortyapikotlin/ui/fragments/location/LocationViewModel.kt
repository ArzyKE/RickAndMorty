package com.example.rickandmortyapikotlin.ui.fragments.location

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapikotlin.model.LocationModel
import com.example.rickandmortyapikotlin.model.RickyMortyResponse
import com.example.rickandmortyapikotlin.data.repositories.LocationRepository

class LocationViewModel : ViewModel() {

    private val repository = LocationRepository()

    fun fetchLocation(): MutableLiveData<RickyMortyResponse<LocationModel>> {
        return repository.fetchLocation()
    }

    fun fetchLocationId(position: Int): MutableLiveData<LocationModel> {
        return repository.fetchLocationId(position)
    }
}
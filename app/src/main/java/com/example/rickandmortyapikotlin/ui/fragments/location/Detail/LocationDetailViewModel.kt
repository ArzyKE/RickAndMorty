package com.example.rickandmortyapikotlin.ui.fragments.location.Detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapikotlin.data.repositories.LocationRepository
import com.example.rickandmortyapikotlin.model.LocationModel

class LocationDetailViewModel : ViewModel() {

    val repository: LocationRepository = LocationRepository()

    fun fetchLocationId(position: Int): MutableLiveData<LocationModel> {
        return repository.fetchLocationId(position)
    }
}
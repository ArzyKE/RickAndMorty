package com.example.rickandmortyapikotlin.ui.fragments.location

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapikotlin.data.repositories.LocationRepository
import com.example.rickandmortyapikotlin.model.LocationModel
import com.example.rickandmortyapikotlin.model.RickyMortyResponse

class LocationViewModel : ViewModel() {

    private val repository = LocationRepository()


    fun fetchLocation(): MutableLiveData<RickyMortyResponse<LocationModel>> {
        return repository.fetchLocation()
    }

    fun getLocation(): ArrayList<LocationModel> {
        return repository.getLocation()
    }
}
//
//fun fetchLocationId(position: Int): MutableLiveData<LocationModel> {
//    return repository.fetchLocationId(position)


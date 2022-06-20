package com.example.rickandmortyapikotlin.ui.fragments.episode

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapikotlin.data.repositories.EpisodeRepository
import com.example.rickandmortyapikotlin.model.EpisodeModel
import com.example.rickandmortyapikotlin.model.RickyMortyResponse

class EpisodeViewModel : ViewModel() {

    private val repository = EpisodeRepository()

    fun fetchEpisode(): MutableLiveData<RickyMortyResponse<EpisodeModel>> {
        return repository.fetchEpisode()
    }

    fun getEpisode(): ArrayList<EpisodeModel> {
        return repository.getEpisode()
    }
}

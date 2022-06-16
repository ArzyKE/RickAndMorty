package com.example.rickandmortyapikotlin.ui.fragments.episode

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapikotlin.model.EpisodeModel
import com.example.rickandmortyapikotlin.model.RickyMortyResponse
import com.example.rickandmortyapikotlin.ui.data.repositories.EpisodeRepository

class EpisodeViewModel : ViewModel() {

    private val repository = EpisodeRepository()

    fun fetchEpisode(): MutableLiveData<RickyMortyResponse<EpisodeModel>> {
        return repository.fetchEpisode()
    }

    fun fetchEpisodeId(position: Int): MutableLiveData<EpisodeModel> {
        return repository.fetchEpisodeId(position)
    }
}

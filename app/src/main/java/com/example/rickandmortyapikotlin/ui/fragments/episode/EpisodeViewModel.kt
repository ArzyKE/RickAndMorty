package com.example.rickandmortyapikotlin.ui.fragments.episode

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.example.rickandmortyapikotlin.model.EpisodeModel
import com.example.rickandmortyapikotlin.model.RickyMortyResponse
import com.example.rickandmortyapikotlin.data.repositories.EpisodeRepository

class EpisodeViewModel : ViewModel() {

    private val repository = EpisodeRepository()

    fun fetchEpisode(): LiveData<PagingData<EpisodeModel>> {
        return repository.fetchEpisode()
    }

    fun fetchEpisodeId(position: Int): MutableLiveData<EpisodeModel> {
        return repository.fetchEpisodeId(position)
    }
}

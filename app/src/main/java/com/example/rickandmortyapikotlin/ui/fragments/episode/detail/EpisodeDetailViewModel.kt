package com.example.rickandmortyapikotlin.ui.fragments.episode.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapikotlin.data.repositories.EpisodeRepository
import com.example.rickandmortyapikotlin.model.EpisodeModel

class EpisodeDetailViewModel : ViewModel() {

    val repository: EpisodeRepository = EpisodeRepository()


    fun fetchEpisodeId(position: Int): MutableLiveData<EpisodeModel> {
        return repository.fetchEpisodeId(position)
    }
}
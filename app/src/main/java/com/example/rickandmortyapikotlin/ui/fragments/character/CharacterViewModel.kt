package com.example.rickandmortyapikotlin.ui.fragments.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.rickandmortyapikotlin.data.repositories.CharacterRepository
import com.example.rickandmortyapikotlin.model.CharacterModel

class CharacterViewModel : ViewModel() {

    private val repository = CharacterRepository()

    fun fetchCharacters(): LiveData<PagingData<CharacterModel>> {
        return repository.fetchCharacters().cachedIn(viewModelScope)
    }
}



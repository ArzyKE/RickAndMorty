package com.example.rickandmortyapikotlin.ui.fragments.character.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapikotlin.data.repositories.CharacterRepository
import com.example.rickandmortyapikotlin.model.CharacterModel

class CharacterDetailViewModel : ViewModel() {

    val repository: CharacterRepository = CharacterRepository()

    fun fetchCharactersId(position: Int): MutableLiveData<CharacterModel> {
        return repository.fetchCharacterId(position)
    }
}

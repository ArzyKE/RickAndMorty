package com.example.rickandmortyapikotlin.ui.fragments.character

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapikotlin.model.CharacterModel
import com.example.rickandmortyapikotlin.model.RickyMortyResponse
import com.example.rickandmortyapikotlin.ui.data.repositories.CharacterRepository

class CharacterViewModel : ViewModel() {

    private val repository = CharacterRepository()

    fun fetchCharacters(): MutableLiveData<RickyMortyResponse<CharacterModel>> {
        return repository.fetchCharacters()
    }

    fun fetchCharactersId(position: Int): MutableLiveData<CharacterModel> {
        return repository.fetchCharacterId(position)
    }
}
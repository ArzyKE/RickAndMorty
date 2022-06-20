package com.example.rickandmortyapikotlin.ui.fragments.character

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapikotlin.data.repositories.CharacterRepository
import com.example.rickandmortyapikotlin.model.CharacterModel
import com.example.rickandmortyapikotlin.model.RickyMortyResponse

class CharacterViewModel : ViewModel() {

    private val repository = CharacterRepository()

    fun fetchCharacters(): MutableLiveData<RickyMortyResponse<CharacterModel>> {
        return repository.fetchCharacters()
    }

    fun getCharacters(): ArrayList<CharacterModel> {
        return repository.getCharacters()
    }
}



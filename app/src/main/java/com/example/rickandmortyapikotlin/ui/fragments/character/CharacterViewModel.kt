package com.example.rickandmortyapikotlin.ui.fragments.character

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapikotlin.App
import com.example.rickandmortyapikotlin.model.CharacterModel
import com.example.rickandmortyapikotlin.model.RickyMortyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterViewModel : ViewModel() {

//    private val repository = CharacterRepository()
//
//    fun fetchCharacters(): MutableLiveData<RickyMortyResponse<CharacterModel>> {
//        return repository.fetchCharacters()
//    }
//
//    fun fetchCharactersId():MutableLiveData<CharacterModel>{
//        return repository.fetchCharacterId(fetchCharactersId())
//    }
//

    val data: MutableLiveData<RickyMortyResponse<CharacterModel>> = MutableLiveData()
    val dataDetail: MutableLiveData<CharacterModel> = MutableLiveData()

    fun fetchCharacters(): MutableLiveData<RickyMortyResponse<CharacterModel>> {
        App.characterApiServices?.fetchCharacters()
            ?.enqueue(object : Callback<RickyMortyResponse<CharacterModel>> {
                override fun onResponse(
                    call: Call<RickyMortyResponse<CharacterModel>>,
                    response: Response<RickyMortyResponse<CharacterModel>>
                ) {
                    data.value = response.body()
                }

                override fun onFailure(
                    call: Call<RickyMortyResponse<CharacterModel>>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }
    fun fetchCharactersId(id:Int):MutableLiveData<CharacterModel>{
        App.characterApiServices?.fetchCharacterId(id)
            ?.enqueue(object : Callback<CharacterModel> {
                override fun onResponse(
                    call: Call<CharacterModel>,
                    response: Response<CharacterModel>
                ) {
                    dataDetail.value = response.body()
                }

                override fun onFailure(
                    call: Call<CharacterModel>,
                    t: Throwable
                ) {
                    dataDetail.value = null
                }
            })
        return dataDetail
    }
}
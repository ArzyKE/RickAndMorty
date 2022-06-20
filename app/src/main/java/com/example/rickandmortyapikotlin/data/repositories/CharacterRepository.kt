package com.example.rickandmortyapikotlin.data.repositories

import androidx.lifecycle.MutableLiveData
import com.example.rickandmortyapikotlin.App
import com.example.rickandmortyapikotlin.model.CharacterModel
import com.example.rickandmortyapikotlin.model.RickyMortyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterRepository {

    val data: MutableLiveData<RickyMortyResponse<CharacterModel>> = MutableLiveData()

    fun fetchCharacters(): MutableLiveData<RickyMortyResponse<CharacterModel>> {
        App.characterApiServices?.fetchCharacters()
            ?.enqueue(object : Callback<RickyMortyResponse<CharacterModel>> {
                override fun onResponse(
                    call: Call<RickyMortyResponse<CharacterModel>>,
                    response: Response<RickyMortyResponse<CharacterModel>>
                ) {
                    if (response.body() != null) {
                        App.characterDao?.insertAll(response.body()!!.results)
                        data.value = response.body()
                    }
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

    fun getCharacters(): ArrayList<CharacterModel> {
        val list: ArrayList<CharacterModel> = ArrayList()
        App.characterDao?.let { list.addAll(it.getAll()) }
        return list
    }


    fun fetchCharacterId(id: Int): MutableLiveData<CharacterModel> {
        val data: MutableLiveData<CharacterModel> = MutableLiveData()
        App.characterApiServices?.fetchCharacterId(id)?.enqueue(object : Callback<CharacterModel> {
            override fun onResponse(
                call: Call<CharacterModel>,
                response: Response<CharacterModel>
            ) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<CharacterModel>, t: Throwable) {
                data.value = null
            }
        })
        return data
    }
}

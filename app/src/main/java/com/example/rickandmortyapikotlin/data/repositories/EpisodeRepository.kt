package com.example.rickandmortyapikotlin.data.repositories

import androidx.lifecycle.MutableLiveData
import com.example.rickandmortyapikotlin.App
import com.example.rickandmortyapikotlin.model.EpisodeModel
import com.example.rickandmortyapikotlin.model.RickyMortyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EpisodeRepository {

    val data: MutableLiveData<RickyMortyResponse<EpisodeModel>> = MutableLiveData()

    fun fetchEpisode(): MutableLiveData<RickyMortyResponse<EpisodeModel>> {
        App.episodeApiServices?.fetchEpisode()
            ?.enqueue(object : Callback<RickyMortyResponse<EpisodeModel>> {
                override fun onResponse(
                    call: Call<RickyMortyResponse<EpisodeModel>>,
                    response: Response<RickyMortyResponse<EpisodeModel>>
                ) {
                    data.value = response.body()
                }

                override fun onFailure(call: Call<RickyMortyResponse<EpisodeModel>>, t: Throwable) {
                    data.value = null
                }

            })
        return data
    }

    fun getEpisode(): ArrayList<EpisodeModel> {
        val list: ArrayList<EpisodeModel> = ArrayList()
        App.episodeDao?.let { list.addAll(it.getAll()) }
        return list
    }

    fun fetchEpisodeId(id: Int): MutableLiveData<EpisodeModel> {
        val data: MutableLiveData<EpisodeModel> = MutableLiveData()
        App.episodeApiServices?.episodeId(id)?.enqueue(object : Callback<EpisodeModel> {
            override fun onResponse(
                call: Call<EpisodeModel>,
                response: Response<EpisodeModel>
            ) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<EpisodeModel>, t: Throwable) {
                data.value = null
            }
        })
        return data
    }
}
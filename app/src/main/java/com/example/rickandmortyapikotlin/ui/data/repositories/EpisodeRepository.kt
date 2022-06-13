package com.example.rickandmortyapikotlin.ui.data.repositories

import androidx.lifecycle.MutableLiveData
import com.example.rickandmortyapikotlin.App
import com.example.rickandmortyapikotlin.model.EpisodeModel
import com.example.rickandmortyapikotlin.model.RickyMortyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EpisodeRepository {
//
//    val data: MutableLiveData<RickyMortyResponse<EpisodeModel>> = MutableLiveData()
//
//    fun fetchEpisode(): MutableLiveData<RickyMortyResponse<EpisodeModel>> {
//        val data: MutableLiveData<RickyMortyResponse<EpisodeModel>> = MutableLiveData()
//        App.episodeApiServices?.fetchEpisode()
//            ?.enqueue(object : Callback<RickyMortyResponse<EpisodeModel>> {
//                override fun onResponse(
//                    call: Call<RickyMortyResponse<EpisodeModel>>,
//                    response: Response<RickyMortyResponse<EpisodeModel>>
//                ) {
//                    if (response.body() != null)
//                        data.value = response.body()
//                }
//
//                override fun onFailure(
//                    call: Call<RickyMortyResponse<EpisodeModel>>,
//                    t: Throwable
//                ) {
//                    data.value = null
//                }
//
//            })
//        return data
//    }

}
package com.example.rickandmortyapikotlin.model

import com.google.gson.annotations.SerializedName

data class EpisodeModel(

    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("air_date")
    var air_date: String,
)

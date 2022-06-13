package com.example.rickandmortyapikotlin.model

import com.google.gson.annotations.SerializedName

data class LocationModel(

    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("type")
    var type: String,
)

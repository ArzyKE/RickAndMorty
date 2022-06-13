package com.example.rickandmortyapikotlin.model

import android.icu.text.IDNA
import com.google.gson.annotations.SerializedName

data class RickyMortyResponse<T>(

    @SerializedName("info")
    val info: Info,

    @SerializedName("results")
    val results: ArrayList<T>,
)
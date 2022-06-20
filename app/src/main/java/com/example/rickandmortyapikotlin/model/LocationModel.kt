package com.example.rickandmortyapikotlin.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity("location")
data class LocationModel(

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("type")
    var type: String,
)

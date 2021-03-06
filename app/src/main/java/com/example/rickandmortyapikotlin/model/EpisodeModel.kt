package com.example.rickandmortyapikotlin.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "episode")
data class EpisodeModel(

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("air_date")
    var air_date: String,
)

package com.alvaroestrada.rickandmorty.domain.model

import com.google.gson.annotations.SerializedName

data class OriginRemote(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)

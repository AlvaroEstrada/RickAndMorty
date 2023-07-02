package com.alvaroestrada.rickandmorty.data.model

import com.google.gson.annotations.SerializedName

data class OriginInfo(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)

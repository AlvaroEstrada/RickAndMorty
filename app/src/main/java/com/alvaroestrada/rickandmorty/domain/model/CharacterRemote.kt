package com.alvaroestrada.rickandmorty.domain.model

import android.graphics.Bitmap
import com.google.gson.annotations.SerializedName

data class CharacterRemote(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("species")
    val species: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("origin")
    val origin: OriginRemote,
    @SerializedName("location")
    val location: LocationRemote,
    @SerializedName("image")
    val image: Bitmap,
    @SerializedName("episode")
    val episode: String,
    @SerializedName("url")
    val url: String
)

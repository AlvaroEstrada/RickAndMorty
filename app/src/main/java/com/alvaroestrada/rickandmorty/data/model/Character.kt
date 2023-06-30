package com.alvaroestrada.rickandmorty.data.model

import android.graphics.Bitmap

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Origin,
    val location: Location,
    val image: Bitmap,
    val episode: String,
    val url: String
)
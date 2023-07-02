package com.alvaroestrada.rickandmorty.domain.model

import com.alvaroestrada.rickandmorty.data.model.Character
import com.alvaroestrada.rickandmorty.data.model.Info
import com.google.gson.annotations.SerializedName

data class CharactersRemote(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val characterList: List<Character>
)

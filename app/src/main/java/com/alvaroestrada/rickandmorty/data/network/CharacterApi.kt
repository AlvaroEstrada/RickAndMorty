package com.alvaroestrada.rickandmorty.data.network

import com.alvaroestrada.rickandmorty.data.model.Character
import com.alvaroestrada.rickandmorty.domain.model.CharactersRemote
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApi {

    @GET("character")
    suspend fun getCharacters(@Query("page") page: Int): CharactersRemote

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: Int): Character
}
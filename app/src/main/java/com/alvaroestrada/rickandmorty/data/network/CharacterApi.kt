package com.alvaroestrada.rickandmorty.data.network

import com.alvaroestrada.rickandmorty.domain.model.CharacterRemote
import retrofit2.Response
import retrofit2.http.GET

interface CharacterApi {

    @GET("/character")
    suspend fun getAllCharacters(): Response<List<CharacterRemote>>
}
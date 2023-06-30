package com.alvaroestrada.rickandmorty.data.network

import com.alvaroestrada.rickandmorty.domain.model.CharacterRemote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CharacterService @Inject constructor(
    private val api: CharacterApi
) {
        suspend fun getCharacters(): List<CharacterRemote> {
            return withContext(Dispatchers.IO) {
                val response = api.getAllCharacters()
                response.body() ?: emptyList()
            }
        }
}
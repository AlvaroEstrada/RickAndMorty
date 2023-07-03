package com.alvaroestrada.rickandmorty.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.alvaroestrada.rickandmorty.data.model.Character
import com.alvaroestrada.rickandmorty.data.network.CharacterApi
import com.alvaroestrada.rickandmorty.data.network.paging.CharactersPagingSource
import com.alvaroestrada.rickandmorty.domain.model.CharactersRemote
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val api: CharacterApi
) {
    fun getCharacters(page: Int): Flow<CharactersRemote> = flow {
        emit(api.getCharacters(page))
    }

    fun getCharacter(id: Int): Flow<Character> = flow {
        emit(api.getCharacter(id))
    }

}
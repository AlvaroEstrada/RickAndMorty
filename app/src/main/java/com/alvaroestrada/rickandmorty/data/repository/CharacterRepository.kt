package com.alvaroestrada.rickandmorty.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.alvaroestrada.rickandmorty.data.model.Character
import com.alvaroestrada.rickandmorty.data.network.CharacterApi
import com.alvaroestrada.rickandmorty.data.network.paging.CharactersPagingSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val api: CharacterApi
) {
    fun getCharacters() = Pager(
        config = PagingConfig(pageSize = 20),
        pagingSourceFactory = { CharactersPagingSource(api) }
    ).flow

    fun getCharacter(id: Int): Flow<Character> = flow {
        emit(api.getCharacter(id))
    }

}
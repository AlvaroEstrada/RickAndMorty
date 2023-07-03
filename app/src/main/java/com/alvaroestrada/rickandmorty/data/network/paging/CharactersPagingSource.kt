package com.alvaroestrada.rickandmorty.data.network.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.alvaroestrada.rickandmorty.data.model.Character
import com.alvaroestrada.rickandmorty.data.network.CharacterApi
import com.alvaroestrada.rickandmorty.data.repository.CharacterRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class CharactersPagingSource @Inject constructor(
    private val repository: CharacterRepository
) :
    PagingSource<Int, Character>() {

    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        return try {
            val page = params.key ?: 1
            val response = repository.getCharacters(page).first().characterList

            LoadResult.Page(
                data = response,
                prevKey = if (page == 1) null else page.minus(1),
                nextKey = if (response.isEmpty()) null else page.plus(1),
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}
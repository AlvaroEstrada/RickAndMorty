package com.alvaroestrada.rickandmorty.data.network.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.alvaroestrada.rickandmorty.data.model.Character
import com.alvaroestrada.rickandmorty.data.network.CharacterApi

class CharactersPagingSource(private val api: CharacterApi) : PagingSource<Int, Character>() {

    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        return try {
            val page = params.key ?: 1
            val response = api.getCharacters(page = page)

            LoadResult.Page(
                data = response.characterList,
                prevKey = if (page == 1) null else page.minus(1),
                nextKey = if (response.characterList.isEmpty()) null else page.plus(1),
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}
package com.alvaroestrada.rickandmorty.domain.usecases

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.alvaroestrada.rickandmorty.data.network.paging.CharactersPagingSource
import com.alvaroestrada.rickandmorty.data.repository.CharacterRepository
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    operator fun invoke() = repository.getCharacters()
}
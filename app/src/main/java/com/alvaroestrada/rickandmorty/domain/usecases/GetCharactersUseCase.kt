package com.alvaroestrada.rickandmorty.domain.usecases

import com.alvaroestrada.rickandmorty.data.repository.LocalRepository
import com.alvaroestrada.rickandmorty.domain.repository.RemoteRepository
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val remote: RemoteRepository,
    private val local: LocalRepository
) {

}
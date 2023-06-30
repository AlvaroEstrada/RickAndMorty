package com.alvaroestrada.rickandmorty.domain.repository

import com.alvaroestrada.rickandmorty.data.network.CharacterService
import javax.inject.Inject

class RemoteRepository @Inject constructor(
    private val charService: CharacterService
) {
}
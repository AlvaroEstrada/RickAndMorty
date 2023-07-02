package com.alvaroestrada.rickandmorty.core.extensions

import com.alvaroestrada.rickandmorty.data.model.DataCharacters
import com.alvaroestrada.rickandmorty.domain.model.CharactersRemote

fun CharactersRemote.toDomain(): DataCharacters = DataCharacters(
    info,
    characterList
)
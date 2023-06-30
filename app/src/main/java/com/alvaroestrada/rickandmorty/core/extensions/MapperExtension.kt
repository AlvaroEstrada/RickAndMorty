package com.alvaroestrada.rickandmorty.core.extensions

import android.graphics.Bitmap
import com.alvaroestrada.rickandmorty.data.model.Character
import com.alvaroestrada.rickandmorty.data.model.Location
import com.alvaroestrada.rickandmorty.data.model.Origin
import com.alvaroestrada.rickandmorty.domain.model.CharacterRemote
import com.alvaroestrada.rickandmorty.domain.model.LocationRemote
import com.alvaroestrada.rickandmorty.domain.model.OriginRemote

fun CharacterRemote.toDomain(): Character = Character(
    this.id,
    this.name,
    this.status,
    this.species,
    this.type,
    this.gender,
    this.origin.toDomain(),
    this.location.toDomain(),
    this.image,
    this.episode,
    this.url,
)

fun OriginRemote.toDomain(): Origin = Origin(
    this.name,
    this.url
)

fun LocationRemote.toDomain(): Location = Location(
    this.name,
    this.url
)
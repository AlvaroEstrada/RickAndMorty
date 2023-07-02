package com.alvaroestrada.rickandmorty.ui.uistates

import com.alvaroestrada.rickandmorty.data.model.Character

data class ListUiState(
    val isLoading: Boolean = true,
    val characterList: List<Character> = emptyList()
)

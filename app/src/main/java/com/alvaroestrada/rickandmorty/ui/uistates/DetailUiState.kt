package com.alvaroestrada.rickandmorty.ui.uistates

import com.alvaroestrada.rickandmorty.data.model.Character

data class DetailUiState(
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val character: Character?
)

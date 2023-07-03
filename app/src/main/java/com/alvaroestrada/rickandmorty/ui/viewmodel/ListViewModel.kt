package com.alvaroestrada.rickandmorty.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.alvaroestrada.rickandmorty.data.model.Character
import com.alvaroestrada.rickandmorty.domain.usecases.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    fun getCharacters(): Flow<PagingData<Character>> = getCharactersUseCase(20)

}
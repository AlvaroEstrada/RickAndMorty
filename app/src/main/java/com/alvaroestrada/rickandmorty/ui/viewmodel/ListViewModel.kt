package com.alvaroestrada.rickandmorty.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.alvaroestrada.rickandmorty.data.model.Character
import com.alvaroestrada.rickandmorty.data.repository.CharacterRepository
import com.alvaroestrada.rickandmorty.domain.usecases.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val repository: CharacterRepository,
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getCharacters()
        }
    }

    /*fun getCharacters(): Flow<PagingData<Character>> =
        repository.getCharacters()
            .catch { Timber.e(it.message) }
            .cachedIn(viewModelScope)*/

    fun getCharacters(): Flow<PagingData<Character>> = getCharactersUseCase()
}
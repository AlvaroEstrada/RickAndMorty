package com.alvaroestrada.rickandmorty.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alvaroestrada.rickandmorty.data.repository.CharacterRepository
import com.alvaroestrada.rickandmorty.ui.uistates.DetailUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(DetailUiState(character = null))
    val uiState = _uiState.asStateFlow()

    fun getCharacter(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getCharacter(id).catch {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    isError = true,
                )
                Timber.i("Loading = false")
            }.collect {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    character = it
                )
                Timber.i("Loading = false")
            }
        }
    }

}


package com.alvaroestrada.rickandmorty.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.alvaroestrada.rickandmorty.domain.usecases.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
): ViewModel() {

}
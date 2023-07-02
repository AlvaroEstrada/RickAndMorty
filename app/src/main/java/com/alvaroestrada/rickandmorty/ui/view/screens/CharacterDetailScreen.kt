package com.alvaroestrada.rickandmorty.ui.view.screens

import android.util.Log
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.alvaroestrada.rickandmorty.data.model.Character
import com.alvaroestrada.rickandmorty.ui.viewmodel.DetailsViewModel
import timber.log.Timber

@Composable
fun CharacterDetailScreen(id: Int) {
    val viewModel: DetailsViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsState()
    viewModel.getCharacter(id)

    Log.i("LOAD","LOAD DETAILS ---> CARGADA")

    if (uiState.isLoading) {
        DetailLoadingScreen()
    } else if (uiState.isError){
        //TODO Error Screen
    } else {
        CharacterDetail(uiState.character!!)
    }
}

@Composable
fun DetailLoadingScreen(){
    Text(text = "Cargando")
}

@Composable
fun CharacterDetail(character: Character){
    Text(text = character.name)
}

@Preview(showSystemUi = true)
@Composable
fun DetailPreview(){
    CharacterDetailScreen(id = 1)
}
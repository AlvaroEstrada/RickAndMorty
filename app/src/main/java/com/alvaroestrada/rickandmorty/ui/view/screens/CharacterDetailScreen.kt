package com.alvaroestrada.rickandmorty.ui.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import coil.size.Scale
import com.alvaroestrada.rickandmorty.data.model.Character
import com.alvaroestrada.rickandmorty.ui.theme.DarkLightPurple
import com.alvaroestrada.rickandmorty.ui.theme.DarkPurple
import com.alvaroestrada.rickandmorty.ui.theme.Error
import com.alvaroestrada.rickandmorty.ui.theme.LightGrey
import com.alvaroestrada.rickandmorty.ui.theme.Success
import com.alvaroestrada.rickandmorty.ui.theme.WhiteGrey
import com.alvaroestrada.rickandmorty.ui.viewmodel.DetailsViewModel

@Composable
fun CharacterDetailScreen(id: Int) {
    val viewModel: DetailsViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsState()
    viewModel.getCharacter(id)

    if (uiState.isLoading) {
        DetailLoadingScreen()
    } else if (uiState.isError) {
        //TODO Error Screen
    } else {
        CharacterDetail(uiState.character!!)
    }
}

@Composable
fun DetailLoadingScreen() {
    Text(text = "Cargando")
}

@Composable
fun CharacterDetail(character: Character) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkLightPurple)
    ) {
        val (image, name, status, info) = createRefs()

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(300.dp)
                .clip(RoundedCornerShape(8.dp))
                .constrainAs(image) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                },
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(character.image)
                    .scale(Scale.FIT)
                    .crossfade(true)
                    .diskCachePolicy(CachePolicy.ENABLED)
                    .networkCachePolicy(CachePolicy.ENABLED)
                    .build(),
                contentDescription = "Character Image",
                contentScale = ContentScale.Crop
            )
        }

        Text(
            text = character.name,
            style = MaterialTheme.typography.h4,
            color = WhiteGrey,
            modifier = Modifier
                .constrainAs(name) {
                    top.linkTo(image.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Card(
            modifier = Modifier
                .padding(top = 8.dp)
                .clip(RoundedCornerShape(60.dp))
                .constrainAs(status) {
                    top.linkTo(name.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            Text(
                text = character.status,
                style = MaterialTheme.typography.h5,
                color = WhiteGrey,
                modifier = Modifier
                    .background(getStatusColor(character.status))
                    .padding(horizontal = 32.dp, vertical = 4.dp)
            )
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clip(RoundedCornerShape(8.dp))
                .constrainAs(info) {
                    start.linkTo(parent.start)
                    top.linkTo(status.bottom)
                    end.linkTo(parent.end)
                },
        ) {
            Column(
                modifier = Modifier
                    .background(DarkPurple)
                    .padding(8.dp)
                    .verticalScroll(rememberScrollState())
                    .padding(8.dp)
            ) {
                Text(
                    text = "Specie: ${character.species}",
                    style = MaterialTheme.typography.body1,
                    color = WhiteGrey,
                )
                if (character.type.isNotEmpty()) {
                    Text(
                        text = "Type: ${character.type}",
                        style = MaterialTheme.typography.body1,
                        color = WhiteGrey,
                    )
                }

                Text(
                    text = "Gender: ${character.gender}",
                    style = MaterialTheme.typography.body1,
                    color = WhiteGrey,
                )
                Text(
                    text = "Origin: ${character.origin.name}",
                    style = MaterialTheme.typography.body1,
                    color = WhiteGrey,
                )
                Text(
                    text = "Location: ${character.location.name}",
                    style = MaterialTheme.typography.body1,
                    color = WhiteGrey,
                )
            }
        }
    }
}

private fun getStatusColor(status: String): Color {
    return when (status) {
        "Alive" -> {
            Success
        }

        "Dead" -> {
            Error
        }

        else -> {
            LightGrey
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DetailPreview() {
    //CharacterDetail()
}
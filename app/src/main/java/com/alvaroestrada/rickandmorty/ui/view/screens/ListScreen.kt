package com.alvaroestrada.rickandmorty.ui.view.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.alvaroestrada.rickandmorty.R
import com.alvaroestrada.rickandmorty.data.model.Character
import com.alvaroestrada.rickandmorty.ui.composables.AppBar
import com.alvaroestrada.rickandmorty.ui.composables.ItemCharacter
import com.alvaroestrada.rickandmorty.ui.theme.DarkLightPurple
import com.alvaroestrada.rickandmorty.ui.theme.DarkPurple
import com.alvaroestrada.rickandmorty.ui.theme.WhiteGrey
import com.alvaroestrada.rickandmorty.ui.viewmodel.ListViewModel

@Composable
fun ListScreen(characters: LazyPagingItems<Character>, onItemClick: (Character) -> Unit) {

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkPurple),
        topBar = { AppBar() }
    ) { innerPadding ->
        CharacterList(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(DarkLightPurple),
            characters,
            onItemClick = onItemClick
        )
    }
}

@Composable
fun LoadingScreen() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkLightPurple)
    ) {
        val (imageLoading, progressContainer) = createRefs()
        val topGuide = createGuidelineFromTop(0.2f)

        Image(
            painter = painterResource(id = R.drawable.ic_loading),
            contentDescription = "Loading",
            modifier = Modifier
                .width(250.dp)
                .constrainAs(imageLoading) {
                    top.linkTo(topGuide)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            colorFilter = ColorFilter.tint(WhiteGrey)

        )

        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(progressContainer) {
                    top.linkTo(imageLoading.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            val (progressIndicator, progressText) = createRefs()

            CircularProgressIndicator(
                modifier = Modifier
                    .width(40.dp)
                    .padding(8.dp)
                    .constrainAs(progressIndicator) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                    }
            )
            Text(
                text = "Bringing back your favorite characters",
                style = MaterialTheme.typography.subtitle1,
                color = WhiteGrey,
                modifier = Modifier
                    .padding(8.dp)
                    .constrainAs(progressText) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(progressIndicator.bottom)
                    }
            )

        }
    }
}

@Composable
fun CharacterList(
    modifier: Modifier = Modifier,
    characters: LazyPagingItems<Character>,
    onItemClick: (Character) -> Unit
) {

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(
            items = characters,
            key = { it.url }
        ) { character ->
            if (character != null) ItemCharacter(character, onItemClick)
        }

        when (characters.loadState.refresh) { //FIRST LOAD
            is LoadState.Error -> {
                //TODO Error Item
                //state.error to get error message
            }

            is LoadState.Loading -> {
                item {
                    LoadingScreen()
                }
            }

            else -> {}
        }

        when (characters.loadState.append) {
            is LoadState.Error -> {
                //TODO Pagination Error Item
                //state.error to get error message
            }

            is LoadState.Loading -> {
                item {
                    ConstraintLayout(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        val progressIndicator = createRef()

                        CircularProgressIndicator(
                            modifier = Modifier
                                .width(40.dp)
                                .padding(8.dp)
                                .constrainAs(progressIndicator) {
                                    start.linkTo(parent.start)
                                    top.linkTo(parent.top)
                                    end.linkTo(parent.end)
                                    start.linkTo(parent.start)
                                }
                        )
                    }
                }
            }

            else -> {}
        }
    }
}
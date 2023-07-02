package com.alvaroestrada.rickandmorty.ui.navigation

sealed class NavigationRoutes(val route: String) {

    object ListScreen : NavigationRoutes("LIST_SCREEN")
    object CharacterDetailScreen : NavigationRoutes("CHARACTER_DETAIL_SCREEN/{id}")

}
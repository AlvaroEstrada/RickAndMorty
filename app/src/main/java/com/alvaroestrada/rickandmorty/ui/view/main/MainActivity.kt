package com.alvaroestrada.rickandmorty.ui.view.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.alvaroestrada.rickandmorty.ui.navigation.NavigationRoutes.CharacterDetailScreen
import com.alvaroestrada.rickandmorty.ui.navigation.NavigationRoutes.ListScreen
import com.alvaroestrada.rickandmorty.ui.theme.RickAndMortyTheme
import com.alvaroestrada.rickandmorty.ui.view.screens.CharacterDetailScreen
import com.alvaroestrada.rickandmorty.ui.view.screens.ListScreen
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RickAndMortyTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = ListScreen.route
                ) {
                    composable(ListScreen.route) {
                        ListScreen {
                            navController.navigate("CHARACTER_DETAIL_SCREEN/${it.id}") {
                                launchSingleTop = true
                            }
                        }
                    }

                    composable(
                        CharacterDetailScreen.route,
                        arguments = listOf(navArgument("id") { type = NavType.IntType })
                    ) { backStackEntry ->
                        CharacterDetailScreen(backStackEntry.arguments?.getInt("id") ?: 0)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RickAndMortyTheme {
        //ListScreen()
    }
}
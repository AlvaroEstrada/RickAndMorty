package com.alvaroestrada.rickandmorty.ui.view.main

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.lifecycleScope
import com.alvaroestrada.rickandmorty.data.model.Character
import com.alvaroestrada.rickandmorty.data.model.Location
import com.alvaroestrada.rickandmorty.data.model.Origin
import com.alvaroestrada.rickandmorty.ui.composables.AppBar
import com.alvaroestrada.rickandmorty.ui.composables.ItemCharacter
import com.alvaroestrada.rickandmorty.ui.theme.DarkLightPurple
import com.alvaroestrada.rickandmorty.ui.theme.DarkPurple
import com.alvaroestrada.rickandmorty.ui.theme.RickAndMortyTheme
import com.alvaroestrada.rickandmorty.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException
import java.net.URL
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RickAndMortyTheme {

                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(DarkPurple),
                    topBar = { AppBar() }
                ) { innerPadding ->
                    ConstraintLayout(
                        Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                            .background(DarkLightPurple)) {

                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(top = 0.dp, bottom = 8.dp, start = 8.dp, end = 8.dp),
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            val characters = createCharacters()
                            items (characters){
                                ItemCharacter(it)
                            }
                        }
                    }
                }
            }
        }
    }

    fun createCharacters(): List<Character>{
        return listOf(
            Character(
            id = 0,
            name = "Canklanker Thom",
            status = "Dead",
            species = "Alien",
            type = "Gromflomite",
            gender = "Male",
            origin = Origin("Gromflom Prime", "https://rickandmortyapi.com/api/location/19"),
            location = Location("unknown", ""),
            image = getImage("https://rickandmortyapi.com/api/character/avatar/62.jpeg"),
            episode = "https://rickandmortyapi.com/api/episode/1",
            url = ""
            ),
            Character(
                id = 0,
                name = "Bill",
                status = "Alive",
                species = "Human",
                type = "Gromflomite",
                gender = "Male",
                origin = Origin("Gromflom Prime", "https://rickandmortyapi.com/api/location/19"),
                location = Location("unknown", ""),
                image = getImage("https://rickandmortyapi.com/api/character/avatar/62.jpeg"),
                episode = "https://rickandmortyapi.com/api/episode/1",
                url = ""
            ),
            Character(
                id = 0,
                name = "Darth Poopybutthole",
                status = "unknow",
                species = "Poopybutthole",
                type = "Gromflomite",
                gender = "Male",
                origin = Origin("Gromflom Prime", "https://rickandmortyapi.com/api/location/19"),
                location = Location("unknown", ""),
                image = getImage("https://rickandmortyapi.com/api/character/avatar/62.jpeg"),
                episode = "https://rickandmortyapi.com/api/episode/1",
                url = ""
            ),
        )
    }

    fun getImage(imageUrl: String): Bitmap {
        var image: Bitmap = BitmapFactory.decodeStream(assets.open("error404.png"))
        lifecycleScope.launch(Dispatchers.IO){
            try {
                val url = URL(imageUrl)
                image = BitmapFactory.decodeStream(url.openConnection().getInputStream())
            } catch (e: IOException) {
                println(e)
            }
        }
        return image
    }
}



@Composable
fun MainScreen(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RickAndMortyTheme {
        MainScreen(name = "Alvaro")
    }
}
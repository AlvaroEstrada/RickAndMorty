package com.alvaroestrada.rickandmorty.ui.composables

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.layout
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.alvaroestrada.rickandmorty.data.model.Character
import com.alvaroestrada.rickandmorty.ui.theme.ClearGrey
import com.alvaroestrada.rickandmorty.ui.theme.DarkPurple
import com.alvaroestrada.rickandmorty.ui.theme.Error
import com.alvaroestrada.rickandmorty.ui.theme.Success
import com.alvaroestrada.rickandmorty.ui.theme.WhiteGrey

@Composable
fun ItemCharacter(character: Character) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(8.dp)
            .background(Color.Transparent),
        elevation = 5.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(DarkPurple)
        ) {
            val (image, nameCharacter, statusIndicator, gender, specie) = createRefs()
            Image(
                bitmap = character.image.asImageBitmap(),
                contentDescription = "Example Photo",
                modifier = Modifier
                    .fillMaxHeight()
                    .constrainAs(image) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
            )

            Text(
                text = character.name,
                style = MaterialTheme.typography.h5,
                color = WhiteGrey,
                modifier = Modifier
                    .padding(start = 16.dp, top = 8.dp, bottom = 8.dp)
                    .constrainAs(nameCharacter) {
                        start.linkTo(image.end)
                        top.linkTo(parent.top)
                    }
            )

            when (character.status){
                "Alive" -> {
                    Text(
                        modifier = Modifier
                            .vertical()
                            .rotate(-90f)
                            .background(Success)
                            .constrainAs(statusIndicator) {
                                end.linkTo(parent.end)
                                top.linkTo(parent.top)
                                bottom.linkTo(parent.bottom)
                            }
                            .padding(start = 50.dp, end = 50.dp, top = 4.dp, bottom = 4.dp),
                        text = character.status,
                        color = WhiteGrey,
                        textAlign = TextAlign.Center
                    )
                }
                "Dead" -> {
                    Text(
                        modifier = Modifier
                            .vertical()
                            .rotate(-90f)
                            .background(Error)
                            .constrainAs(statusIndicator) {
                                end.linkTo(parent.end)
                                top.linkTo(parent.top)
                                bottom.linkTo(parent.bottom)
                            }
                            .padding(start = 50.dp, end = 50.dp, top = 4.dp, bottom = 4.dp),
                        text = character.status,
                        color = WhiteGrey,
                        textAlign = TextAlign.Center
                    )
                }
                else -> {
                    Text(
                        modifier = Modifier
                            .vertical()
                            .rotate(-90f)
                            .background(ClearGrey)
                            .constrainAs(statusIndicator) {
                                end.linkTo(parent.end)
                                top.linkTo(parent.top)
                                bottom.linkTo(parent.bottom)
                            }
                            .padding(start = 50.dp, end = 50.dp, top = 4.dp, bottom = 4.dp),
                        text = "Unknow",
                        color = WhiteGrey,
                        textAlign = TextAlign.Center
                    )
                }
            }

            Text(
                text = character.gender + "  ·  ",
                style = MaterialTheme.typography.subtitle1,
                color = WhiteGrey,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .constrainAs(gender) {
                        start.linkTo(nameCharacter.start)
                        top.linkTo(nameCharacter.bottom)
                    }
            )

            Text(
                text = character.species,
                style = MaterialTheme.typography.subtitle1,
                color = WhiteGrey,
                modifier = Modifier
                    .constrainAs(specie) {
                        start.linkTo(gender.end)
                        top.linkTo(nameCharacter.bottom)
                    }
            )

        }
    }
}

fun Modifier.vertical() =
    layout { measurable, constraints ->
        val placeable = measurable.measure(constraints)
        layout(placeable.height, placeable.width) {
            placeable.place(
                x = -(placeable.width / 2 - placeable.height / 2),
                y = -(placeable.height / 2 - placeable.width / 2)
            )
        }
    }

@Preview(showBackground = true)
@Composable
fun ItemCharacterPreview() {
    //ItemCharacter(context = MainActivity::class.java)
}
package com.alvaroestrada.rickandmorty.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.alvaroestrada.rickandmorty.R
import com.alvaroestrada.rickandmorty.ui.theme.DarkPurple
import com.alvaroestrada.rickandmorty.ui.theme.WhiteGrey

@Composable
internal fun AppBar() {
    TopAppBar(
        backgroundColor = DarkPurple,
        elevation = 5.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {

        ConstraintLayout(Modifier.fillMaxWidth()) {
            val (image, mortyText) = createRefs()

            Image(
                painter = painterResource(id = R.drawable.ic_rickandmorty),
                contentDescription = "Logo",
                modifier = Modifier
                    .width(70.dp)
                    .padding(start = 16.dp)
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                    },
                colorFilter = ColorFilter.tint(WhiteGrey)
            )

            Text(
                text = "Rick and Morty",
                style = MaterialTheme.typography.h1,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .constrainAs(mortyText) {
                        top.linkTo(parent.top)
                        start.linkTo(image.end)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end)
                    }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppBar()
}
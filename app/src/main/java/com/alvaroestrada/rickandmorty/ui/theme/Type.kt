package com.alvaroestrada.rickandmorty.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.alvaroestrada.rickandmorty.R


val Roboto = FontFamily(
    Font(R.font.roboto_black, FontWeight.Black),
    Font(R.font.roboto_light, FontWeight.Light),
    Font(R.font.roboto_medium, FontWeight.Medium),
    Font(R.font.roboto_regular, FontWeight.Normal),
)

val RickAndMorty = FontFamily(
    Font(R.font.get_schwifty)
)

val Typography = Typography(

    h1 = TextStyle(
        fontFamily = RickAndMorty,
        fontSize = 40.sp,
        color = WhiteGrey,
        fontWeight = FontWeight.Black
    ),

    h2 = TextStyle(
        fontFamily = Roboto,
        fontSize = 35.sp,
        color = WhiteGrey,
        fontWeight = FontWeight.Black
    ),

    h3 = TextStyle(
        fontFamily = Roboto,
        fontSize = 30.sp,
        color = WhiteGrey,
        fontWeight = FontWeight.Black
    ),

    h4 = TextStyle(
        fontFamily = Roboto,
        fontSize = 25.sp,
        color = WhiteGrey,
        fontWeight = FontWeight.Black
    ),

    h5 = TextStyle(
        fontFamily = Roboto,
        fontSize = 20.sp,
        color = WhiteGrey,
        fontWeight = FontWeight.Black
    ),

    h6 = TextStyle(
        fontFamily = Roboto,
        fontSize = 16.sp,
        color = WhiteGrey,
        fontWeight = FontWeight.Black
    ),

    subtitle1 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
    ),

    body1 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
    )
)
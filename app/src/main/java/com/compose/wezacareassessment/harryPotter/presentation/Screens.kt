package com.compose.wezacareassessment.harryPotter.presentation

sealed class Screens(val route: String){
    object CharactersScreen: Screens("characters_screen")
    object CharacterInfoscreen: Screens("character_info_screen")
}

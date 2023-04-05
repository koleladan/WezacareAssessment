package com.compose.wezacareassessment.harryPotter.presentation.characters

import retrofit2.http.Query

sealed class CharactersEvent {
    data class OnSearchQueryChange(val query: String): CharactersEvent()
}
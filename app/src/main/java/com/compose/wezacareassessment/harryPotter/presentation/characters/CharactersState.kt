package com.compose.wezacareassessment.harryPotter.presentation.characters

import com.compose.wezacareassessment.harryPotter.domain.model.Characters

data class CharactersState(
    val characters:List<Characters>? = emptyList(),
    val isLoading:Boolean = false,
    val searchQuery: String? = ""

)

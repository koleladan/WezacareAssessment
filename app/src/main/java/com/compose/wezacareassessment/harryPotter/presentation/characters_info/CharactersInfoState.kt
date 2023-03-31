package com.compose.wezacareassessment.harryPotter.presentation.characters_info

import com.compose.wezacareassessment.harryPotter.domain.model.Characters

data class CharactersInfoState(
    val character: List<Characters>? = emptyList(),
    val  isLoading:Boolean =false,
    val  error:String? = null
)

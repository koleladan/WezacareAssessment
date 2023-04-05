package com.compose.wezacareassessment.harryPotter.presentation.characters_info

import com.compose.wezacareassessment.harryPotter.domain.model.CharacterInfo
import com.compose.wezacareassessment.harryPotter.domain.model.Characters
import com.compose.wezacareassessment.harryPotter.presentation.characters.CharactersState

data class CharactersInfoState(
    val character: CharacterInfo? = null,
    val  isLoading:Boolean =false,
    val  error:String? = null
)

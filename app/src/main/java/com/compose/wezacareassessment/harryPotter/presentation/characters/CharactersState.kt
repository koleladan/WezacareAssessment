package com.compose.wezacareassessment.harryPotter.presentation.characters

import androidx.compose.runtime.State
import com.compose.wezacareassessment.harryPotter.domain.model.Characters

data class CharactersState(
    var characters: List<Characters> = emptyList(),
    val isLoading:Boolean = false,
    val searchQuery: String? = "",
    val error:String = "",
    var isSearching:Boolean = false,
    var isSearchngStarting:Boolean = true

)

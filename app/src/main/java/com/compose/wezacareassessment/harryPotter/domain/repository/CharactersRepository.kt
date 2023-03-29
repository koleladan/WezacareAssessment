package com.compose.wezacareassessment.harryPotter.domain.repository

import com.compose.wezacareassessment.core.util.Resource
import com.compose.wezacareassessment.harryPotter.domain.model.Characters
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {
    fun getAllCharacters(): Flow<Resource<Characters>>
}
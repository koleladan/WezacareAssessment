package com.compose.wezacareassessment.harryPotter.domain.usecases

import com.compose.wezacareassessment.core.util.Resource
import com.compose.wezacareassessment.harryPotter.domain.model.Characters
import com.compose.wezacareassessment.harryPotter.domain.repository.CharactersRepository
import kotlinx.coroutines.flow.Flow

class GetAllCharacters(
    val repository: CharactersRepository
) {
    operator fun  invoke(): Flow<Resource<Characters>>{
        return  repository.getAllCharacters()
    }

}
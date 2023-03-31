package com.compose.wezacareassessment.harryPotter.domain.usecases

import com.compose.wezacareassessment.core.util.Resource
import com.compose.wezacareassessment.harryPotter.domain.model.Characters
import com.compose.wezacareassessment.harryPotter.domain.repository.CharactersRepository
import kotlinx.coroutines.flow.Flow

class GetAllCharacters(
    private val repository: CharactersRepository

) {
    operator fun  invoke(
        query: String
    ): Flow<Resource<List<Characters>>> {


        return  repository.getAllCharacters(query)
    }

}
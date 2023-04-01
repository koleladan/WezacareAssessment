package com.compose.wezacareassessment.harryPotter.domain.usecases

import com.compose.wezacareassessment.core.util.Resource
import com.compose.wezacareassessment.harryPotter.domain.model.Characters
import com.compose.wezacareassessment.harryPotter.domain.repository.CharactersRepository
import kotlinx.coroutines.flow.Flow

class GetCharacterInfo(
    private val repository: CharactersRepository
) {
    suspend operator fun invoke(id:String): Flow<Resource<List<Characters>>>{
        return repository.getCharacterinfo(id)
    }
}
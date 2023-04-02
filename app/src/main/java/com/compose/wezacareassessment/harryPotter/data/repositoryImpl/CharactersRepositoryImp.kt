package com.compose.wezacareassessment.harryPotter.data.repositoryImpl

import com.compose.wezacareassessment.core.util.Resource
import com.compose.wezacareassessment.harryPotter.data.remote.Apiservice
import com.compose.wezacareassessment.harryPotter.data.remote.dto.CharacterInfoDto
import com.compose.wezacareassessment.harryPotter.data.remote.dto.CharactersDto
import com.compose.wezacareassessment.harryPotter.data.remote.dto.toCharacterInfo
import com.compose.wezacareassessment.harryPotter.data.remote.dto.toCharacters

import com.compose.wezacareassessment.harryPotter.domain.model.CharacterInfo
import com.compose.wezacareassessment.harryPotter.domain.model.Characters
import com.compose.wezacareassessment.harryPotter.domain.repository.CharactersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CharactersRepositoryImp @Inject constructor(
    private val apiService: Apiservice
):CharactersRepository {
    override suspend fun getCharacters(query: String): List<CharactersDto> {
        return apiService.getCharacters(query)
    }

    override suspend fun getCharacterInfo(characterId: String): CharacterInfoDto {
        return apiService.getCharacterInfo(characterId)
    }


}


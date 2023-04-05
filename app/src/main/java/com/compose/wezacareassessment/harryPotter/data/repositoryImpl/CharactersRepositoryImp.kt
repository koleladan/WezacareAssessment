package com.compose.wezacareassessment.harryPotter.data.repositoryImpl

import com.compose.wezacareassessment.harryPotter.data.remote.Apiservice
import com.compose.wezacareassessment.harryPotter.data.remote.dto.CharacterInfoDto
import com.compose.wezacareassessment.harryPotter.data.remote.dto.CharactersDto
import com.compose.wezacareassessment.harryPotter.domain.repository.CharactersRepository
import javax.inject.Inject

class CharactersRepositoryImp @Inject constructor(
    private val apiService: Apiservice
):CharactersRepository {
    override suspend fun getCharacters(): List<CharactersDto> {
        return apiService.getCharacters()
    }

    override suspend fun getCharacterInfo(characterId: String): CharacterInfoDto {
        return apiService.getCharacterInfo(characterId)
    }


}


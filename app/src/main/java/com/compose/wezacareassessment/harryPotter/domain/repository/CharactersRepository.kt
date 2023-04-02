package com.compose.wezacareassessment.harryPotter.domain.repository


import com.compose.wezacareassessment.harryPotter.data.remote.dto.CharacterInfoDto
import com.compose.wezacareassessment.harryPotter.data.remote.dto.CharactersDto


interface CharactersRepository {
    suspend fun getCharacters(query: String): List<CharactersDto>

    suspend fun getCharacterInfo(characterId:String): CharacterInfoDto
}
package com.compose.wezacareassessment.harryPotter.data.remote

import com.compose.wezacareassessment.harryPotter.data.remote.dto.CharacterInfoDto
import com.compose.wezacareassessment.harryPotter.data.remote.dto.CharactersDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Apiservice {
    @GET("characters")
    suspend fun getCharacters(): List<CharactersDto>

    @GET("characters/{id}")
    suspend fun getCharacterInfo(@Path("id") id: String): CharacterInfoDto

    companion object {
        const val BASE_URL = "https://hp-api.onrender.com/api/"
        const val CHAR_ID = "characterId"
    }


}

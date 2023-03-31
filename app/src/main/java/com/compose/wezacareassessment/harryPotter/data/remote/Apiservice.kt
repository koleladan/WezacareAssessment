package com.compose.wezacareassessment.harryPotter.data.remote

import com.compose.wezacareassessment.harryPotter.data.remote.dto.CharactersDto
import retrofit2.http.GET

interface Apiservice {
    @GET("characters")
    suspend fun getCharacterList():List<CharactersDto>

    companion object {
        const val BASE_URL = "https://hp-api.onrender.com/api/"
    }


}
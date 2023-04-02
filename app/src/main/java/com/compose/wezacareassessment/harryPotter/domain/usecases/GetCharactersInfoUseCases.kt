package com.compose.wezacareassessment.harryPotter.domain.usecases

import com.compose.wezacareassessment.core.util.Resource
import com.compose.wezacareassessment.harryPotter.data.remote.dto.toCharacterInfo
import com.compose.wezacareassessment.harryPotter.domain.model.CharacterInfo
import com.compose.wezacareassessment.harryPotter.domain.repository.CharactersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCharactersInfoUseCases @Inject constructor(
private val repository: CharactersRepository
) {
    operator fun invoke(characterId:String):Flow<Resource<CharacterInfo>> = flow {
        try {
            emit(Resource.Loading())
            val character = repository.getCharacterInfo(characterId).toCharacterInfo()
            emit(Resource.Success(character))

        } catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))

        } catch (e: IOException){
            emit(Resource.Error("Couldn't reach server. Check your connection"))

        }
    }
}
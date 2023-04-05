package com.compose.wezacareassessment.harryPotter.domain.usecases

import com.compose.wezacareassessment.core.util.Resource
import com.compose.wezacareassessment.harryPotter.data.remote.dto.toCharacters
import com.compose.wezacareassessment.harryPotter.domain.model.Characters
import com.compose.wezacareassessment.harryPotter.domain.repository.CharactersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: CharactersRepository
) {
    operator fun invoke(): Flow<Resource<List<Characters>>> = flow {
        try {
            emit(Resource.Loading<List<Characters>>())
            val characters = repository.getCharacters().map { it.toCharacters() }
            emit(Resource.Success<List<Characters>>(characters))

        }catch (e: HttpException) {
            emit(Resource.Error<List<Characters>>(e.localizedMessage ?: "An unexpected error occured"))

        }catch (e: IOException) {
            emit(Resource.Error<List<Characters>>("Couldn't reach server. Check your internet connection"))

        }
    }
}
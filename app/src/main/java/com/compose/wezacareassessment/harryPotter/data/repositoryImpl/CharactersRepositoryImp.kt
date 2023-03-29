package com.compose.wezacareassessment.harryPotter.data.repositoryImpl

import com.compose.wezacareassessment.core.util.Resource
import com.compose.wezacareassessment.harryPotter.data.remote.Apiservice
import com.compose.wezacareassessment.harryPotter.domain.model.Characters
import com.compose.wezacareassessment.harryPotter.domain.repository.CharactersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException

class CharactersRepositoryImp(
    private val apiService: Apiservice
):CharactersRepository {
    override fun getAllCharacters(): Flow<Resource<Characters>> = flow {

        try {
            val remoteData = apiService.getCharacterList().toCharacters()
            emit(Resource.Success(remoteData))

        }catch (e: IOException){
            e.printStackTrace()
            emit(Resource.Error(
                message = "an error occurred"
            ))
        }catch (e:HttpException){
            e.printStackTrace()
            emit(Resource.Error(
                message = "an error occurred"
            ))
        }


    }
}
package com.compose.wezacareassessment.harryPotter.di

import com.compose.wezacareassessment.harryPotter.data.remote.Apiservice
import com.compose.wezacareassessment.harryPotter.data.repositoryImpl.CharactersRepositoryImp
import com.compose.wezacareassessment.harryPotter.domain.repository.CharactersRepository
import com.compose.wezacareassessment.harryPotter.domain.usecases.GetAllCharacters
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HarryPotterModule{

//    @Provides
//    @Singleton
//    fun providesAllCharactersUseCases(
//        repository: CharactersRepository
//    ):GetAllCharacters{
//        return GetAllCharacters(repository)
//    }

    @Provides
    @Singleton
    fun providesCharactersRepository(
        apiservice: Apiservice
    ):CharactersRepository{
        return CharactersRepositoryImp(apiservice)
    }

    @Provides
    @Singleton
    fun providesApiService(): Apiservice{
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        return  Retrofit.Builder()
            .baseUrl(Apiservice.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(Apiservice::class.java)
    }

}
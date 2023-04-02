package com.compose.wezacareassessment.harryPotter.di

import com.compose.wezacareassessment.harryPotter.data.remote.Apiservice
import com.compose.wezacareassessment.harryPotter.data.repositoryImpl.CharactersRepositoryImp
import com.compose.wezacareassessment.harryPotter.domain.repository.CharactersRepository
import com.compose.wezacareassessment.harryPotter.domain.usecases.GetCharactersInfoUseCases
import com.compose.wezacareassessment.harryPotter.domain.usecases.GetCharactersUseCase
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HarryPotterModule{

//    @Provides
//    @Singleton
//    fun providesAllCharactersUseCases(
//        repository: CharactersRepository,
//    ):GetCharactersUseCase{
//        return GetCharactersUseCase(repository)
//    }
//
//    @Provides
//    @Singleton
//    fun providesgetCharactersInfoUseCases(
//        repository: CharactersRepository
//    ):GetCharactersInfoUseCases{
//        return GetCharactersInfoUseCases(repository)
//    }

    @Provides
    @Singleton
    fun providesCharactersRepository(apiservice: Apiservice): CharactersRepository{
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
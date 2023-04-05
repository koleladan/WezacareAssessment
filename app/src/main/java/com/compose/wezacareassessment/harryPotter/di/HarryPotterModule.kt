package com.compose.wezacareassessment.harryPotter.di

import com.compose.wezacareassessment.harryPotter.data.remote.Apiservice
import com.compose.wezacareassessment.harryPotter.data.repositoryImpl.CharactersRepositoryImp
import com.compose.wezacareassessment.harryPotter.domain.repository.CharactersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HarryPotterModule {

    @Provides
    @Singleton
    fun provideCharactersRepository(apiservice: Apiservice): CharactersRepository{
        return CharactersRepositoryImp(apiservice)
    }
    @Provides
    @Singleton
    fun provideApiservice(): Apiservice {
        return  Retrofit.Builder()
            .baseUrl(Apiservice.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Apiservice::class.java)
    }




}
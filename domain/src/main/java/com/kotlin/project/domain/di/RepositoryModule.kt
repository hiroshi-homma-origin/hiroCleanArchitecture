package com.kotlin.project.domain.di

import com.kotlin.project.domain.api.PokemonApi
import com.kotlin.project.domain.repository.GetPokemonListRepository
import com.kotlin.project.domain.repository.GetPokemonListRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
internal class RepositoryModule {
    @Provides
    fun provideGetPokemonListRepository(
        pokemonApi: PokemonApi
    ): GetPokemonListRepository {
        return GetPokemonListRepositoryImpl(pokemonApi)
    }
}
package com.kotlin.project.domain.di

import com.kotlin.project.domain.di.qualifier.PokemonListUseCase
import com.kotlin.project.domain.repository.GetPokemonListRepository
import com.kotlin.project.domain.usecase.GetPokemonListUseCase
import com.kotlin.project.domain.usecase.GetPokemonListUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ActivityComponent::class)
class UseCaseModule {
    @PokemonListUseCase
    @Provides
    fun provideGetPokemonUSeCase(
        getPokemonListRepository: GetPokemonListRepository
    ): GetPokemonListUseCase {
        return GetPokemonListUseCaseImpl(getPokemonListRepository)
    }
}
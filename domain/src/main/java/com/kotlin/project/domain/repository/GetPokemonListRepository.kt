package com.kotlin.project.domain.repository

import com.kotlin.project.data.models.response.PokemonListResponse
import com.kotlin.project.domain.api.PokemonApi
import javax.inject.Inject

interface GetPokemonListRepository {
    suspend fun getPokemonList(): PokemonListResponse?
}

internal class GetPokemonListRepositoryImpl @Inject constructor(
    private val pokemonApi: PokemonApi
) : GetPokemonListRepository {
    override suspend fun getPokemonList(): PokemonListResponse? {
        return pokemonApi.getPokemonList()
    }
}
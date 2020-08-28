package com.kotlin.project.domain.repository

import com.kotlin.project.data.model.response.PokeList
import com.kotlin.project.domain.api.PokemonApi
import javax.inject.Inject

interface GetPokemonListRepository {
    suspend fun getPokemonList(jsonName: String): List<PokeList>
}

internal class GetPokemonListRepositoryImpl @Inject constructor(
    private val pokemonApi: PokemonApi
) : GetPokemonListRepository {
    override suspend fun getPokemonList(jsonName: String): List<PokeList> {
        return pokemonApi.getPokemonList(jsonName)
    }
}
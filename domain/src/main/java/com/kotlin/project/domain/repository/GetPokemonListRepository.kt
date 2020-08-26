package com.kotlin.project.domain.repository

import com.kotlin.project.data.models.original.response.PokeListResponse
import com.kotlin.project.domain.api.PokemonApi
import javax.inject.Inject

interface GetPokemonListRepository {
    suspend fun getPokemonList(): List<PokeListResponse>
}

internal class GetPokemonListRepositoryImpl @Inject constructor(
    private val pokemonApi: PokemonApi
) : GetPokemonListRepository {
    override suspend fun getPokemonList(): List<PokeListResponse> {
        return pokemonApi.getPokemonList1()
    }
}
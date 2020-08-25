package com.kotlin.project.domain.usecase

import com.kotlin.project.data.models.response.PokemonListResponse
import com.kotlin.project.domain.repository.GetPokemonListRepository
import javax.inject.Inject

interface GetPokemonListUseCase {
    suspend fun getList(): PokemonListResponse?
}

class GetPokemonListUseCaseImpl @Inject constructor(
    private val getPokemonListRepository: GetPokemonListRepository
) : GetPokemonListUseCase {
    override suspend fun getList(): PokemonListResponse? {
        runCatching {
            getPokemonListRepository.getPokemonList()
        }.fold(
            onSuccess = {
                return it
            },
            onFailure = {
                return null
            }
        )
    }

}
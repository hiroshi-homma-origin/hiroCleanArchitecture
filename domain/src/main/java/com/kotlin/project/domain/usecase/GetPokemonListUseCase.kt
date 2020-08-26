package com.kotlin.project.domain.usecase

import com.kotlin.project.data.models.original.response.PokeListResponse
import com.kotlin.project.domain.repository.GetPokemonListRepository
import timber.log.Timber
import javax.inject.Inject

interface GetPokemonListUseCase {
    suspend fun getList(): List<PokeListResponse>
}

class GetPokemonListUseCaseImpl @Inject constructor(
    private val getPokemonListRepository: GetPokemonListRepository
) : GetPokemonListUseCase {
    override suspend fun getList(): List<PokeListResponse> {
        runCatching {
            getPokemonListRepository.getPokemonList()
        }.fold(
            onSuccess = {
                Timber.d("check_results_onSuccess:${it[0].base}")
                return it
            },
            onFailure = {
                Timber.d("check_results_onFailure:${it}")
                return listOf()
            }
        )
    }

}
package com.kotlin.project.domain.usecase

import androidx.lifecycle.MutableLiveData
import com.kotlin.project.data.model.response.PokeList
import com.kotlin.project.domain.repository.GetPokemonListRepository
import javax.inject.Inject

interface GetPokemonListUseCase {
    suspend fun getList(jsonName: String)
    fun getLiveData(): MutableLiveData<List<PokeList>>
}

class GetPokemonListUseCaseImpl @Inject constructor(
    private val getPokemonListRepository: GetPokemonListRepository
) : GetPokemonListUseCase {

    private val pokeLiveData: MutableLiveData<List<PokeList>> = MutableLiveData()

    override suspend fun getList(jsonName: String) {
        runCatching {
            getPokemonListRepository.getPokemonList(jsonName)
        }.fold(
            onSuccess = {
                pokeLiveData.postValue(it)
            },
            onFailure = {
                pokeLiveData.postValue(emptySequence<PokeList>().toList())
            }
        )
    }

    override fun getLiveData() = pokeLiveData
}

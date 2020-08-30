package com.kotlin.cleanarchitecture.presentation.root

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotlin.cleanarchitecture.state.PokeState.number
import com.kotlin.cleanarchitecture.state.PokeState.pokeListLiveData
import com.kotlin.project.domain.di.qualifier.PokemonListUseCase
import com.kotlin.project.domain.usecase.GetPokemonListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RootViewModel @ViewModelInject constructor(
    @PokemonListUseCase private val useCase: GetPokemonListUseCase
) : ViewModel() {
    fun prevData() {
        val n = number.value?.minus(1)
        number.postValue(n)
        viewModelScope.launch(Dispatchers.Default) {
            pokeListLiveData.postValue(useCase.getList("pokedex$n.json"))
        }
    }
    fun nextData() {
        val n = number.value?.plus(1)
        number.postValue(n)
        viewModelScope.launch(Dispatchers.Default) {
            pokeListLiveData.postValue(useCase.getList("pokedex$n.json"))
        }
    }
}

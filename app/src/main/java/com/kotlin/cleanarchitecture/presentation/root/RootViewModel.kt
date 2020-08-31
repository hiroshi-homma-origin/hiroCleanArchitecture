package com.kotlin.cleanarchitecture.presentation.root

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotlin.cleanarchitecture.state.PokeDelegate.maxJsonNumber
import com.kotlin.cleanarchitecture.state.PokeDelegate.number
import com.kotlin.cleanarchitecture.state.PokeDelegate.pokeListLiveData
import com.kotlin.project.domain.di.qualifier.PokemonListUseCase
import com.kotlin.project.domain.usecase.GetPokemonListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RootViewModel @ViewModelInject constructor(
    @PokemonListUseCase private val useCase: GetPokemonListUseCase
) : ViewModel() {
    var n = 0

    fun prevData() {
        n = if (n == 0) {
            maxJsonNumber
        } else { number.value?.minus(1)!! }
        number.postValue(n)
        viewModelScope.launch(Dispatchers.Default) {
            pokeListLiveData.postValue(useCase.getList("pokedex$n.json"))
        }
    }

    fun nextData() {
        n = if (n > maxJsonNumber - 1) {
            0
        } else { number.value?.plus(1)!! }
        number.postValue(n)
        viewModelScope.launch(Dispatchers.Default) {
            pokeListLiveData.postValue(useCase.getList("pokedex$n.json"))
        }
    }
}

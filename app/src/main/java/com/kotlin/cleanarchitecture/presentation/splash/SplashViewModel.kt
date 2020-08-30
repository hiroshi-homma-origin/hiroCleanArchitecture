package com.kotlin.cleanarchitecture.presentation.splash

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotlin.cleanarchitecture.state.PokeState.InitialNumber
import com.kotlin.cleanarchitecture.state.PokeState.isFloatingActionButton
import com.kotlin.cleanarchitecture.state.PokeState.number
import com.kotlin.cleanarchitecture.state.PokeState.pokeListLiveData
import com.kotlin.project.domain.di.qualifier.PokemonListUseCase
import com.kotlin.project.domain.usecase.GetPokemonListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SplashViewModel @ViewModelInject constructor(
    @PokemonListUseCase private val useCase: GetPokemonListUseCase
) : ViewModel() {
    fun fetchData() {
        isFloatingActionButton.postValue(true)
        number.postValue(0)
        viewModelScope.launch(Dispatchers.Default) {
            pokeListLiveData.postValue(useCase.getList("pokedex0.json"))
        }
    }
}

package com.kotlin.cleanarchitecture.presentation.splash

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotlin.cleanarchitecture.state.PokeState.number
import com.kotlin.cleanarchitecture.state.PokeState.pokeListLiveData
import com.kotlin.project.domain.di.qualifier.PokemonListUseCase
import com.kotlin.project.domain.usecase.GetPokemonListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class SplashViewModel @ViewModelInject constructor(
    @PokemonListUseCase private val useCase: GetPokemonListUseCase
) : ViewModel() {
    fun fetchData() {
        number = 44
        viewModelScope.launch(Dispatchers.Default) {
            Timber.d("check_data:${number}")
            pokeListLiveData.postValue(useCase.getList("pokedex${number}.json"))
        }
    }
}

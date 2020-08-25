package com.kotlin.cleanarchitecture.presentation.root

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotlin.project.data.models.Pokemon
import com.kotlin.project.domain.di.qualifier.PokemonListUseCase
import com.kotlin.project.domain.usecase.GetPokemonListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RootViewModel @ViewModelInject constructor(
    @PokemonListUseCase private val useCase: GetPokemonListUseCase
) : ViewModel() {

    val liveData: MutableLiveData<List<Pokemon>?> = MutableLiveData()

    fun fetchData() {
        viewModelScope.launch(Dispatchers.Default) {
            liveData.postValue(useCase.getList()?.results)
        }
    }
}

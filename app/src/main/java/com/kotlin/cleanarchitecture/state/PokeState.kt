package com.kotlin.cleanarchitecture.state

import androidx.lifecycle.MutableLiveData
import com.kotlin.cleanarchitecture.presentation.root.RootViewModel
import com.kotlin.project.data.model.response.PokeList

object PokeState {
    // LiveData
    val pokeListLiveData: MutableLiveData<List<PokeList>> = MutableLiveData()
    val isFloatingActionButton: MutableLiveData<Boolean> = MutableLiveData()

    // ViewModel
    lateinit var rootViewModel: RootViewModel

    // Variable
    var number: Int = 0
}

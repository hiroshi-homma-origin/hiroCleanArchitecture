package com.kotlin.cleanarchitecture.state

import androidx.lifecycle.MutableLiveData
import com.kotlin.cleanarchitecture.presentation.root.RootViewModel
import com.kotlin.project.data.model.response.PokeList

object PokeState {
    val pokeListLiveData: MutableLiveData<List<PokeList>> = MutableLiveData()
    lateinit var rootViewModel: RootViewModel
    var number: Int = 0
}

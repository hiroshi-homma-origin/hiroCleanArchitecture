package com.kotlin.cleanarchitecture.state

import androidx.lifecycle.MutableLiveData
import com.kotlin.project.data.model.response.PokeList

object PokeState {
    val pokeListLiveData: MutableLiveData<List<PokeList>> = MutableLiveData()
    var number: Int = 0
}

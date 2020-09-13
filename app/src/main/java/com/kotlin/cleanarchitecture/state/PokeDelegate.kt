package com.kotlin.cleanarchitecture.state

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kotlin.cleanarchitecture.presentation.root.RootViewModel
import com.kotlin.cleanarchitecture.presentation.splash.SplashViewModel
import com.kotlin.project.data.model.response.PokeList

object PokeDelegate {
    // LiveData
    var pokeListInitLiveData: LiveData<List<PokeList>> = MutableLiveData()
    val isFloatingActionButton: MutableLiveData<Boolean> = MutableLiveData()
    var number: MutableLiveData<Int> = MutableLiveData()
    var screenNumber: MutableLiveData<Int> = MutableLiveData()

    // ViewModel
    lateinit var splashViewModel: SplashViewModel
    lateinit var rootViewModel: RootViewModel

    // Variable
    const val maxJsonNumber = 44
}

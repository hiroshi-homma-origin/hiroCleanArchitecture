package com.kotlin.cleanarchitecture.presentation.root

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import com.kotlin.cleanarchitecture.ext.nonNullObserve
import com.kotlin.cleanarchitecture.state.PokeState.pokeListLiveData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RootActivity : AppCompatActivity() {

    private val rootViewModel: RootViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observe()
    }

    private fun observe() {
        rootViewModel.run {
            pokeListLiveData.nonNullObserve {
                setContent {
                    RootScreen(this)
                }
            }
        }
    }
}

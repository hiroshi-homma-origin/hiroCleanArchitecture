package com.kotlin.cleanarchitecture.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import com.kotlin.cleanarchitecture.ext.nonNullObserve
import com.kotlin.cleanarchitecture.presentation.root.RootViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class RootActivity : AppCompatActivity() {

    private val rootViewModel: RootViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rootViewModel.fetchData()
        observe()
    }

    private fun observe() {
        rootViewModel.run {
            liveData.nonNullObserve {
                Timber.d("check_splash_data:$it")
                setContent {
                    PokemonList()
                }
            }
        }
    }

    @Composable
    fun PokemonList() {
        ScrollableColumn {
            rootViewModel.liveData.value?.map {
                Text("${it.name}")
            }
        }
    }
}

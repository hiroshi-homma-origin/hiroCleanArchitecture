package com.kotlin.cleanarchitecture.presentation.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.setContent
import com.kotlin.cleanarchitecture.presentation.root.RootActivity
import com.kotlin.cleanarchitecture.state.PokeState.pokeListLiveData
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private val splashViewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashViewModel.fetchData()
        setContent {
            ObservePokeList()
        }
    }

    @Composable
    fun ObservePokeList() {
        val list by pokeListLiveData.observeAsState()
        list?.let {
            val intent = Intent(this, RootActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

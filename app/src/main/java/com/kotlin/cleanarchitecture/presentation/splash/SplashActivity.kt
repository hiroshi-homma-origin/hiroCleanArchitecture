package com.kotlin.cleanarchitecture.presentation.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import com.kotlin.cleanarchitecture.ext.nonNullObserve
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
        observe()
        setContent {
            SplashScreen()
        }
    }

    private fun observe() {
        pokeListLiveData.nonNullObserve {
            val intent = Intent(this, RootActivity::class.java)
            Timber.d("Start_Root_Activity")
            startActivity(intent)
            finish()
        }
    }
}

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
import com.kotlin.cleanarchitecture.state.PokeDelegate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private val splashViewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        PokeDelegate.splashViewModel = splashViewModel
        setContent {
            ObservePokeList()
        }
    }

    @Composable
    fun ObservePokeList() {
        val list by splashViewModel.getLiveData().observeAsState()
        list?.let {
            val intent = Intent(this, RootActivity::class.java)
            startActivity(intent)
            finish()
        } ?: run {
            splashViewModel.fetchData()
        }
    }
}

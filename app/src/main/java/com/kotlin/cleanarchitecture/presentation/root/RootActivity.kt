package com.kotlin.cleanarchitecture.presentation.root

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.cleanarchitecture.state.PokeDelegate
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RootActivity : AppCompatActivity() {

    private val rootViewModel: RootViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        PokeDelegate.rootViewModel = rootViewModel
        setContent { RootScreen() }
    }
}

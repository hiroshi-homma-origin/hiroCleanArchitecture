package com.kotlin.cleanarchitecture.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.setContent
import com.kotlin.cleanarchitecture.ext.nonNullObserve
import com.kotlin.cleanarchitecture.presentation.common.BottomNavigationScreen
import com.kotlin.cleanarchitecture.presentation.common.DrawerContentsScreen
import com.kotlin.cleanarchitecture.presentation.common.FloatingActionButtonScreen
import com.kotlin.cleanarchitecture.presentation.common.TopAppBarScreen
import com.kotlin.cleanarchitecture.presentation.home.HomeScreen
import com.kotlin.cleanarchitecture.presentation.root.RootViewModel
import dagger.hilt.android.AndroidEntryPoint

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
                setContent {
                    RootScreen()
                }
            }
        }
    }

    @Composable
    fun RootScreen() {
        val scaffoldState = rememberScaffoldState()
        val bottomIndex = remember { mutableStateOf(0) }
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = { TopAppBarScreen(showBack = false, scaffoldState) },
            floatingActionButtonPosition = FabPosition.End,
            floatingActionButton = { FloatingActionButtonScreen(scaffoldState) },
            drawerContent = { DrawerContentsScreen(scaffoldState) },
            bodyContent = { HomeScreen(rootViewModel) },
            bottomBar = { BottomNavigationScreen(scaffoldState, bottomIndex) }
        )
    }
}

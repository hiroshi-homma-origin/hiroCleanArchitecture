package com.kotlin.cleanarchitecture.presentation.root

import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.kotlin.cleanarchitecture.presentation.common.BottomNavigationScreen
import com.kotlin.cleanarchitecture.presentation.common.DrawerContentsScreen
import com.kotlin.cleanarchitecture.presentation.common.FloatingActionButtonScreen
import com.kotlin.cleanarchitecture.presentation.common.TopAppBarScreen
import com.kotlin.cleanarchitecture.presentation.home.HomeScreen

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
        bodyContent = { HomeScreen() },
        bottomBar = { BottomNavigationScreen(scaffoldState, bottomIndex) }
    )
}

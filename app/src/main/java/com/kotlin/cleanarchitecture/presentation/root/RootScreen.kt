package com.kotlin.cleanarchitecture.presentation.root

import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.kotlin.cleanarchitecture.presentation.battle.BattleScreen
import com.kotlin.cleanarchitecture.presentation.common.BottomNavigationScreen
import com.kotlin.cleanarchitecture.presentation.common.DrawerContentsScreen
import com.kotlin.cleanarchitecture.presentation.common.FloatingActionButtonScreen
import com.kotlin.cleanarchitecture.presentation.common.TopAppBarScreen
import com.kotlin.cleanarchitecture.presentation.home.HomeScreen
import com.kotlin.cleanarchitecture.presentation.mypage.MyPageScreen
import com.kotlin.cleanarchitecture.presentation.ranking.RankingScreen
import com.kotlin.cleanarchitecture.presentation.search.SearchScreen
import com.kotlin.cleanarchitecture.state.PokeDelegate.isFloatingActionButton
import com.kotlin.cleanarchitecture.state.PokeDelegate.screenNumber

@Composable
fun RootScreen() {
    val scaffoldState = rememberScaffoldState()
    val isFAB by isFloatingActionButton.observeAsState()
    val screenNumber by screenNumber.observeAsState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopAppBarScreen(showBack = false, scaffoldState) },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            if (isFAB!! && screenNumber == 0) FloatingActionButtonScreen()
        },
        drawerContent = { DrawerContentsScreen(scaffoldState) },
        content = {
            when (screenNumber) {
                1 -> RankingScreen()
                2 -> BattleScreen()
                3 -> SearchScreen()
                4 -> MyPageScreen()
                else -> HomeScreen()
            }
        },
        bottomBar = { BottomNavigationScreen() }
    )
}

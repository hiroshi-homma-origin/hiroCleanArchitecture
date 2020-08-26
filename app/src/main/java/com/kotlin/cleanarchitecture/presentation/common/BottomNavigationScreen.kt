package com.kotlin.cleanarchitecture.presentation.common

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kotlin.project.data.models.original.AppScreen

@Composable
fun BottomNavigationScreen(scaffoldState: ScaffoldState, bottomIndex: MutableState<Int>) {
    BottomNavigation(modifier = Modifier.padding(0.dp)) {
        AppScreen.values().mapIndexed { index, list ->
            if (index < 5) {
                BottomNavigationItem(
                    icon = {
                        Column(
                            horizontalGravity = Alignment.CenterHorizontally
                        ) {
                            Icon(asset = Icons.Filled.Home)
                            if (bottomIndex.value == index) {
                                Text(
                                    text = list.displayNameString,
                                    style = TextStyle(
                                        fontFamily = FontFamily.Monospace,
                                        fontSize = 8.sp
                                    )
                                )
                            }
                        }
                    },
                    selected = bottomIndex.value == index,
                    onSelect = {
                        bottomIndex.value = index
                    },
                    alwaysShowLabels = false
                )
            }
        }
    }
}

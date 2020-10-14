package com.kotlin.cleanarchitecture.presentation.common

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.fastForEachIndexed
import com.kotlin.cleanarchitecture.state.PokeDelegate.screenNumber
import com.kotlin.project.data.model.AppScreen
import com.kotlin.project.data.model.appScreenList

@Composable
fun BottomNavigationScreen() {
    val sNumber by screenNumber.observeAsState()
    BottomNavigation(modifier = Modifier.padding(0.dp)) {
        appScreenList.fastForEachIndexed { index, list ->
            if (index < 5) {
                BottomNavigationItem(
                    icon = {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(asset = Icons.Filled.Home)
                            if (sNumber == index) {
                                Text(
                                    text = list[index].displayNameString,
                                    style = TextStyle(
                                        fontFamily = FontFamily.Monospace,
                                        fontSize = 8.sp
                                    )
                                )
                            }
                        }
                    },
                    selected = sNumber == index,
                    onClick = {
                        screenNumber.value = index
                    },
                    alwaysShowLabels = false
                )
            }
        }
    }
}

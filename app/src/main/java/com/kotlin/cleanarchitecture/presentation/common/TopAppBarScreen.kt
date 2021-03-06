package com.kotlin.cleanarchitecture.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kotlin.cleanarchitecture.R
import com.kotlin.cleanarchitecture.state.PokeDelegate.number

@Composable
fun TopAppBarScreen(
    showBack: Boolean,
    scaffoldState: ScaffoldState
) {
    val n by number.observeAsState()
    val navigationIcon =
        if (showBack) Icons.Default.ArrowBack else Icons.Default.Menu
    TopAppBar(
        navigationIcon = {
            IconButton(
                onClick = {
                    scaffoldState.drawerState.isOpen
                }
            ) {
                Icon(
                    imageVector = navigationIcon,
                    contentDescription = null
                )
            }
        },
        title = {
            Row {
                Image(
                    painter = painterResource(R.drawable.pokedex_logo),
                    contentDescription = null,
                    modifier = Modifier.width(200.dp)
                )
                Text(
                    modifier = Modifier.padding(10.dp),
                    text = n.toString(),
                    color = Color(0xBBFFFFFF)
                )
            }
        }
    )
}

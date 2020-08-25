package com.kotlin.cleanarchitecture.presentation.common

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.ColumnScope.gravity
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DrawerContentsScreen(scaffoldState: ScaffoldState) {
    Button(
        modifier = Modifier.gravity(Alignment.CenterHorizontally)
            .padding(top = 16.dp),
        onClick = { scaffoldState.drawerState.close() },
        content = { Text("Close Drawer") }
    )
}

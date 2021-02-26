package com.kotlin.cleanarchitecture.presentation.battle

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kotlin.cleanarchitecture.R

@Composable
fun BattleScreen() {
    // Background
    Image(
        painter = painterResource(R.drawable.bg1),
        contentDescription = "search",
        modifier = Modifier.fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xFF363636))
    )
    // Contents
    Surface(
        modifier = Modifier.padding(12.dp)
            .fillMaxWidth()
            .height(360.dp)
            .clickable(
                onClick = {
                    // Todo()
                }
            ),
        shape = RoundedCornerShape(2.dp),
        color = Color(0xBBFFFFFF)
    ) {
        Text("test text")
    }
}

package com.kotlin.cleanarchitecture.presentation.battle

import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import com.kotlin.cleanarchitecture.R

@Composable
fun BattleScreen() {
    // Background
    Image(
        imageResource(id = R.drawable.bg1),
        modifier = Modifier.fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xFF363636))
    )
    // Contents
    Surface(
        modifier = Modifier.padding(12.dp)
            .fillMaxWidth()
            .preferredHeight(360.dp)
            .clickable(
                onClick = {
                    // Todo()
                }
            ),
        shape = RoundedCornerShape(2.dp),
        color = Color(0xBBFFFFFF)
    ) {
        Text(text = "test text")
    }
}

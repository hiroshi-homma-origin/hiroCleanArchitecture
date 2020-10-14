package com.kotlin.cleanarchitecture.presentation.ranking

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.onPositioned
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import com.kotlin.cleanarchitecture.R

@Composable
fun RankingScreen() {
    // Background
    Image(
        imageResource(id = R.drawable.bg1),
        modifier = Modifier.fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xFF363636))
    )
    // Contents
    ScrollableColumn(
        modifier = Modifier.padding(bottom = 60.dp)
            .onPositioned {}
    ) {
        (0..10).forEach { i ->
            Card(
                modifier = Modifier.padding(12.dp)
                    .fillMaxWidth()
                    .preferredHeight(90.dp)
                    .clickable(
                        onClick = {
                            // Todo()
                        }
                    ),
                shape = RoundedCornerShape(2.dp),
                backgroundColor = Color(0xBBFFFFFF)
            ) {
                Text(text = "test text $i")
            }
        }
    }
}

package com.kotlin.cleanarchitecture.presentation.ranking

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kotlin.cleanarchitecture.R

@Composable
fun RankingScreen() {
    // Background
    Image(
        painterResource(id = R.drawable.bg1),
        contentDescription = null,
        modifier = Modifier.fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xFF363636))
    )
    // Contents
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
            .padding(bottom = 60.dp)
    ) {
        (0..10).forEach { i ->
            Card(
                modifier = Modifier.padding(12.dp)
                    .fillMaxWidth()
                    .height(90.dp)
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

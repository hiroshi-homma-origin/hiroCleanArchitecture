package com.kotlin.cleanarchitecture.presentation.mypage

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kotlin.cleanarchitecture.R
import timber.log.Timber

@Composable
fun MyPageScreen() {
    // Background
    Image(
        painter = painterResource(R.drawable.bg1),
        contentDescription = null,
        modifier = Modifier.fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xFF363636))
    )
    Column {
        AnimationMethod()
    }
}

@Composable
fun AnimationMethod() {
    var count = 0
    val visible = mutableStateOf(false)
    val selectNum = mutableStateOf(0)
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
            .padding(bottom = 60.dp)
    ) {
        (0..9).forEach { num ->
            Card(
                modifier = Modifier.padding(12.dp)
                    .fillMaxWidth()
                    .height(300.dp)
                    .clickable(
                        onClick = {
//                            visible = num != selectNum
                            selectNum.value = num
                            Timber.d("check_data1:$selectNum")
                            Timber.d("check_data2:$visible")
                            if (!visible.value && selectNum.value == num) {
                                visible.value = true
                                count++
                            }
                            Timber.d("check_data3:$count")
                            if (count == 2) {
                                visible.value = false
                                count = 0
                            }
                            Timber.d("check_data4:$count")
                        }
                    ),
                shape = RoundedCornerShape(2.dp),
                backgroundColor = Color(0xBBFFFFFF)
            ) {
                Column(
                    horizontalAlignment = Alignment.Start
                ) {
                    Canvas(
                        modifier = Modifier.padding(20.dp)
                            .size(300.dp)
                    ) {
                        drawCircle(Color.Gray)
                    }
                }
            }
        }
    }
}

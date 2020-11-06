package com.kotlin.cleanarchitecture.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.globalPosition
import androidx.compose.ui.onGloballyPositioned
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEachIndexed
import androidx.compose.ui.util.format
import com.kotlin.cleanarchitecture.R
import com.kotlin.cleanarchitecture.presentation.common.GlideImage
import com.kotlin.cleanarchitecture.state.PokeDelegate.isFloatingActionButton
import com.kotlin.cleanarchitecture.state.PokeDelegate.number
import com.kotlin.cleanarchitecture.state.PokeDelegate.pokeListInitLiveData
import com.kotlin.cleanarchitecture.state.PokeDelegate.rootViewModel
import com.kotlin.project.data.model.response.PokeList

@Composable
fun HomeScreen() {
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
            .onGloballyPositioned {
                if (it.globalPosition.y < 220.0f) {
                    isFloatingActionButton.postValue(false)
                } else {
                    isFloatingActionButton.postValue(true)
                }
            }
    ) {
        val pokeList = rootViewModel.getLiveData().observeAsState().value ?: pokeListInitLiveData.value
        pokeList?.fastForEachIndexed { index, pokemon ->
            val number = "%03d".format(index.plus((number.value!! * 20) + 1))
            Card(
                modifier = Modifier.padding(12.dp)
                    .fillMaxWidth()
                    .preferredHeight(100.dp)
                    .clickable(
                        onClick = {
                            // Todo()
                        }
                    ),
                shape = RoundedCornerShape(2.dp),
                backgroundColor = Color(0xBBFFFFFF)
            ) {
                ImageAndContentDivideScreen(number, pokemon)
            }
        }
    }
}

@Composable
fun ImageAndContentDivideScreen(number: String, pokemon: PokeList) {
    Row(
        modifier = Modifier.padding(8.dp)
    ) {
        GlideImage("http://tk2-246-32569.vs.sakura.ne.jp/images/$number.png")
        Column(
            modifier = Modifier.padding(6.dp)
        ) {
            NumberAndNameScreen(number, pokemon)
            StatusScreen(pokemon)
        }
    }
}

@Composable
fun NumberAndNameScreen(number: String, pokemon: PokeList) {
    Row(
        modifier = Modifier.padding(bottom = 4.dp)
    ) {
        Text("$number : ${pokemon.name.japanese}")
    }
}

@Composable
fun StatusScreen(pokemon: PokeList) {
    Row(
        modifier = Modifier.padding(bottom = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(end = 8.dp)
        ) {
            Text("HP:${pokemon.base.hp}")
            Text("Speed:${pokemon.base.speed}")
        }
        Column(
            modifier = Modifier.padding(end = 8.dp)
        ) {
            Text("Attack:${pokemon.base.attack}")
            Text("Defense:${pokemon.base.defense}")
        }
        Column(
            modifier = Modifier.padding(end = 8.dp)
        ) {
            Text("Sp. Attack:${pokemon.base.spAttack}")
            Text("Sp. Defense:${pokemon.base.spDefense}")
        }
    }
}

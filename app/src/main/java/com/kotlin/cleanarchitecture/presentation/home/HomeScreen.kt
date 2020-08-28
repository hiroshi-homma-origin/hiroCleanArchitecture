package com.kotlin.cleanarchitecture.presentation.home

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kotlin.cleanarchitecture.presentation.common.GlideImage
import com.kotlin.cleanarchitecture.state.PokeState.pokeListLiveData
import com.kotlin.project.data.model.response.PokeList
import timber.log.Timber

@Composable
fun HomeScreen() {
    ScrollableColumn(
        modifier = Modifier.padding(bottom = 60.dp)
    ) {
        pokeListLiveData.value?.mapIndexed { index, pokemon ->
            val number = index.plus(1).toString().padStart(3, '0')
            Card(
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier.padding(4.dp) +
                    Modifier.fillMaxWidth() +
                    Modifier.preferredHeight(100.dp) +
                    Modifier.clickable(
                        onClick = {
                            Timber.d("check_click:$index")
                        }
                    )
            ) {
                ImageAndContentDivideScreen(number, pokemon)
            }
        }
    }
}

@Composable
fun ImageAndContentDivideScreen(number: String, pokemon: PokeList) {
    Row {
        GlideImage(model = "http://tk2-246-32569.vs.sakura.ne.jp/images/$number.png")
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            NumberAndNameScreen(number, pokemon)
            StatusScreen(pokemon)
        }
    }
}

@Composable
fun NumberAndNameScreen(number: String, pokemon: PokeList) {
    Row(
        modifier = Modifier.padding(bottom = 8.dp)
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
            Text("Attack:${pokemon.base.attack}")
        }
        Column(
            modifier = Modifier.padding(end = 8.dp)
        ) {
            Text("Defense:${pokemon.base.defense}")
            Text("Speed:${pokemon.base.speed}")
        }
        Column(
            modifier = Modifier.padding(end = 8.dp)
        ) {
            Text("Sp. Attack:${pokemon.base.spAttack}")
            Text("Sp. Defense:${pokemon.base.spDefense}")
        }
    }
}

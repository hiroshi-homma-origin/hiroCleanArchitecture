package com.kotlin.cleanarchitecture.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEachIndexed
import com.kotlin.cleanarchitecture.R
import com.kotlin.cleanarchitecture.state.PokeDelegate.number
import com.kotlin.cleanarchitecture.state.PokeDelegate.pokeListInitLiveData
import com.kotlin.cleanarchitecture.state.PokeDelegate.rootViewModel
import com.kotlin.project.data.model.response.PokeList
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun HomeScreen() {
    // Background
    Image(
        painter = painterResource(R.drawable.bg1),
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
        val pokeList = rootViewModel.getLiveData().observeAsState().value ?: pokeListInitLiveData.value
        pokeList?.fastForEachIndexed { index, pokemon ->
            val number = "%03d".format(index.plus((number.value!! * 20) + 1))
            Card(
                modifier = Modifier.padding(12.dp)
                    .fillMaxWidth()
                    .height(100.dp)
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
        CoilImage(
            data = "http://tk2-246-32569.vs.sakura.ne.jp/images/$number.png",
            contentDescription = null
        )
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

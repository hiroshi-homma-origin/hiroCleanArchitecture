package com.kotlin.project.data.model.response

import com.kotlin.project.data.model.Base
import com.kotlin.project.data.model.Name

data class PokeList(
    var id: Int = 0,
    var name: Name,
    var type: List<String> = listOf(),
    var base: Base
)
package com.kotlin.project.data.models.original.response

import com.kotlin.project.data.models.original.Base
import com.kotlin.project.data.models.original.Name

data class PokeListResponse(
    var id: Int = 0,
    var name: Name,
    var type: List<String> = listOf(),
    var base: Base
)
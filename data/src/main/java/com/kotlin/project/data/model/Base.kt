package com.kotlin.project.data.model

import com.squareup.moshi.Json

class Base (
    @Json(name = "hp") var hp: Int = 0,
    @Json(name = "attack") var attack: Int = 0,
    @Json(name = "defense") var defense: Int = 0,
    @Json(name = "sp. attack") var spAttack: Int = 0,
    @Json(name = "sp. defense") var spDefense: Int = 0,
    @Json(name = "speed") var speed: Int = 0
)
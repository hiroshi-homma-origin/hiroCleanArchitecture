package com.kotlin.project.data.models.original

import com.squareup.moshi.Json

class Base (
    @Json(name = "HP") var hp: Int = 0,
    @Json(name = "Attack") var attack: Int = 0,
    @Json(name = "Defense") var defense: Int = 0,
    @Json(name = "Sp. Attack") var spAttack: Int = 0,
    @Json(name = "Sp. Defense") var spDefense: Int = 0,
    @Json(name = "Speed") var speed: Int = 0
)
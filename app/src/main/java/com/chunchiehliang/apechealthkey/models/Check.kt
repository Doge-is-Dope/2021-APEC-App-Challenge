package com.chunchiehliang.apechealthkey.models

import java.util.*

data class Check(
    val id: Int,
    val status: Boolean,
    val title: String,
    val lastUpdated: Date
)

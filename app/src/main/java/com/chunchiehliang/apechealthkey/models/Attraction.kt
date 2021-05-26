package com.chunchiehliang.apechealthkey.models

data class Attraction(
    val id: Int,
    val title: String,
    val lat: Double,
    val lng: Double,
    val isOpen: Boolean,
    val distance: Int,
    val density: String,
    val imgId: Int
)

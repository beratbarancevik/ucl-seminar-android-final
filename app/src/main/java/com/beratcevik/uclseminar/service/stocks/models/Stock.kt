package com.beratcevik.uclseminar.service.stocks.models

data class Stock(
    val id: String = "",
    val title: String = "",
    val symbol: String = "",
    val price: Double = 0.0,
    val logoUrl: String = "",
    val isFavorite: Boolean = false
)
package com.beratcevik.uclseminar.screens.stockdetail

data class StockDetailViewState(
    val title: String,
    val symbol: String,
    val price: String,
    val priceColorId: Int,
    val favoriteButtonTitle: String,
    val imageUrl: String
)
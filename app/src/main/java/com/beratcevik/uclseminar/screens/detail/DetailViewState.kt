package com.beratcevik.uclseminar.screens.detail

import java.net.URL

data class DetailViewState(
    val title: String,
    val symbol: String,
    val price: String,
    val priceColorId: Int,
    val favoriteButtonTitle: String,
    val imageUrl: URL
)
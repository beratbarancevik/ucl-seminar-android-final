package com.beratcevik.uclseminar.screens.detail

import com.beratcevik.uclseminar.R
import com.beratcevik.uclseminar.service.stocks.StocksServiceI

class DetailViewModel(
    private val stockID: String,
    private val stockService: StocksServiceI
) {

    fun bind(viewStateHandler: (DetailViewState) -> Unit) {
        stockService.getStockDetails(stockID) {
            viewStateHandler.invoke(
                DetailViewState(
                    title = "Title",
                    symbol = "Symbol",
                    price = "14.5",
                    priceColorId = R.color.black,
                    favoriteButtonTitle = "Remove",
                    imageUrl = ""
                )
            )
        }
    }

    fun favoriteAction() {
        stockService.updateStockDetail(stockID, true)
    }
}
package com.beratcevik.uclseminar.screens.stockdetail

import com.beratcevik.uclseminar.R
import com.beratcevik.uclseminar.service.stocks.StocksServiceI
import com.beratcevik.uclseminar.service.stocks.models.Stock

class StockDetailViewModel(
    private val stockID: String,
    private val stockService: StocksServiceI
) {

    private var stock: Stock? = null

    fun bind(viewStateHandler: (StockDetailViewState) -> Unit) {
        stockService.getStockDetails(stockID) {
            val buttonTitle = if (it.favorite) {
                "Remove from Favourites"
            } else {
                "Add to Favourites"
            }

            val priceColorId = if(it.price >= (stock?.price ?: 0.0)) {
                R.color.green
            } else {
                R.color.red
            }

            viewStateHandler.invoke(
                StockDetailViewState(
                    title = it.title,
                    symbol = it.symbol,
                    price = it.price.toString(),
                    priceColorId = priceColorId,
                    favoriteButtonTitle = buttonTitle,
                    imageUrl = it.logoUrl
                )
            )

            stock = it
        }
    }

    fun favoriteAction() {
        stock?.favorite?.let {
            stockService.updateStockDetail(stockID, !it)
        }
    }
}
package com.beratcevik.uclseminar.screens.detail

import com.beratcevik.uclseminar.service.stocks.StocksServiceI

class DetailViewModel(
    private val stockID: String,
    private val stockService: StocksServiceI
) {

    fun bind() {
        stockService.getStockDetails(stockID, {

        })
    }

}
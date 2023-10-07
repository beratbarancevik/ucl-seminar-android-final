package com.beratcevik.uclseminar.service.stocks

interface StocksServiceI {
    fun getStocks()
    fun getStockDetails(stockID: String)
}

package com.beratcevik.uclseminar.service.stocks

import android.util.Log
import com.beratcevik.uclseminar.service.stocks.models.Stock
import com.google.firebase.firestore.FirebaseFirestore

class StockService(
    private val db: FirebaseFirestore
) : StocksServiceI {

    override fun getStocks(completionHandler: (List<Stock>) -> Unit) {
        db.collection("stocks").get()
            .addOnSuccessListener { result ->

            }
            .addOnFailureListener { exception ->
                Log.w(
                    this.javaClass.name,
                    "Error getting stocks",
                    exception
                )
            }
    }

    override fun getStockDetails(stockID: String, completionHandler: (Stock) -> Unit) {
        db.collection("stocks").document(stockID).get()
            .addOnSuccessListener { result ->

            }
            .addOnFailureListener { exception ->
                Log.w(
                    this.javaClass.name,
                    "Error getting stocks",
                    exception
                )
            }
    }

    override fun updateStockDetail(stockID: String, isFavorite: Boolean) {
//        db.collection("stocks").document(stockID).set()
    }

    override fun uploadStocks() {
//        db.collection("stocks").add()
    }
}
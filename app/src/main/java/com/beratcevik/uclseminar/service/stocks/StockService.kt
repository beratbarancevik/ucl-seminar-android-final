package com.beratcevik.uclseminar.service.stocks

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

class StockService(
    private val db: FirebaseFirestore
) : StocksServiceI {

    override fun getStocks() {
        db.collection("stocks")
            .get()
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

    override fun getStockDetails(stockID: String) {
        db.collection("stocks/$stockID")
            .get()
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
}
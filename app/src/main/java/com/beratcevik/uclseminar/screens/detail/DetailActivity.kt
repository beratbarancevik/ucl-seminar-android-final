package com.beratcevik.uclseminar.screens.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.beratcevik.uclseminar.databinding.ActivityDetailBinding
import com.beratcevik.uclseminar.service.stocks.StockService
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val stockID = intent.getStringExtra("stockID") ?: ""
        viewModel = DetailViewModel(stockID, StockService(Firebase.firestore))

        viewModel.bind {

        }
    }
}
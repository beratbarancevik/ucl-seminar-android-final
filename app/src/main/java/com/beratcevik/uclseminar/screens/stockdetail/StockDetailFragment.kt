package com.beratcevik.uclseminar.screens.stockdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.beratcevik.uclseminar.databinding.FragmentStockDetailBinding
import com.beratcevik.uclseminar.service.stocks.StockService
import com.bumptech.glide.Glide
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class StockDetailFragment : Fragment() {

    private lateinit var viewModel: StockDetailViewModel
    private var _binding: FragmentStockDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val stockID: String = requireArguments().getString("stockID") ?: ""
        viewModel = StockDetailViewModel(stockID, StockService(Firebase.firestore))
        _binding = FragmentStockDetailBinding.inflate(inflater, container, false)

        viewModel.bind {
            Glide.with(this)
                .load(it.imageUrl)
                .into(binding.imageView)
            binding.titleTextView.text = it.title
            binding.symbolTextView.text = it.symbol
            binding.priceTextView.text = it.price
            binding.priceTextView.setTextColor(resources.getColor(it.priceColorId))
            binding.favoriteButton.text = it.favoriteButtonTitle
        }

        binding.favoriteButton.setOnClickListener {
            viewModel.favoriteAction()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(stockID: String): StockDetailFragment {
            val fragment = StockDetailFragment()
            val args = Bundle().apply {
                putString("stockID", stockID)
            }
            fragment.arguments = args
            return fragment
        }
    }
}
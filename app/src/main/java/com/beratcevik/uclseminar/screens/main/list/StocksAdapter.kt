package com.beratcevik.uclseminar.screens.main.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.beratcevik.uclseminar.R
import com.beratcevik.uclseminar.databinding.StockRowBinding
import com.beratcevik.uclseminar.service.stocks.models.Stock

class StocksAdapter(
    var stocks: List<Stock>,
    private val onRowTap: (Stock) -> Unit
) : RecyclerView.Adapter<StocksAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: StockRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val stock = stocks[position]
                    onRowTap(stock)
                }
            }
        }

        fun bind(book: Stock) {
            binding.textView.text = book.title
//            Glide
//                .with(binding.imageView.context)
//                .load(book.thumbnailUrl)
//                .into(binding.thumbnailImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = StockRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(stocks[position])
    }

    override fun getItemCount() = stocks.size
}
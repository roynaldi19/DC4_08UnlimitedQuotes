package com.roynaldi19.dc4_08unlimitedquotes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.roynaldi19.dc4_08unlimitedquotes.databinding.ItemQuoteBinding
import com.roynaldi19.dc4_08unlimitedquotes.network.QuoteResponseItem

class QuoteListAdapter :
    PagingDataAdapter<QuoteResponseItem, QuoteListAdapter.MyViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemQuoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = getItem(position)
        if (data != null) {
            holder.bind(data)
        }
    }

    class MyViewHolder(private val binding: ItemQuoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: QuoteResponseItem) {
            binding.tvItemQuote.text = data.en
            binding.tvItemAuthor.text = data.author
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<QuoteResponseItem>() {
            override fun areItemsTheSame(oldItem: QuoteResponseItem, newItem: QuoteResponseItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: QuoteResponseItem, newItem: QuoteResponseItem): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}
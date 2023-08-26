package com.roynaldi19.dc4_08unlimitedquotes.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.roynaldi19.dc4_08unlimitedquotes.adapter.QuoteListAdapter
import com.roynaldi19.dc4_08unlimitedquotes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels {
        ViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvQuote.layoutManager = LinearLayoutManager(this)

        getData()
    }

    private fun getData() {
        val adapter = QuoteListAdapter()
        binding.rvQuote.adapter = adapter
        mainViewModel.getQuote()
        mainViewModel.quote.observe(this, {
            adapter.submitList(it)
        })
    }
}
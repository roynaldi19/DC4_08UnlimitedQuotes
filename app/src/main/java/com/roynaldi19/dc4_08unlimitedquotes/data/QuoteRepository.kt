package com.roynaldi19.dc4_08unlimitedquotes.data

import com.roynaldi19.dc4_08unlimitedquotes.database.QuoteDatabase
import com.roynaldi19.dc4_08unlimitedquotes.network.ApiService
import com.roynaldi19.dc4_08unlimitedquotes.network.QuoteResponseItem

class QuoteRepository(private val quoteDatabase: QuoteDatabase, private val apiService: ApiService) {
    suspend fun getQuote(): List<QuoteResponseItem> {
        return apiService.getQuote(1, 5)
    }
}
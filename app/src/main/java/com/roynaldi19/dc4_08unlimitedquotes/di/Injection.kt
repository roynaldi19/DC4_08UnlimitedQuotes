package com.roynaldi19.dc4_08unlimitedquotes.di

import android.content.Context
import com.roynaldi19.dc4_08unlimitedquotes.data.QuoteRepository
import com.roynaldi19.dc4_08unlimitedquotes.database.QuoteDatabase
import com.roynaldi19.dc4_08unlimitedquotes.network.ApiConfig

object Injection {
    fun provideRepository(context: Context): QuoteRepository {
        val database = QuoteDatabase.getDatabase(context)
        val apiService = ApiConfig.getApiService()
        return QuoteRepository(database, apiService)
    }
}
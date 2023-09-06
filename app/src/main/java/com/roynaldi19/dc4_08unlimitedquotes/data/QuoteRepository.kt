package com.roynaldi19.dc4_08unlimitedquotes.data

import androidx.lifecycle.LiveData
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.roynaldi19.dc4_08unlimitedquotes.database.QuoteDatabase
import com.roynaldi19.dc4_08unlimitedquotes.network.ApiService
import com.roynaldi19.dc4_08unlimitedquotes.network.QuoteResponseItem

class QuoteRepository(
    private val quoteDatabase: QuoteDatabase,
    private val apiService: ApiService
) {
    @OptIn(ExperimentalPagingApi::class)
    fun getQuote(): LiveData<PagingData<QuoteResponseItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = 5
            ),
            remoteMediator = QuoteRemoteMediator(quoteDatabase, apiService),
            pagingSourceFactory = {
                quoteDatabase.quoteDao().getAllQuote()
            }
        ).liveData
    }
}
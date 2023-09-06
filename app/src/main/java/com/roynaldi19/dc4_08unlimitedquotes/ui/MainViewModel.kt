package com.roynaldi19.dc4_08unlimitedquotes.ui

import android.content.Context
import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.roynaldi19.dc4_08unlimitedquotes.data.QuoteRepository
import com.roynaldi19.dc4_08unlimitedquotes.di.Injection
import com.roynaldi19.dc4_08unlimitedquotes.network.QuoteResponseItem

class MainViewModel(quoteRepository: QuoteRepository) : ViewModel() {
    var quote: LiveData<PagingData<QuoteResponseItem>> =
        quoteRepository.getQuote().cachedIn(viewModelScope)

}

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(Injection.provideRepository(context)) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
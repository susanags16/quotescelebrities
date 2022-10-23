package com.example.quotescelebrities.presentation.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
//import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.quotescelebrities.data.QuoteNewRepository
import com.example.quotescelebrities.data.QuoteRepositoryImpl
import com.example.quotescelebrities.data.local.QuoteDataBase
import com.example.quotescelebrities.data.local.entities.QuoteEntity
import com.example.quotescelebrities.domain.QuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuoteViewModel (application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<QuoteEntity>>
    private val repository: QuoteNewRepository

    init {
        val quoteDao = QuoteDataBase.getDataBase(application).userDao()
        repository = QuoteNewRepository(quoteDao)
        readAllData = repository.readAllDaata

    }

    fun addQuote(quote:QuoteEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addQuote(quote)
        }

    }

}
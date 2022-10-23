package com.example.quotescelebrities.data

import androidx.lifecycle.LiveData
import com.example.quotescelebrities.data.local.daos.QuoteDao
import com.example.quotescelebrities.data.local.entities.QuoteEntity

class QuoteNewRepository (private val quoteDao: QuoteDao) {

    val readAllDaata: LiveData<List<QuoteEntity>> = quoteDao.readAllData()
    // Funcion Agregar cita
    suspend fun addQuote(quote: QuoteEntity){
        quoteDao.addQuote(quote)
    }

}
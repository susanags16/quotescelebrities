package com.example.quotescelebrities.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.quotescelebrities.data.local.daos.QuoteDao
import com.example.quotescelebrities.data.local.entities.QuoteEntity


@Database(entities = [QuoteEntity::class], version = 1, exportSchema = false)
abstract class QuoteDataBase: RoomDatabase() {

    abstract fun userDao():QuoteDao

    companion object{
        @Volatile
        private var INSTANCE: QuoteDataBase? = null

        fun getDataBase(context: Context): QuoteDataBase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    QuoteDataBase::class.java,
                    "quote"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}
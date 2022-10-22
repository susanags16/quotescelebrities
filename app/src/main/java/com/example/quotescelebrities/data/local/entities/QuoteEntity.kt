package com.example.quotescelebrities.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "quote")
data class QuoteEntity ( //asociada a la base de datos
    @PrimaryKey
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("quote")
    var quote: String = "",
    @SerializedName("author")
    var author: String = "",
)
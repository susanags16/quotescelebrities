package com.example.quotescelebrities.presentation.view


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.quotescelebrities.data.local.entities.QuoteEntity
import com.example.quotescelebrities.databinding.ActivityAddQuoteBinding
import com.example.quotescelebrities.presentation.view_model.QuoteViewModel


class AddQuoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddQuoteBinding
    private lateinit var mUserViewModel: QuoteViewModel


    override fun onCreate(savedInstanceState: Bundle?) {

        mUserViewModel = ViewModelProvider(this).get(QuoteViewModel::class.java)

        super.onCreate(savedInstanceState)
        binding = ActivityAddQuoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // setContentView(R.layout.activity_add_quote)

        binding.buttonAddQuote.setOnClickListener {
            insertDataToDatabase()
        }
    }

    private fun insertDataToDatabase() {
        val addAuthor = binding.edtAddAuthor.text.toString()
        val addQuote = binding.edtAddQuote.text.toString()

        if (inputCheck(addAuthor, addQuote)){

            //Crear el objeto cita
            val quote = QuoteEntity(0, addAuthor, addQuote)

            //Agregar a la base de datos
            mUserViewModel.addQuote(quote)
            Toast.makeText(this, "Cita Guardada Correctamente", Toast.LENGTH_SHORT).show()
            binding.edtAddQuote.text.clear()
            binding.edtAddAuthor.text.clear()

        }else{
            Toast.makeText(this, "No se guardo la cita", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(addAuthor: String, addQuote: String): Boolean{
        return !(TextUtils.isEmpty(addAuthor) && TextUtils.isEmpty(addQuote))
    }
}
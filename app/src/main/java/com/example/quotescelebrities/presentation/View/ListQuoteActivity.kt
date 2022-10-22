package com.example.quotescelebrities.presentation.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager


class LIstQuoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListQuoteBinding
    private lateinit var mUserViewModel: QuoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityListQuoteBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_list_quote)
        setContentView(binding.root)

        // RecyclerView

        val adapter = ListAdapter()
        binding.idRecyclerview.adapter = adapter
        binding.idRecyclerview.layoutManager = LinearLayoutManager(this)

        //User VIewModel
        mUserViewModel = ViewModelProvider(this).get(QuoteViewModel::class.java)
        mUserViewModel.readAllData.observe(this, Observer { quote ->
            adapter.setData(quote)
        })

    }
}
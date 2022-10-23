package com.example.quotescelebrities.presentation.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quotescelebrities.R
import com.example.quotescelebrities.data.local.entities.QuoteEntity
import kotlinx.android.synthetic.main.recyclerview_item.view.*


class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {


    private var quoteList = emptyList<QuoteEntity>()


    class MyViewHolder(Itemview: View): RecyclerView.ViewHolder(Itemview) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false))

    }

    override fun getItemCount(): Int {
        return quoteList.size
    }

    override fun onBindViewHolder(holder: ListAdapter.MyViewHolder, position: Int) {
        val currentItem = quoteList[position]
        //holder.itemView.id_tv.text = currentItem.id.toString()
        holder.itemView.tv_Author.text = currentItem.author
        holder.itemView.tv_Quote.text = currentItem.quote

    }

    fun setData(quote: List<QuoteEntity>){
        this.quoteList = quote
        notifyDataSetChanged()
    }
}
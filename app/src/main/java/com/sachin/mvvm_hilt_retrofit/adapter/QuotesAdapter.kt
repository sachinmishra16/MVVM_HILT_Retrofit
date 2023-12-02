package com.sachin.mvvm_hilt_retrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.sachin.mvvm_hilt_retrofit.R
import com.sachin.mvvm_hilt_retrofit.model.QuoteResponse
import com.sachin.mvvm_hilt_retrofit.model.Result

class QuotesAdapter(var quoteList:List<Result>):RecyclerView.Adapter<QuotesAdapter.QuoteViewHolder>()
{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.quote_layout,parent,false)
        return QuoteViewHolder(view)
    }

    override fun getItemCount(): Int {
     return quoteList.size
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {

        holder.tvAuthid.text=quoteList.get(position)._id
        holder.tvAuthname.text=quoteList.get(position).author
    }
    class QuoteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        var tvAuthid=itemView.findViewById<TextView>(R.id.tvAuthId)
        var tvAuthname=itemView.findViewById<TextView>(R.id.tvAuthName)
    }
}
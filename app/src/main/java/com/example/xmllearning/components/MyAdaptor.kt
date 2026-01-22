package com.example.xmllearning.components

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.xmllearning.R

class MyAdaptor(private val items: List<String>): RecyclerView.Adapter<MyAdaptor.MyViewHolder>() {


    //ViewHolder === One Row - this represents one item, in the row
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.tvName)
    }

    //IMPLEMENTED CLASS//
    //When u need a new row, use the MyViewHolder row
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_item, parent, false)
        return MyViewHolder(view)
    }

    //For this row, put the correct data
    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        holder.name.text = items[position]
    }

    //How many rows needed, row size
    override fun getItemCount(): Int = items.size
}
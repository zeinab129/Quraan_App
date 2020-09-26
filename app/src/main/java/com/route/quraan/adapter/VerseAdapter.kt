package com.route.quraan.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.route.quraan.R

class VerseAdapter(val items: List<String>): RecyclerView.Adapter<VerseAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_vers, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = items.get(position)
        holder.verse.setText(item + " { ${position + 1} }")
    }

    var onItemClickListener:OnItemClickListener?= null

    interface OnItemClickListener{
        fun onItemClick(position: Int, item: String)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var verse :TextView
        init {
            verse = itemView.findViewById(R.id.verse_tv_content)
        }
    }
}
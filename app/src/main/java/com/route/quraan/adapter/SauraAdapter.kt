package com.route.quraan.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.route.quraan.R

class SauraAdapter(val items: List<String>): RecyclerView.Adapter<SauraAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_saura, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = items.get(position)
        holder.suraName.setText(item)

        if(onItemClickListener != null){
            holder.suraName.setOnClickListener({
                onItemClickListener?.onItemClick(position, item)
            })
        }
    }

    var onItemClickListener:OnItemClickListener?= null

    interface OnItemClickListener{
        fun onItemClick(position: Int, item: String)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var suraName:TextView
        init {
            suraName = itemView.findViewById(R.id.sura_name)
        }
    }
}
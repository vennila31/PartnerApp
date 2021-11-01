package com.codetez.partnerapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.codetez.partnerapp.R
import com.codetez.partnerapp.model.ItemListData

class ItemListAdapter(var activity : Context, var categoryList : ArrayList<ItemListData>) : RecyclerView.Adapter<ItemListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val rootView: View = LayoutInflater.from(activity)
            .inflate(R.layout.total_list, parent, false)
        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindItems(categoryList[position])

    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
    {

        val itemName : AppCompatTextView = itemView.findViewById(R.id.item_label)
        val quantity : AppCompatTextView = itemView.findViewById(R.id.qty_label)
        val total : AppCompatTextView = itemView.findViewById(R.id.total_label)

        var mystring: String = itemView.context.resources.getString(R.string.Rs)

        fun bindItems(data : ItemListData){

            itemName.text = data.itemName
            quantity.text = data.qty
            total.text = mystring + data.total

        }

    }
}
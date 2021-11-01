package com.codetez.partnerapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codetez.partnerapp.R
import com.codetez.partnerapp.model.OrdersHistoryData

class ExpandableListAdapter(var activity : Context, var categoryList : ArrayList<OrdersHistoryData>) : RecyclerView.Adapter<ExpandableListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val rootView: View = LayoutInflater.from(activity)
            .inflate(R.layout.item_list, parent, false)
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


        fun bindItems(data : OrdersHistoryData){



        }

    }
}
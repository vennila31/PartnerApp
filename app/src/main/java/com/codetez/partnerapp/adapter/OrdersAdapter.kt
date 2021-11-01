package com.codetez.partnerapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.codetez.partnerapp.R
import com.codetez.partnerapp.model.OrdersData
import com.codetez.partnerapp.ui.orders.MyOrdersActivity

class OrdersAdapter(var activity : Context, var ordersList : ArrayList<OrdersData>) : RecyclerView.Adapter<OrdersAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView: View = LayoutInflater.from(activity)
            .inflate(R.layout.orders_list, parent, false)
        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindItems(ordersList[position])
        holder.itemView.setOnClickListener {
            activity.startActivity(Intent(activity,MyOrdersActivity::class.java)
                .putExtra("orders",holder.accept.text)
                .putExtra("toolbar",holder.reject.text))
        }

    }

    override fun getItemCount(): Int {
        return ordersList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val accept: AppCompatButton = itemView.findViewById(R.id.accept)
        val reject: AppCompatButton = itemView.findViewById(R.id.reject)

        fun bindItems(data: OrdersData) {

            if(data.activeOrNew == "Active")
            {
                accept.text = data.buttonName
                reject.text = "Cancel"
            }
            else{
                accept.text = "Accept"
                reject.text = "Reject"
            }

        }

    }
}
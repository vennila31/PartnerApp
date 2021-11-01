package com.codetez.partnerapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codetez.partnerapp.R
import com.codetez.partnerapp.model.CompletedOrder
import com.codetez.partnerapp.model.OrdersData
import com.codetez.partnerapp.model.OrdersHistoryData
import com.codetez.partnerapp.ui.orders.MyOrdersActivity
import com.skydoves.expandablelayout.ExpandableLayout

class OrderHistoryAdapter(var activity : Context, var ordersList : ArrayList<CompletedOrder>) : RecyclerView.Adapter<OrderHistoryAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView: View = LayoutInflater.from(activity)
            .inflate(R.layout.order_history_page, parent, false)
        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindItems(ordersList[position])
        holder.itemView.setOnClickListener {
            activity.startActivity(
                Intent(activity, MyOrdersActivity::class.java).putExtra("orders","orderHistory"))
        }

    }

    override fun getItemCount(): Int {
        return ordersList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val expandableLayout: ExpandableLayout = itemView.findViewById(R.id.expandable)
        var arrayList : ArrayList<OrdersHistoryData> = ArrayList()

         fun bindItems(data: CompletedOrder) {

             expandableLayout.parentLayout.setOnClickListener { expandableLayout.toggleLayout() }

             val text : AppCompatTextView = expandableLayout.parentLayout.findViewById<AppCompatTextView>(R.id.text)

             text.text = data.date

             val recyclerView: RecyclerView = expandableLayout.secondLayout.findViewById<RecyclerView>(R.id.recyclerView)

              arrayList.add(OrdersHistoryData("123456789","04.00 PM"
              ,"12, Abcdefgh street, Anna nagar,Chennai -21.",R.drawable.rrk))
             arrayList.add(OrdersHistoryData("123456789","04.00 PM"
                 ,"12, Abcdefgh street, Anna nagar,Chennai -21.",R.drawable.rrk))



             val adapter : ExpandableListAdapter = ExpandableListAdapter(itemView.context , arrayList)

             recyclerView.layoutManager = LinearLayoutManager(itemView.context)
             recyclerView.adapter = adapter


        }

        }




}
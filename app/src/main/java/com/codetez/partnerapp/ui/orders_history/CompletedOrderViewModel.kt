package com.codetez.partnerapp.ui.orders_history

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codetez.partnerapp.R
import com.codetez.partnerapp.model.CompletedOrder

class CompletedOrderViewModel : ViewModel() {
    var orderLiveData: MutableLiveData<ArrayList<CompletedOrder>?>? = null
    var orderArrayList: ArrayList<CompletedOrder>? = null

    init {
        orderLiveData = MutableLiveData<ArrayList<CompletedOrder>?>()
        init()
    }

    fun getOrderMutableLiveData(): MutableLiveData<ArrayList<CompletedOrder>?>? {
        return orderLiveData
    }

    fun init() {
        populateList()
        orderLiveData!!.value = orderArrayList
    }

    private fun populateList() {
        orderArrayList = ArrayList()


        orderArrayList!!.add(
            CompletedOrder("Today")
        )
        orderArrayList!!.add(
            CompletedOrder("06 OCT 2021")
        )
        orderArrayList!!.add(
            CompletedOrder("07 OCT 2021")
        )
        orderArrayList!!.add(
            CompletedOrder("08 OCT 2021")
        )
        orderArrayList!!.add(
            CompletedOrder("09 OCT 2021")
        )

       /* orderArrayList!!.add(
            OrdersHistoryData("08 OCT 2021","123456789","04.00 PM"
                ,"12, Abcdefgh street, Anna nagar,Chennai -21.",R.drawable.rrk)
        )*/




    }

}
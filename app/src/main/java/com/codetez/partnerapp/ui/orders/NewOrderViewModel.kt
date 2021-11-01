package com.codetez.partnerapp.ui.orders

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codetez.partnerapp.R
import com.codetez.partnerapp.model.OrdersData

class NewOrderViewModel : ViewModel() {
    var orderLiveData: MutableLiveData<ArrayList<OrdersData>?>? = null
    var orderArrayList: ArrayList<OrdersData>? = null

    init {
        orderLiveData = MutableLiveData<ArrayList<OrdersData>?>()
        init()
    }

    fun getOrderMutableLiveData(): MutableLiveData<ArrayList<OrdersData>?>? {
        return orderLiveData
    }

    fun init() {
        populateList()
        orderLiveData!!.value = orderArrayList
    }

    private fun populateList() {
        orderArrayList = ArrayList()


        orderArrayList!!.add(OrdersData(R.drawable.rrk,"123456789","04.00 PM"
            ,"12, Abcdefgh street, Anna nagar,Chennai -21.","2 Km","New",""))
        orderArrayList!!.add(OrdersData(R.drawable.rrk,"123456789","04.00 PM"
            ,"12, Abcdefgh street, Anna nagar,Chennai -21.","2 Km","New",""))
        orderArrayList!!.add(OrdersData(R.drawable.rrk,"123456789","04.00 PM"
            ,"12, Abcdefgh street, Anna nagar,Chennai -21.","2 Km","New",""))
        orderArrayList!!.add(OrdersData(R.drawable.rrk,"123456789","04.00 PM"
            ,"12, Abcdefgh street, Anna nagar,Chennai -21.","2 Km","New",""))

        orderArrayList!!.add(OrdersData(R.drawable.rrk,"123456789","04.00 PM"
            ,"12, Abcdefgh street, Anna nagar,Chennai -21.","2 Km","New",""))
        orderArrayList!!.add(OrdersData(R.drawable.rrk,"123456789","04.00 PM"
            ,"12, Abcdefgh street, Anna nagar,Chennai -21.","2 Km","New",""))
        orderArrayList!!.add(OrdersData(R.drawable.rrk,"123456789","04.00 PM"
            ,"12, Abcdefgh street, Anna nagar,Chennai -21.","2 Km","New",""))
        orderArrayList!!.add(OrdersData(R.drawable.rrk,"123456789","04.00 PM"
            ,"12, Abcdefgh street, Anna nagar,Chennai -21.","2 Km","New",""))




    }


}
package com.codetez.partnerapp.ui.orders

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codetez.partnerapp.model.ItemListData

class MyOrdersViewModel : ViewModel() {

    var listLiveData: MutableLiveData<ArrayList<ItemListData>?>? = null
    var listArrayList: ArrayList<ItemListData>? = null

    init {
        listLiveData = MutableLiveData<ArrayList<ItemListData>?>()
        init()
    }

    fun getCartMutableLiveData(): MutableLiveData<ArrayList<ItemListData>?>? {
        return listLiveData
    }


    fun init() {
        populateList()
        listLiveData!!.value = listArrayList
    }

    private fun populateList() {


        listArrayList = ArrayList()


        listArrayList!!.add(ItemListData("Vanjaram (Medium)","2 * 400","800.00"))
        listArrayList!!.add(ItemListData("Prawn (Large)","2 * 400","800.00"))
        listArrayList!!.add(ItemListData("crab (Small)","2 * 400","800.00"))
        listArrayList!!.add(ItemListData("Egg regular)","2 * 50","100.00"))





    }

}
package com.codetez.partnerapp.ui.orders_history

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codetez.partnerapp.R
import com.codetez.partnerapp.adapter.OrderHistoryAdapter
import com.codetez.partnerapp.adapter.OrdersAdapter
import com.codetez.partnerapp.model.CompletedOrder
import com.codetez.partnerapp.model.OrdersData
import com.codetez.partnerapp.model.OrdersHistoryData
import com.codetez.partnerapp.ui.orders.ActiveOrderViewModel
import com.skydoves.expandablelayout.ExpandableLayout

class CompletedOrderFragment : Fragment() {

    lateinit var adapter: OrderHistoryAdapter
    lateinit var recyclerView: RecyclerView

    private lateinit var viewModel: CompletedOrderViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var root = inflater.inflate(R.layout.completed_order_fragment, container, false)

        recyclerView = root.findViewById(R.id.recyclerView)
        viewModel =
            ViewModelProvider(this).get(CompletedOrderViewModel::class.java)

        viewModel.getOrderMutableLiveData()!!.observe(requireActivity(), catListUpdateObserver)




        return root
    }

    var catListUpdateObserver : Observer<ArrayList<CompletedOrder>?> =  Observer<ArrayList<CompletedOrder>?> {

        Log.d("data",it.toString())
        adapter = OrderHistoryAdapter(requireActivity(),it)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

    }
}
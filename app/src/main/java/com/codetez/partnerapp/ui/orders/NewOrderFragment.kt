package com.codetez.partnerapp.ui.orders

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codetez.partnerapp.R
import com.codetez.partnerapp.adapter.OrdersAdapter
import com.codetez.partnerapp.model.OrdersData

class NewOrderFragment : Fragment() {

    lateinit var adapter: OrdersAdapter
    lateinit var recyclerView: RecyclerView

    private lateinit var viewModel: NewOrderViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var root = inflater.inflate(R.layout.new_order_fragment, container, false)

        recyclerView = root.findViewById(R.id.recyclerView)
        viewModel =
            ViewModelProvider(this).get(NewOrderViewModel::class.java)

        viewModel.getOrderMutableLiveData()!!.observe(requireActivity(), catListUpdateObserver)


        return root
    }

    var catListUpdateObserver : Observer<ArrayList<OrdersData>?> =  Observer<ArrayList<OrdersData>?> {

        Log.d("data",it.toString())
        adapter = OrdersAdapter(requireActivity(),it)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

    }

}
package com.codetez.partnerapp.ui.orders_history

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codetez.partnerapp.R

class CancelledOrderFragment : Fragment() {


    private lateinit var viewModel: CancelledOrderViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.cancelled_order_fragment, container, false)
    }


}
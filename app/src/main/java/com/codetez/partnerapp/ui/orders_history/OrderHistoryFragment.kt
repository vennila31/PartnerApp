package com.codetez.partnerapp.ui.orders_history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.codetez.partnerapp.adapter.ViewPagerAdapter
import com.codetez.partnerapp.databinding.FragmentOrderHistoryBinding
import com.google.android.material.tabs.TabLayout

class OrderHistoryFragment : Fragment() {

    private lateinit var orderHistoryViewModel: OrderHistoryViewModel
    private var _binding: FragmentOrderHistoryBinding? = null


    private val binding get() = _binding!!

    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()

        orderHistoryViewModel =
            ViewModelProvider(this).get(OrderHistoryViewModel::class.java)

        _binding = FragmentOrderHistoryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        tabLayout = binding.tabLayout
        viewPager = binding.viewPager
        tabLayout.addTab(tabLayout.newTab().setText("Completed"))
        tabLayout.addTab(tabLayout.newTab().setText("Cancelled"))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL


        val adapter = com.codetez.partnerapp.adapter.ViewPager(
            requireContext(), childFragmentManager,
            tabLayout.tabCount
        )
        viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
            }
            override fun onTabReselected(tab: TabLayout.Tab) {
            }
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
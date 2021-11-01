package com.codetez.partnerapp.ui.orders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.codetez.partnerapp.adapter.ViewPagerAdapter
import com.codetez.partnerapp.databinding.FragmentOrdersBinding
import com.google.android.material.tabs.TabLayout

class OrdersFragment : Fragment() {

    private lateinit var ordersViewModel: OrdersViewModel
    private var _binding: FragmentOrdersBinding? = null


    private val binding get() = _binding!!

    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()

        ordersViewModel =
            ViewModelProvider(this).get(OrdersViewModel::class.java)

        _binding = FragmentOrdersBinding.inflate(inflater, container, false)
        val root: View = binding.root

        tabLayout = binding.tabLayout
        viewPager = binding.viewPager
        tabLayout.addTab(tabLayout.newTab().setText("New Order"))
        tabLayout.addTab(tabLayout.newTab().setText("Active Order"))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL


        val adapter = ViewPagerAdapter(
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
package com.codetez.partnerapp.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.codetez.partnerapp.ui.orders_history.CompletedOrderFragment

class ViewPager(private val myContext: Context, fm: FragmentManager, var totalTabs: Int) : FragmentPagerAdapter(fm) {


    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return CompletedOrderFragment()
            }
            1 -> {
                return CompletedOrderFragment()
            }

            else -> return CompletedOrderFragment()
        }
    }

    override fun getCount(): Int {
        return totalTabs
    }
}
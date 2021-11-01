package com.codetez.partnerapp.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.codetez.partnerapp.ui.orders.ActiveOrderFragment
import com.codetez.partnerapp.ui.orders.NewOrderFragment

class ViewPagerAdapter(private val myContext: Context, fm: FragmentManager, var totalTabs: Int) : FragmentPagerAdapter(fm) {


    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return NewOrderFragment()
            }
            1 -> {
                return ActiveOrderFragment()
            }

            else -> return NewOrderFragment()
        }
    }

    override fun getCount(): Int {
        return totalTabs
    }
}
package com.codetez.partnerapp.ui.orders

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codetez.partnerapp.R
import com.codetez.partnerapp.adapter.ItemListAdapter
import com.codetez.partnerapp.model.ItemListData
import com.codetez.partnerapp.ui.maps.MapsActivity

class MyOrdersActivity : AppCompatActivity() {

    lateinit var listAdapter : ItemListAdapter
    lateinit var recyclerView : RecyclerView
    lateinit var viewModel: MyOrdersViewModel

    var toolBar : String = ""
    var btnText : String = ""

    lateinit var pickUpLoc : AppCompatImageView
    lateinit var dropLoc : AppCompatImageView
    lateinit var call : AppCompatImageView

    lateinit var reject : AppCompatButton
    lateinit var accept : AppCompatButton

    lateinit var constLayout : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_orders)


        toolBar = intent.getStringExtra("toolbar").toString()
        btnText = intent.getStringExtra("orders").toString()

        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        recyclerView = findViewById(R.id.rvList)
        pickUpLoc = findViewById(R.id.pickUpLoc)
        dropLoc = findViewById(R.id.dropLoc)
        call = findViewById(R.id.call)
        reject = findViewById(R.id.reject)
        accept = findViewById(R.id.accept)
        constLayout = findViewById(R.id.constLayout)


        if(toolBar == "Reject")
        {
            supportActionBar!!.title = "Orders"
            pickUpLoc.visibility = View.GONE
            dropLoc.visibility = View.GONE
            call.visibility = View.GONE
        }
        else{
            supportActionBar!!.title = "My Orders"
            accept.setOnClickListener{
                startActivity(Intent(this,MapsActivity::class.java))
            }
        }

        reject.text = toolBar
        accept.text = btnText

        if(btnText == "orderHistory")
        {
            constLayout.visibility = View.VISIBLE
            accept.visibility = View.GONE
            reject.visibility = View.GONE
            supportActionBar!!.title = "Order History"
            pickUpLoc.visibility = View.GONE
            dropLoc.visibility = View.GONE
            call.visibility = View.GONE
        }

        viewModel = ViewModelProvider(this).get(MyOrdersViewModel::class.java)

        viewModel.getCartMutableLiveData()!!.observe(this,cartListUpdateObserver)




    }

    var cartListUpdateObserver : Observer<ArrayList<ItemListData>?> =  Observer<ArrayList<ItemListData>?> {

        Log.d("data",it.toString())
        listAdapter = ItemListAdapter(this,it)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = listAdapter

    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
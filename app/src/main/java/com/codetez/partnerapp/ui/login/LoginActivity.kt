package com.codetez.partnerapp.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.codetez.partnerapp.R

class LoginActivity : AppCompatActivity() {
    lateinit var submit : AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        submit = findViewById(R.id.submit)

        submit.setOnClickListener {
            startActivity(Intent(this,OtpActivity::class.java))
        }
    }
}
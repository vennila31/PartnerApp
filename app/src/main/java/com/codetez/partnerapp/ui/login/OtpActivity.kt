package com.codetez.partnerapp.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.codetez.partnerapp.MainActivity
import com.codetez.partnerapp.R

class OtpActivity : AppCompatActivity() {
    lateinit var submit : AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)

        submit = findViewById(R.id.submit)

        submit.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}
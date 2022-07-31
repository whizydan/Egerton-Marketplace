package com.kerberos.egertonmarketplace.install.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.kerberos.egertonmarketplace.R

class PhoneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone)
        var dest = ""
        val verify = findViewById<Button>(R.id.verify)
        dest = intent.getStringExtra("dest").toString()


        verify.setOnClickListener {
            val intent = Intent(this,PhoneValidation::class.java)
            intent.putExtra("phone","254799725502")
            intent.putExtra("dest",dest)
            startActivity(intent)
        }
    }
}
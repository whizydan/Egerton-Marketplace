package com.kerberos.egertonmarketplace.install.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.kerberos.egertonmarketplace.R

class ResetPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)
        val continues = findViewById<Button>(R.id.continuee)

        continues.setOnClickListener {
            startActivity(Intent(this,Login::class.java))
            finish()
        }
    }

}
package com.kerberos.egertonmarketplace.install.auth

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.kerberos.egertonmarketplace.Init
import com.kerberos.egertonmarketplace.R

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val login = findViewById<Button>(R.id.login)
        val forgotpassword = findViewById<TextView>(R.id.forgotpassword)
        val signup = findViewById<TextView>(R.id.signup)
        val Init = Init()
        val Register = PhoneActivity()


        login.setOnClickListener {
            startIntent(Init)
        }

        forgotpassword.setOnClickListener {
            val intent = Intent(this,PhoneActivity::class.java)
            intent.putExtra("dest","reset")
            startActivity(intent)
        }
        signup.setOnClickListener {
            startIntent(Register)
        }
    }

    private fun startIntent(destination : Activity){
        startActivity(Intent(this,destination::class.java))
    }
}
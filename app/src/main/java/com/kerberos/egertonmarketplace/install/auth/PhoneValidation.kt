package com.kerberos.egertonmarketplace.install.auth


import `in`.aabhasjindal.otptextview.OTPListener
import `in`.aabhasjindal.otptextview.OtpTextView
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kerberos.egertonmarketplace.R


class PhoneValidation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_validation)
        val text = findViewById<TextView>(R.id.textView8)
        val next = findViewById<Button>(R.id.next)
        val phone = intent.getStringExtra("phone")
        val dest = intent.getStringExtra("dest")
        text.text = "We sent a verification code to $phone.Please wait a moment before retrying again"

        val otpTextView: OtpTextView = findViewById(R.id.otp_view)
        otpTextView.otpListener = object : OTPListener {
            override fun onInteractionListener() {
                // fired when user types something in the Otpbox
            }

            override fun onOTPComplete(otp: String) {
                // fired when user has entered the OTP fully.
                Toast.makeText(applicationContext, "The OTP is $otp", Toast.LENGTH_SHORT).show()
            }
        }

        next.setOnClickListener {
            if (dest == "reset"){
                startActivity(Intent(this,ResetPassword::class.java))
                finish()
            }
            startActivity(Intent(this,Register::class.java))
        }

    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
package com.kerberos.egertonmarketplace.install

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.whenCreated
import com.kerberos.egertonmarketplace.Init
import com.kerberos.egertonmarketplace.access.TinyDB
import com.kerberos.egertonmarketplace.install.auth.Login
import java.util.*
import kotlin.concurrent.schedule

class Splash() : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timer("going next",false).schedule(1500){
            moveToNext()
        }
    }

    private fun moveToNext(){
        startActivity(Intent(this,GetStarted::class.java))
        finish()
    }
}
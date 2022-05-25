package com.kerberos.egertonmarketplace.install

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.kerberos.egertonmarketplace.Init
import java.util.*
import kotlin.concurrent.schedule

class Splash() : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //wait a second then proceed
        Timer("going next",false).schedule(1500){
            startActivity(Intent(this@Splash,Init::class.java))
            finish()
        }
    }
}
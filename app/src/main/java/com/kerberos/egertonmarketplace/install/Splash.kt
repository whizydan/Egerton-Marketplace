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
    private var tinyDB : TinyDB? = null
    private var LoggedIn :Boolean? = null
    private var Install :Boolean? = null
    private var Skip :Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //wait a second then proceed
        tinyDB = TinyDB(applicationContext)
        LoggedIn = tinyDB?.getBoolean("LoggedIn")
        Install = tinyDB?.getBoolean("Install")
        Skip = tinyDB?.getBoolean("SkippedLogin")

        Timer("going next",false).schedule(1500){
            moveToNext()
        }
    }

    private fun moveToNext(){
        if (Install == false){
            //show get started for first time install
            startActivity(Intent(this,GetStarted::class.java))
            finish()
        }else{
            if (LoggedIn == true){
                //if logged in go to home_screen
                startActivity(Intent(this,Init::class.java))
                finish()
            }else{
                curse()
            }
        }
    }

    private fun curse() {
        //if user skipped login take home otherwise to login screen
        if (Skip == true){
            startActivity(Intent(this,Init::class.java))
            finish()
        }else{
            startActivity(Intent(this,Login::class.java))
            finish()
        }
    }
}
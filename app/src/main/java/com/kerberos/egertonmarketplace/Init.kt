package com.kerberos.egertonmarketplace

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kerberos.egertonmarketplace.fragments.*

class Init : AppCompatActivity() {
    private var selectedFragment : Fragment? = null
    private val navlistener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when(item.itemId){
            R.id.home -> selectedFragment = HomeFragment()
            R.id.deliveries -> selectedFragment = StatusFragment()
            R.id.cart -> selectedFragment = CartFragment()
            R.id.notification -> selectedFragment = NotificationFragment()
            R.id.account -> selectedFragment = AccountFragment()
        }
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container,selectedFragment!!)
            .commit()
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //defaul using store fragment
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,HomeFragment()).commit()

        //ref to bottom nav controller
        val bottomnavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomnavigation.setOnNavigationItemSelectedListener(navlistener)
    }
}
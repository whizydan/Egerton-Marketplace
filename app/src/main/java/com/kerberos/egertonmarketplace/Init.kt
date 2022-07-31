package com.kerberos.egertonmarketplace

import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.kerberos.egertonmarketplace.fragments.*
import com.skydoves.androidbottombar.AndroidBottomBarView
import com.skydoves.androidbottombar.BottomMenuItem
import com.skydoves.androidbottombar.OnMenuItemSelectedListener
import com.skydoves.androidbottombar.animations.BadgeAnimation
import es.dmoral.toasty.Toasty

class Init : AppCompatActivity() {
    private var actionBarDrawerToggle : ActionBarDrawerToggle? = null
    private var drawerLayout : DrawerLayout? = null

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // drawer layout instance to toggle the menu icon to open
        // drawer and back button to close drawer
        drawerLayout = findViewById<DrawerLayout>(R.id.my_drawer_layout);
        actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout?.addDrawerListener(actionBarDrawerToggle!!)
        actionBarDrawerToggle!!.syncState()

        // to make the Navigation drawer icon always appear on the action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val androidBottomBar = findViewById<AndroidBottomBarView>(R.id.btmbar)
        androidBottomBar.addBottomMenuItems(mutableListOf(
            BottomMenuItem(this)
                .setTitle("Home") // sets the content of the title.
                .setTitleColorRes(R.color.black) // sets the color of the title using resource.
                .setTitleActiveColorRes(R.color.white) // sets the color of the title when selected/active.
                .setTitlePadding(6) // sets the padding of the title.
                .setTitleSize(14f) // sets the size of the title.
                .setTitleGravity(Gravity.CENTER) // sets gravity of the title.
                .setIcon(R.drawable.ic_home)
                .setIconColorRes(R.color.accent) // sets the [Drawable] of the icon using resource.
                .setIconActiveColorRes(R.color.purple_200) // sets the color of the icon when selected/active.
                .setBadgeText("New!") // sets the content of the badge.
                .setBadgeTextSize(9f) // sets the size of the badge.
                .setBadgeTextColorRes(R.color.white) // sets the text color of the badge using resource.
                .setBadgeColorRes(R.color.accent) // sets the color of the badge using resource.
                .setBadgeAnimation(BadgeAnimation.FADE) // sets an animation of the badge.
                .setBadgeDuration(450) // sets a duration of the badge.
                .build(),
            BottomMenuItem(this)
                .setTitle("search") // sets the content of the title.
                .setTitleColorRes(R.color.black) // sets the color of the title using resource.
                .setTitleActiveColorRes(R.color.white) // sets the color of the title when selected/active.
                .setTitlePadding(6) // sets the padding of the title.
                .setTitleSize(14f) // sets the size of the title.
                .setTitleGravity(Gravity.CENTER) // sets gravity of the title.
                .setIcon(R.drawable.search)
                .setIconColorRes(R.color.accent) // sets the [Drawable] of the icon using resource.
                .setIconActiveColorRes(R.color.purple_200) // sets the color of the icon when selected/active.
                .build(),
            BottomMenuItem(this)
                .setTitle("Cart") // sets the content of the title.
                .setTitleColorRes(R.color.black) // sets the color of the title using resource.
                .setTitleActiveColorRes(R.color.white) // sets the color of the title when selected/active.
                .setTitlePadding(6) // sets the padding of the title.
                .setTitleSize(14f) // sets the size of the title.
                .setTitleGravity(Gravity.CENTER) // sets gravity of the title.
                .setIcon(R.drawable.ic_cart)
                .setIconColorRes(R.color.accent) // sets the [Drawable] of the icon using resource.
                .setIconActiveColorRes(R.color.purple_200) // sets the color of the icon when selected/active.
                .setBadgeText("New!") // sets the content of the badge.
                .setBadgeTextSize(9f) // sets the size of the badge.
                .setBadgeTextColorRes(R.color.white) // sets the text color of the badge using resource.
                .setBadgeColorRes(R.color.accent) // sets the color of the badge using resource.
                .setBadgeAnimation(BadgeAnimation.FADE) // sets an animation of the badge.
                .setBadgeDuration(450) // sets a duration of the badge.
                .build(),
            BottomMenuItem(this)
                .setTitle("Account") // sets the content of the title.
                .setTitleColorRes(R.color.black) // sets the color of the title using resource.
                .setTitleActiveColorRes(R.color.white) // sets the color of the title when selected/active.
                .setTitlePadding(6) // sets the padding of the title.
                .setTitleSize(14f) // sets the size of the title.
                .setTitleGravity(Gravity.CENTER) // sets gravity of the title.
                .setIcon(R.drawable.ic_person)
                .setIconColorRes(R.color.accent) // sets the [Drawable] of the icon using resource.
                .setIconActiveColorRes(R.color.purple_200) // sets the color of the icon when selected/active.
                .build(),
            BottomMenuItem(this)
                .setTitle("invoice") // sets the content of the title.
                .setTitleColorRes(R.color.black) // sets the color of the title using resource.
                .setTitleActiveColorRes(R.color.white) // sets the color of the title when selected/active.
                .setTitlePadding(6) // sets the padding of the title.
                .setTitleSize(14f) // sets the size of the title.
                .setTitleGravity(Gravity.CENTER) // sets gravity of the title.
                .setIcon(R.drawable.ic__invoices)
                .setIconColorRes(R.color.accent) // sets the [Drawable] of the icon using resource.
                .setIconActiveColorRes(R.color.purple_200) // sets the color of the icon when selected/active.
                .build()
        )
        )

        androidBottomBar.onMenuItemSelectedListener = object : OnMenuItemSelectedListener{
            override fun onMenuItemSelected(index: Int, bottomMenuItem: BottomMenuItem, fromUser: Boolean){
                Toasty.info(applicationContext,"you clicked item at $index",Toasty.LENGTH_SHORT).show()
                when(index){
                    0 -> {
                        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                            HomeFragment()
                        ).commit()
                    }
                    1 -> {
                        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                            SearchFragment()
                        ).commit()
                    }
                    2 -> {
                        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                            CartFragment()
                        ).commit()
                    }
                    3 -> {
                        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                            AccountFragment()
                        ).commit()
                    }
                    4 -> {
                        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                            InvoicesFragment()
                        ).commit()
                    }
                }
            }
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(drawerLayout?.isOpen == true){
            drawerLayout?.close()
        }else if (drawerLayout?.isOpen == false){
            drawerLayout?.open()
        }
        return super.onOptionsItemSelected(item)
    }
}
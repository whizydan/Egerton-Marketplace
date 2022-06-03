package com.kerberos.egertonmarketplace.install

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.dialog.MaterialDialogs
import com.kerberos.egertonmarketplace.R
import com.kerberos.egertonmarketplace.install.auth.Login
import com.thecode.aestheticdialogs.AestheticDialog
import com.thecode.aestheticdialogs.DialogAnimation
import com.thecode.aestheticdialogs.DialogStyle
import com.thecode.aestheticdialogs.DialogType

class GetStarted : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_started)
        val btn = findViewById<Button>(R.id.button)
        val checkbox = findViewById<CheckBox>(R.id.checkBox)
        val license = findViewById<TextView>(R.id.License)
        btn.setEnabled(false)

        license.setOnClickListener {
            //show license
            AestheticDialog.Builder(this,DialogStyle.FLAT,DialogType.INFO)
                .setTitle("License Agreement")
                .setMessage("bluh bluh bluh bluh bluh bluh bluh bluh bluh bluh bluh ")
                .setCancelable(true)
                .setDarkMode(true)
                .setGravity(Gravity.CENTER)
                .setAnimation(DialogAnimation.SLIDE_UP)
                .show()
        }

        checkbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                btn.setEnabled(true)
            }else{
                btn.isEnabled = false
            }
        }

        btn.setOnClickListener {
            startActivity(Intent(this,Login::class.java))
            finish()
        }
    }
}
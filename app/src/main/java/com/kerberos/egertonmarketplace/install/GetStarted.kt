package com.kerberos.egertonmarketplace.install

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.kerberos.egertonmarketplace.R
import com.kerberos.egertonmarketplace.install.auth.Login
import com.maxkeppeler.sheets.core.SheetStyle
import com.maxkeppeler.sheets.info.InfoSheet

class GetStarted : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_started)
        val btn = findViewById<Button>(R.id.button)
        val checkbox = findViewById<CheckBox>(R.id.checkBox)
        val license = findViewById<TextView>(R.id.License)
        btn.setEnabled(false)


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

        license.setOnClickListener {
            val licen = getResources().openRawResource(R.raw.license).reader().readText()
            val bottomSheet = InfoSheet().build(this){
                style(SheetStyle.BOTTOM_SHEET)
                title("CHANGELOG")
                content(licen)
            }
            bottomSheet.show()
        }
    }

}
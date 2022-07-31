package com.kerberos.egertonmarketplace.install.auth

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.kerberos.egertonmarketplace.R
import com.maxkeppeler.sheets.calendar.CalendarSheet
import com.maxkeppeler.sheets.calendar.SelectionMode
import com.maxkeppeler.sheets.calendar.utils.toLocalDate
import de.hdodenhof.circleimageview.CircleImageView
import es.dmoral.toasty.Toasty
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class Register : AppCompatActivity() {
    private var imageButton: CircleImageView? = null
    private val pickImage = 100
    private var imageUri: Uri? = null
    private var dateInput: TextInputEditText? = null
    private var date : LocalDate? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        imageButton = findViewById(R.id.signupImage)
        val datePicker = findViewById<TextInputLayout>(R.id.datePick)
        val register = findViewById<Button>(R.id.signupButton)
        dateInput = findViewById(R.id.date)

        imageButton?.setCircleBackgroundColorResource(R.color.accent)
        imageButton?.setOnClickListener {
            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)
        }

        datePicker.setStartIconOnClickListener {
            CalendarSheet().show(this) {
                title("Select birth date")
                selectionMode(SelectionMode.DATE)
                onPositive { dateStart: Calendar, dateEnd: Calendar? ->
                    date = dateStart.toLocalDate()
                    dateInput?.setText(date.toString())
                }
            }
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            imageUri = data?.data
            imageButton?.setImageURI(imageUri)
        }
    }
}
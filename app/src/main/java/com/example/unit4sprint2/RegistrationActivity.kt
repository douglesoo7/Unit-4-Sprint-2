package com.example.unit4sprint2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {
    lateinit var dbHandler: DatabaseHandler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        btnRegister.setOnClickListener {
            dbHandler.registerEvent(
                etEventName.text.toString(),
                etEventDesc.text.toString(),
                etEventDate.text.toString(),
                etEventLocation.text.toString(),
                etEventPrice.text.toString()
            )
        }
    }
}
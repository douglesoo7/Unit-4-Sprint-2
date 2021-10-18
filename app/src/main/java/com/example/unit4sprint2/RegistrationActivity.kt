package com.example.unit4sprint2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {
    lateinit var dbHandler: DatabaseHandler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        dbHandler = DatabaseHandler(this)

        btnRegister.setOnClickListener {
            dbHandler.registerEvent(
                etEventName.text.toString(),
                etEventDesc.text.toString(),
                etEventDate.text.toString(),
                etEventLocation.text.toString(),
                etEventPrice.text.toString()
            )
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
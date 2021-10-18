package com.example.unit4sprint2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var eventsAdapter: EventsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        eventsAdapter=EventsAdapter()


        btnRegisterEvent.setOnClickListener{
            intent= Intent(applicationContext,RegistrationActivity::class.java)
            startActivity(intent)
        }


    }
}
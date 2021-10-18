package com.example.unit4sprint2

import android.content.Intent
import android.media.metrics.Event
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var eventsList: MutableList<EventsModel> = mutableListOf()
    lateinit var dbHandler: DatabaseHandler
    lateinit var eventsAdapter: EventsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHandler = DatabaseHandler(this)

        eventsList = dbHandler.getAllEvents()

        eventsAdapter = EventsAdapter(this,eventsList)
        eventsRecyclerView.layoutManager = LinearLayoutManager(this)
        eventsRecyclerView.adapter = eventsAdapter

        btnRegisterEvent.setOnClickListener {
            intent = Intent(applicationContext, RegistrationActivity::class.java)
            startActivity(intent)
        }


    }
}
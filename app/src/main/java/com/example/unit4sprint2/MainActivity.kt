package com.example.unit4sprint2

import android.content.Intent
import android.media.metrics.Event
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnEventClickListener {

    private var eventsList: MutableList<EventsModel> = mutableListOf()
    lateinit var dbHandler: DatabaseHandler
    lateinit var eventsAdapter: EventsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHandler = DatabaseHandler(this)

        eventsList = dbHandler.getAllEvents()

        eventsAdapter = EventsAdapter(this, eventsList, this)
        eventsRecyclerView.layoutManager = LinearLayoutManager(this)
        eventsRecyclerView.adapter = eventsAdapter

        btnRegisterEvent.setOnClickListener {
            intent = Intent(applicationContext, RegistrationActivity::class.java)
            startActivity(intent)
            eventsList.addAll(dbHandler.getAllEvents())
            eventsAdapter.notifyDataSetChanged()
        }

        search.setOnClickListener{
            intent=Intent(applicationContext,SearchActivity::class.java)        }

    }

    override fun onUpdateClickListener(event: EventsModel) {
        dbHandler.updateEvent(event.id,"Evaluation", "Sprint Evaluation", "18/10/2021", "Lucknow", "0")
        eventsList.clear()
        eventsList.addAll(dbHandler.getAllEvents())
        eventsAdapter.notifyDataSetChanged()
    }

    override fun onDeleteClickListener(event: EventsModel) {
        dbHandler.deleteEvent(event.id)
        eventsList.clear()
        eventsList.addAll(dbHandler.getAllEvents())
        eventsAdapter.notifyDataSetChanged()
    }
}
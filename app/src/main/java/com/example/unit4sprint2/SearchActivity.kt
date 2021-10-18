package com.example.unit4sprint2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class SearchActivity : AppCompatActivity(), OnEventClickListener {
    private var searchEventsList: MutableList<EventsModel> = mutableListOf()
    lateinit var dbHandler: DatabaseHandler
    lateinit var eventsAdapter: EventsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        dbHandler = DatabaseHandler(this)
        searchEventsList = dbHandler.searchEvent(searchText.toString())

        eventsAdapter = EventsAdapter(this, searchEventsList, this)
        eventsRecyclerView.layoutManager = LinearLayoutManager(this)
        eventsRecyclerView.adapter = eventsAdapter
    }

    override fun onUpdateClickListener(event: EventsModel) {
        dbHandler.updateEvent(event.id,"Evaluation", "Sprint Evaluation", "18/10/2021", "Lucknow", "0")
        searchEventsList.clear()
        searchEventsList.addAll(dbHandler.getAllEvents())
        eventsAdapter.notifyDataSetChanged()
    }

    override fun onDeleteClickListener(event: EventsModel) {
        dbHandler.deleteEvent(event.id)
        searchEventsList.clear()
        searchEventsList.addAll(dbHandler.getAllEvents())
        eventsAdapter.notifyDataSetChanged()
    }
}
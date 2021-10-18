package com.example.unit4sprint2

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class EventsAdapter(
    val context: Context,
    private val eventsList: MutableList<EventsModel>
) : RecyclerView.Adapter<EventsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.item_layout, parent, false)
        return EventsViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventsViewHolder, position: Int) {
        val event = eventsList.get(position)
        holder.name.text=event.name
        holder.desc.text=event.desc
        holder.date.text=event.date
        holder.location.text=event.location
        holder.price.text=event.price
        Log.d("Sachin","Inside OnBind")
    }

    override fun getItemCount(): Int {
        return eventsList.size
    }
}
package com.example.unit4sprint2

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EventsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var name: TextView = itemView.findViewById(R.id.tvEventName)
    var desc: TextView = itemView.findViewById(R.id.tvEventDesc)
    var date: TextView = itemView.findViewById(R.id.tvEventDate)
    var location: TextView = itemView.findViewById(R.id.tvEventLocation)
    var price: TextView = itemView.findViewById(R.id.tvEventPrice)



}
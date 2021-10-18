package com.example.unit4sprint2

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DatabaseHandler(val context: Context) : SQLiteOpenHelper(context, "eventsdb", null, 1) {

    companion object {
        val TABLE_NAME = "events_table"
        val ID = "id"
        val NAME = "name"
        val DESC = "desc"
        val DATE = "date"
        val LOCATION = "location"
        val PRICE = "price"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createQuery = "CREATE TABLE $TABLE_NAME($ID INTEGER PRIMARY KEY, " +
                "$NAME TEXT, " +
                "$DESC TEXT, " +
                "$DATE TEXT, " +
                "$LOCATION TEXT, " +
                "$PRICE INTEGER)"

        db?.execSQL(createQuery)
    }

    fun registerEvent(name: String, desc: String, date: String, location: String, price: String) {
        val db = writableDatabase
        val values = ContentValues()

        values.put(NAME, name)
        values.put(DESC, desc)
        values.put(DATE, date)
        values.put(LOCATION, location)
        values.put(PRICE, price)

        val id = db.insert(TABLE_NAME, null, values)

        if (id.toInt() != -1) {
            Toast.makeText(context, "Event Registered", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Error occurred, Please try again ", Toast.LENGTH_SHORT).show()
        }


    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}
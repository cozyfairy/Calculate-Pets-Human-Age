package com.cozyfairyllc.calculateyourpetshumanage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner

/*
    TODO:
        DROPDOWN MENU
            create a drop down menu
            create options for species drop down menu
        DATEPICKER VIEW
            create date picker
            Pick date button
        SELECTED DATE
            create selected date label textview
            create textview for selected date value
        HUMAN AGE
            textview for human age label
            human age value
        VALUES
            pick color scheme
            string resources

 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spinner: Spinner = findViewById(R.id.pet_spinner)
        ArrayAdapter.createFromResource(this, R.array.pet_options, android.R.layout.simple_spinner_item).also {
            adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }
}
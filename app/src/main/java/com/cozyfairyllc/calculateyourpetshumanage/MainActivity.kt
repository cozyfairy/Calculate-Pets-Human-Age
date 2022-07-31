package com.cozyfairyllc.calculateyourpetshumanage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

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
class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    var species : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spinner: Spinner = findViewById(R.id.pet_spinner)
        ArrayAdapter.createFromResource(this, R.array.pet_options, android.R.layout.simple_spinner_item).also {
            adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
            spinner.onItemSelectedListener = this

        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
        species = pos
        println("species: " + species)
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}
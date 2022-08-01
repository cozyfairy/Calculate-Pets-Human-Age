package com.cozyfairyllc.calculateyourpetshumanage

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.text.SimpleDateFormat
import java.util.*

/*
    TODO:
        DATEPICKER VIEW
            create date picker
            Pick date button
        HUMAN AGE
            textview for human age label
            human age value
            create function that calculates human age
        VALUES
            pick color scheme
            string resources

 */
class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener{
    private var species : Int = 0
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
        val dateBtn : Button = findViewById(R.id.dateBtn)
        dateBtn.setOnClickListener { showDatePicker() }




    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
        species = pos
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val year = calendar.get(Calendar.YEAR)
        DatePickerDialog(this, { _, year,
                                 month, day ->

                val selectedDate : TextView = findViewById(R.id.selectedDateValue)
                calendar.set(year, month, day)
                val date = SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH).format(calendar.time)
                updateTextView(selectedDate, date)
                val humanAgeTextView : TextView = findViewById(R.id.humanAgeResult)
                updateTextView(humanAgeTextView, HumanAge.convertAge(species, calendar.timeInMillis).toString())

            }, year, month, day).show()



    }

    private fun updateTextView(textView : TextView, text : String) {
        textView.text = text
    }








}
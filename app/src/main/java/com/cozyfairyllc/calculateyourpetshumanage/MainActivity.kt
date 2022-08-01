package com.cozyfairyllc.calculateyourpetshumanage

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit


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
    private var age : Int = 0
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
                calculateYears(calendar.timeInMillis)

            }, year, month, day).show()



    }

    private fun updateHumanAge(species : Int, dob : Long) {
        var humanAge = when(species){
            0 ->  3 * calculateYears(dob)
            1 -> calculateCatsHumanAge(dob)
            2 -> calculateDogsAge(dob)
            3 -> TODO()
            4 -> TODO()
            5 -> TODO()
            6 -> TODO()
            7 -> TODO()
            8 -> TODO()
            9 -> TODO()
            10 -> TODO()
            11 -> TODO()
            12 -> TODO()
            13 -> TODO()
            14 -> TODO()
            15 -> TODO()
            else -> 0
        }
        //updateTextView()
    }

    private fun updateTextView(textView : TextView, text : String) {
        textView.text = text
    }

    private fun calculateYears(dob : Long) :Int{
        val currentTime = System.currentTimeMillis()
        val elapsedTime = currentTime - dob
        return (TimeUnit.MILLISECONDS.toDays(elapsedTime) / 365).toInt()
    }
    private fun calculateMonths(dob: Long) : Int{
        val currentTime = System.currentTimeMillis()
        val elapsedTime = currentTime - dob
        return (TimeUnit.MILLISECONDS.toDays(elapsedTime) / 30).toInt()
    }
    private fun calculateCatsHumanAge(dob : Long) : Int {
        val years = calculateYears(dob)
        val months = calculateMonths(dob)
        val humanAge: Int = if (years >= 11) {
            60 + ((years - 11) * 4)
        } else if (years >= 3) {
            28 + ((years - 3) * 4)
        } else if (years >= 2) {
            24
        } else if (months >= 18) {
            21
        } else if (years >= 1) {
            15
        } else if (months >= 5) {
            10
        }
        else if (months >= 3) {
            4
        }
        else {
            1
        }
        return humanAge
    }

    private fun calculateDogsAge(dob : Long) : Int {
        val years = calculateYears(dob)
        var humanAge = 0
        if (years >= 1) humanAge += 15
        if (years >= 2) humanAge += 9
        if (years >= 3) humanAge += (humanAge - 2) * 5
        return humanAge
    }



}
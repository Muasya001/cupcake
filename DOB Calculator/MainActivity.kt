package com.example.dobcalc

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private var tvSelectedDate: TextView? = null
    private var tvAgeMinutes: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker = findViewById<Button>(R.id.btnDatePicker)
        tvSelectedDate = findViewById(R.id.tvSelectedDate)
        tvAgeMinutes = findViewById(R.id.tvAgeMinutes)

        btnDatePicker.setOnClickListener {
            clickDatePicker()
        }
    }

    private fun clickDatePicker() {

        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(this,
            {_, selectedYear, selectedMonth, selectedDayOfMonth ->
//                Toast.makeText(this, "date selected", Toast.LENGTH_LONG).show()

                val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/${selectedYear}"
//                val selectedDate = "${selectedMonth+1}/$selectedDayOfMonth/${selectedYear}"
                tvSelectedDate?.text = selectedDate

                //Creating object of simple date format
                //SimpleDateFormat: a concrete class for formatting and parsing dates in a locale-sensitive manner.
                //A Locale object represents a specific geographical, political, or cultural region.
                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
//                val sdf = SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH)


                //Creating actual date format from sdf
                //Parses text from a string to produce a Date object.
                val theDate = sdf.parse(selectedDate)

                theDate?.let {
                    //Date.getTime() -> time: converts given date into minutes from jan 1, 1970 00:00:00 GMT
                    val selectedDateInMinutes = theDate.time / 60000

                    //sdf.format Formats the given Date into a date/time string and appends the result to the given StringBuffer.
                    //System.currentTimeMillis() converts system time into minutes from jan 1, 1970 00:00:00 GMT
                    val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

                    currentDate?.let {
                        val currentDateInMinutes = currentDate.time / 60000
                        val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes
                        tvAgeMinutes?.text = differenceInMinutes.toString()
                    }
                }

            }, year, month, day
            )

        dpd.datePicker.maxDate = System.currentTimeMillis()
        dpd.show()

//        Toast.makeText(this, "btnDatePicker pressed", Toast.LENGTH_LONG).show()

    }
}
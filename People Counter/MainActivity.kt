package com.example.peoplecounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clickMe = findViewById<Button>(R.id.btnClickMe)
        val peopleCountTxt = findViewById<TextView>(R.id.txtView)
        var peopleCount = 0
        clickMe.setOnClickListener {
            peopleCount += 1
            peopleCountTxt.text = peopleCount.toString()
        }
    }


}
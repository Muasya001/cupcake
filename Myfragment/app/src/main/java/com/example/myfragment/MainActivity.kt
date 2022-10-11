package com.example.myfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val btnFrag1 = findViewById<Button>(R.id.btnFrag1)
        val btnFrag2 = findViewById<Button>(R.id.btnFrag2)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFrag, firstFragment)
            addToBackStack(null)
            commit()
        }

        btnFrag1.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFrag, firstFragment)
                addToBackStack(null)
                commit()
            }
        }

        btnFrag2.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFrag, secondFragment)
                commit()
            }
        }

    }
}
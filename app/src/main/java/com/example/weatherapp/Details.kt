package com.example.weatherapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val temperatures = intent.getDoubleArrayExtra("temperatures") ?: doubleArrayOf()

        val details = StringBuilder()
        for (i in temperatures.indices) {
            details.append("Day ${i + 1}: ${temperatures[i]}°C\n")
        }

     //   tvDetails.text = details.toString()

       // btnBack.setOnClickListener {
            finish()
        }
    }


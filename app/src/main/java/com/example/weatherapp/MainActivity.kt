package com.example.weatherapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    @SuppressLint("CutPasteId", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnAddTemperature = findViewById<Button>(R.id.btnAddTemp)
        val btnViewDetails = findViewById<Button>(R.id.btnViewDet)
        val btnCalculateAverage = findViewById<Button>(R.id.btnCalculcAve)
        val tvAverageTemperature = findViewById<TextView>(R.id.tvAveTemp)
        val btnClearData = findViewById<Button>(R.id.tvAveTemp)
        val btnExit = findViewById<Button>(R.id.btnExit)
        val etTemperature = findViewById<TextView>(R.id.etTemp)
        val temperatures = DoubleArray(7)
        var currentIndex = 0


        btnAddTemperature.setOnClickListener {
            val temp = etTemperature.text.toString().toDouble()
            if (currentIndex < 7) {
                temperatures[currentIndex] = temp
                currentIndex++
                etTemperature.text.clear()
            }
        }

        btnCalculateAverage.setOnClickListener {
            val average = temperatures.average()
            tvAverageTemperature.text = "Average Temperature: $average"
        }

        btnViewDetails.setOnClickListener {
// create the explicit intent
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("temperatures", temperatures)

        }

        btnClearData.setOnClickListener {
            currentIndex = 0
            temperatures.fill(0.0)
            tvAverageTemperature.text = ""
            etTemperature.text.clear()
        }

        btnExit.setOnClickListener {
            finish()
        }
    }
}

private fun CharSequence.clear() {
    TODO("Not yet implemented")
}




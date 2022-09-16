package com.example.androidkotlinstudyguided

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.androidkotlinstudyguided.model.Car
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var textdataChange: TextView
    private lateinit var btnDataChange: Button
    private lateinit var nextGuide: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle("Data Change")

        textdataChange = findViewById(R.id.textdataChange)
        btnDataChange = findViewById(R.id.btnDataChange)
        nextGuide = findViewById(R.id.nextGuide)

        var flag = true
        btnDataChange.setOnClickListener {
            if(flag) {
                textdataChange.setText("Hello world")
            } else {
                textdataChange.setText("Hello world again")
            }
            flag = !flag
        }

        nextGuide.setOnClickListener {
            var intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("passedData", "DATA PASSED")
            startActivity(intent)
        }
    }
}
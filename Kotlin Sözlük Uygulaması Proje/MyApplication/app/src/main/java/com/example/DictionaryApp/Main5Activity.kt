package com.example.DictionaryApp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity



class Main5Activity : AppCompatActivity() {

    lateinit var rBar: RatingBar
    lateinit var button14: Button
    lateinit var button9: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        button14 = findViewById(R.id.button14)

        button9 = findViewById(R.id.button9)
        button9.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        rBar = findViewById(R.id.rBar)
        val rBar = RatingBar(this)
        rBar.stepSize = 1.0.toFloat()
        rBar.numStars = 5
        button14.setOnClickListener {
            val msg = rBar.rating.toString()
            Toast.makeText(
                this@Main5Activity, "Puanınız: $msg",
                Toast.LENGTH_SHORT
            ).show()


        }

    }

}

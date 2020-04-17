package com.example.DictionaryApp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*


class Main2Activity : AppCompatActivity() {
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button6: Button
    private lateinit var button13: Button
    private lateinit var checkBox: CheckBox
    private lateinit var textView3: TextView
    private lateinit var hosgel: TextView

    var hosgeldin = "hoşgeldiniz "


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val extras = intent.extras
        val value = extras?.getString("gonderilen", hosgeldin)

        hosgeldiniz.run {
            setText(hosgeldin + value)
        }


        textView3 = findViewById(R.id.textView3)
        checkBox = findViewById(R.id.checkBox)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button6 = findViewById(R.id.button6)
        button13 = findViewById(R.id.button13)
        hosgel = findViewById(R.id.hosgeldiniz)





        button2.setOnClickListener {
            val intent = Intent(this, Main3Activity::class.java)
            startActivity(intent)
        }


        button3.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        button13.setOnClickListener {
            val intent = Intent(this, Main7Activity::class.java)
            startActivity(intent)
        }

        button6.setOnClickListener {
            val intent = Intent(this, Main6Activity::class.java)
            startActivity(intent)
        }


    }

    fun check(cv: View) {

        var durum: Boolean = checkBox.isChecked
        if (durum == true) {
            button13.isEnabled = true
            button2.isEnabled = true
            button6.isEnabled = true
        } else {
            button13.isEnabled = false
            button2.isEnabled = false
            button6.isEnabled = false
        }



    }


}





package com.example.DictionaryApp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Main3Activity : AppCompatActivity() {
    lateinit var sayfa : Button
    lateinit var sayfa2: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        sayfa = findViewById(R.id.sayfa)

            sayfa.setOnClickListener{
            val intent = Intent(this, Main4Activity::class.java)
            startActivity(intent)
        }

        sayfa2 = findViewById(R.id.sayfa2)
        sayfa2.setOnClickListener{
            val intent = Intent(this, Main2Activity::class.java)
            startActivity(intent)
        }




    }

}

package com.example.DictionaryApp

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var editText : EditText
    lateinit var button : Button
    lateinit var button10: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        button = findViewById(R.id.button)
        button10 = findViewById(R.id.button10)

        button.setOnClickListener{
            val intent = Intent(this,Main2Activity::class.java)
            intent.putExtra("gonderilen",editText.text.toString())
            startActivity(intent)



            @Suppress("UNUSED_VARIABLE")
            var msg = button.toString()
            Toast.makeText(this@MainActivity, "2.sayfaya geçtiniz",
            Toast.LENGTH_SHORT).show()
        }

        button10.setOnClickListener {
            val intent = Intent(this, Main5Activity::class.java)
            startActivity(intent)
        }
    }


     override fun  onBackPressed() {

        val builder = AlertDialog.Builder(this)
        builder.setMessage("Çıkmak İstiyormusunuz ?")
        builder.setCancelable(true)
        builder.setNegativeButton("Hayır", DialogInterface.OnClickListener{ DialogInterface, A ->
        DialogInterface.cancel() })

        builder.setPositiveButton("Evet", DialogInterface.OnClickListener{ DialogInterface, A ->
            finish()
        })

        val alertDialog = builder.create()
        alertDialog.show()

        Toast.makeText(applicationContext, "Çık", Toast.LENGTH_LONG).show()
    }






}
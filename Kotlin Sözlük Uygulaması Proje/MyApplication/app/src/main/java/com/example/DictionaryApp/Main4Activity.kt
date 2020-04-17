package com.example.DictionaryApp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader


class Main4Activity : AppCompatActivity() {

    lateinit var button11: Button
    lateinit var button12: Button
    lateinit var edt: EditText
    lateinit var notkaydet: EditText
    lateinit var kaydet: Button
    lateinit var goruntu: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        edt = findViewById(R.id.edt)
        notkaydet = findViewById(R.id.notgetir)
        kaydet = findViewById(R.id.kaydet)
        goruntu = findViewById(R.id.kaydigetir)

        //kayıt butonuna tıklandığında edittext(notkaydet)'e girilen veriler notkaydet(edittext)'e kaydedilir.
        kaydet.setOnClickListener{

            //dosya adı ve notların tanımmlanması
           val file = edt.text.toString()
            val data = notkaydet.text.toString()

            val fileOutputStream: FileOutputStream

            try {
                //tanımlanan file ve data içerisine yazma işlemi
                fileOutputStream = openFileOutput(file, Context.MODE_PRIVATE)
                fileOutputStream.write(data.toByteArray())
            }
            catch (e: Exception){
                e.printStackTrace()

            }
            catch (e: Exception){
                e.printStackTrace()
            }
             showToast ("kaydedildi")


        }

        //kaydedilen notları getirme
        goruntu.setOnClickListener{
            //file içerisine yazılanları geri getiriyor.
        val filename = edt.text.toString()

            if (filename.toString() !=null && filename.trim() !=""){

                //bufferedreader ile okuyor. fileınputstream ile dosyaya ulaşıyor.
                var fileInputStream: FileInputStream? = null
                fileInputStream = openFileInput (filename)
                var inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
                val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)

                val stringBuilder: StringBuilder = StringBuilder()
                var text: String? = null

                 //dosya içerisindeki kelime kelime okur.
                while ({text = bufferedReader.readLine(); text}() !=null){
                     //stringbuilder nesnesi ile birden fazla String kullanılabilir. append ile text değiskenine ekler.
                    stringBuilder.append(text)
                }

                //edittext'e girilen notları gösteriyoruz
                notkaydet.setText(stringBuilder.toString()).toString()

            }else
                showToast("dosya adı boş bırakılamaz.")

        }




        button11 = findViewById(R.id.button11)
        button11.setOnClickListener {
            val intent = Intent(this, Main3Activity::class.java)
            startActivity(intent)
        }

        button12 = findViewById(R.id.button12)
        button12.setOnClickListener {
            val intent = Intent(this, Main6Activity::class.java)
            startActivity(intent)
        }





    }

    //Toast mesajını fonksiyon olarak tanımlıyoruz. Böylece birden çok kullanılabilir.
    fun Context.showToast (text: CharSequence, duration: Int = Toast.LENGTH_SHORT){
        Toast.makeText(this, text, duration).show()
    }
}






























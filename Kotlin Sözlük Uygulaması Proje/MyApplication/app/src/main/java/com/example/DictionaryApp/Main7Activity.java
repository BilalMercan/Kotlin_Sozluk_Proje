package com.example.DictionaryApp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;
import java.util.Scanner;

public class Main7Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
    }


    public void ara(View view) {
        EditText word = (EditText) findViewById(R.id.word);
        String theword = word.getText().toString();

        //kelimelerin dosyadaki karşılığını buluyoruz.

    String defination = findDefention(theword);

        TextView thedef = (TextView) findViewById(R.id.def);

        if (defination !=null)
            thedef.setText(defination);
        else
            thedef.setText("kelime bulunamadı");

    }

    private String findDefention (String theword){

        //raw kaynağındaki dosyayı input stream değişkenine bağlıyoruz.
        InputStream input = getResources().openRawResource(R.raw.entr);

        //scanner objesini input değişkenine atıyoruz.
        Scanner scan = new Scanner(input);

        //satırı okuma işlemi
        while (scan.hasNext())
        {
            String line = scan.nextLine();

            String[] pleces = line.split(";");

            if (pleces[0].equalsIgnoreCase(theword.trim())){

                return pleces[1];
            }

        }
        return null;
    }

    public void sayfa(View view) {
        Intent intent = new Intent(getApplicationContext(), Main6Activity.class);
        startActivity(intent);
    }
}

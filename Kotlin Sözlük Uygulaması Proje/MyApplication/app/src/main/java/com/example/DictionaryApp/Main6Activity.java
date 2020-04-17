package com.example.DictionaryApp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;
import java.util.Scanner;

public class Main6Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
    }

    public void arama(View view) {
        EditText trword = (EditText) findViewById(R.id.trkelime);
        String theword = trword.getText().toString();

        String defination = findDefention(theword);

        TextView thedefi = (TextView) findViewById(R.id.trview);

        if (defination !=null)
            thedefi.setText(defination);
        else
            thedefi.setText("kelime bulunamadı");

    }

    private String findDefention (String theword){
        InputStream input = getResources().openRawResource(R.raw.trenword);
        Scanner scaan = new Scanner(input);

        while (scaan.hasNext())
        {
            String line = scaan.nextLine();

            String[] plece = line.split(";");

            if (plece[0].equalsIgnoreCase(theword.trim())){

                return plece[1];
            }

        }
        return null;
    }

    public void yedi(View view) {
        Intent intent = new Intent(getApplicationContext(), Main7Activity.class);
        startActivity(intent);
    }

    public void bes(View view) {
        Intent intent = new Intent(getApplicationContext(), Main4Activity.class);
        startActivity(intent);
    }
}

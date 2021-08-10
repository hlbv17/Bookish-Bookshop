package com.example.bookishbookshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SignUp extends AppCompatActivity {
    //private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_sign_up);

        //Spinner spinner;

        /*spinner = findViewById(R.id.spinner);
        String []opciones={"Seleccione","Cédula","Pasaporte"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, opciones);
        spinner.setAdapter(adapter);*/



    }
}

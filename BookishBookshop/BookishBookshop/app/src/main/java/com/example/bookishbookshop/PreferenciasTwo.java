package com.example.bookishbookshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class PreferenciasTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_preferencias_dos);

        LinearLayout botonOmitir = findViewById(R.id.btnOmitir);
        LinearLayout botonSiguiente = findViewById(R.id.btnSiguiente);

        botonOmitir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MainScreen.class);
                startActivityForResult(intent, 0);
            }
        });

        botonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MainScreen.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}

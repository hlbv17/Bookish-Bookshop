package com.example.bookishbookshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getSupportActionBar().hide();
        Button Menu = findViewById(R.id.btnMenu);
        LinearLayout Tarjeta = findViewById(R.id.btnTarjeta);
        LinearLayout Perfil = findViewById(R.id.btnPerfil);
        LinearLayout Deseos = findViewById(R.id.btnDeseos);
        LinearLayout Compra = findViewById(R.id.btnCompra);
        LinearLayout Categorias = findViewById(R.id.btnCategorias);
        LinearLayout Sugerencias = findViewById(R.id.btnSugerencias);
        LinearLayout Frases = findViewById(R.id.btnFrases);
        LinearLayout Qr = findViewById(R.id.btnQr);

        Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MainScreen.class);
                startActivityForResult(intent, 0);
            }
        });

        Tarjeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MetodoPago.class);
                startActivityForResult(intent, 0);
            }
        });

        Perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Proximamente.class);
                startActivityForResult(intent, 0);
            }
        });

        Compra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Proximamente.class);
                startActivityForResult(intent, 0);
            }
        });

        Deseos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Proximamente.class);
                startActivityForResult(intent, 0);
            }
        });

        Sugerencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Proximamente.class);
                startActivityForResult(intent, 0);
            }
        });

        Categorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Proximamente.class);
                startActivityForResult(intent, 0);
            }
        });

        Frases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Proximamente.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}

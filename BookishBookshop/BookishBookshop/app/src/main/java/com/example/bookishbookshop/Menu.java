package com.example.bookishbookshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class Menu extends AppCompatActivity {

    Button Menu;
    ConstraintLayout Tarjeta, Perfil, Deseos, Compra, Categorias, Sugerencias, Frases, Qr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getSupportActionBar().hide();

        Menu = findViewById(R.id.btnMenu);
        Tarjeta = findViewById(R.id.btnTarjeta);
        Perfil = findViewById(R.id.btnPerfil);
        Deseos = findViewById(R.id.btnDeseos);
        Compra = findViewById(R.id.btnCompra);
        Categorias = findViewById(R.id.btnCategorias);
        Sugerencias = findViewById(R.id.btnSugerencias);
        Frases = findViewById(R.id.btnFrases);
        Qr = findViewById(R.id.btnQr);

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

        Qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getPackageManager().getLaunchIntentForPackage("com.UGLibro.QR");
                startActivity(intent);
            }
        });
    }
}

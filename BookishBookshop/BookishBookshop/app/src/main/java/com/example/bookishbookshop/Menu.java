package com.example.bookishbookshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class Menu extends AppCompatActivity {

    ImageButton Menu;
    ConstraintLayout Tarjeta, Perfil, Deseos, Compra, Categorias, Sugerencias, Frases, Qr;

    /*
     * ---AutFit Variables-------------------------------------------------------------------------*/
    private int dpWidth, dpHeight, designWidth = 360,  desighHeiht = 780;
    private float dDensity;


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
                finish();
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
                Intent intent = getPackageManager().getLaunchIntentForPackage("com.DefaultCompany.Prueba");
                startActivity(intent);
            }
        });

        /*
         * ---AutoFit------------------------------------------------------------------------------*/
        int buttonsX = 70, buttonsY = 80, constraintLayoutX = 150, constraintLayoutY = 132;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        dpWidth = (displayMetrics.widthPixels);
        dpHeight = (displayMetrics.heightPixels);
        dDensity = (displayMetrics.scaledDensity);
        // Button: Home
        ViewGroup.LayoutParams btnHomeP = (ViewGroup.MarginLayoutParams) Menu.getLayoutParams();
        btnHomeP.width = calWidth(buttonsX);
        btnHomeP.height = calHeight(buttonsY);
        // ConstraintLayout: Perfil
        ViewGroup.LayoutParams btnPerfilP = (ViewGroup.MarginLayoutParams) Perfil.getLayoutParams();
        btnPerfilP.width = calWidth(constraintLayoutX);
        btnPerfilP.height = calHeight(constraintLayoutY);
        // ConstraintLayout: Tarjeta
        ViewGroup.LayoutParams btnTarjetaP = (ViewGroup.MarginLayoutParams) Tarjeta.getLayoutParams();
        btnTarjetaP.width = calWidth(constraintLayoutX);
        btnTarjetaP.height = calHeight(constraintLayoutY);
        // ConstraintLayout: Compra
        ViewGroup.LayoutParams btnCompraP = (ViewGroup.MarginLayoutParams) Compra.getLayoutParams();
        btnCompraP.width = calWidth(constraintLayoutX);
        btnCompraP.height = calHeight(constraintLayoutY);
        // ConstraintLayout: Qr
        ViewGroup.LayoutParams btnQrP = (ViewGroup.MarginLayoutParams) Qr.getLayoutParams();
        btnQrP.width = calWidth(constraintLayoutX);
        btnQrP.height = calHeight(constraintLayoutY);
        // ConstraintLayout: Frases
        ViewGroup.LayoutParams btnFrasesP = (ViewGroup.MarginLayoutParams) Frases.getLayoutParams();
        btnFrasesP.width = calWidth(constraintLayoutX);
        btnFrasesP.height = calHeight(constraintLayoutY);
        // ConstraintLayout: Categorias
        ViewGroup.LayoutParams btnCategoriasP = (ViewGroup.MarginLayoutParams) Categorias.getLayoutParams();
        btnCategoriasP.width = calWidth(constraintLayoutX);
        btnCategoriasP.height = calHeight(constraintLayoutY);
        // ConstraintLayout: Sugerencias
        ViewGroup.LayoutParams btnSugerenciasP = (ViewGroup.MarginLayoutParams) Sugerencias.getLayoutParams();
        btnSugerenciasP.width = calWidth(constraintLayoutX);
        btnSugerenciasP.height = calHeight(constraintLayoutY);
        // ConstraintLayout: Sugerencias
        ViewGroup.LayoutParams btnDeseosP = (ViewGroup.MarginLayoutParams) Deseos.getLayoutParams();
        btnDeseosP.width = calWidth(constraintLayoutX);
        btnDeseosP.height = calHeight(constraintLayoutY);


    }

    /*
     * ---Methods: AtuoFit------------------------------------------------------------------------*/
    // Method: calHeight
    public int calHeight (float value) {
        return (int) (dpHeight * (value/desighHeiht));
    }
    // Method: calWidth
    public int calWidth (float value) {
        return (int) (dpWidth * (value/designWidth));
    }

}

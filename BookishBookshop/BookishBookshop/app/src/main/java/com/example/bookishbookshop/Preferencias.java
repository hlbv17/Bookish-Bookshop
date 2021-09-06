package com.example.bookishbookshop;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class Preferencias extends AppCompatActivity {

    /*
     * ---Variables--------------------------------------------------------------------------------*/
    ImageView logo;
    ScrollView scrvP1;
    ConstraintLayout botonOmitir,botonSiguiente;

    /*
     * ---AutoFit Variables-----------------------------------------------------------------------*/
    private int dpWidth, dpHeight, designWidth = 360,  desighHeiht = 780;
    private float dDensity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_preferencias);

        /*
         * ---Asignar Variables-------------------------------------------------------------------*/
        logo = findViewById(R.id.iv_Logo_Preferences1);
        scrvP1 = findViewById(R.id.scrollView_Preferences1);
        botonOmitir = findViewById(R.id.btnOmitir);
        botonSiguiente = findViewById(R.id.btnSiguiente);

        botonOmitir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), PreferenciasTwo.class);
                startActivityForResult(intent, 0);
            }
        });

        botonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), PreferenciasTwo.class);
                startActivityForResult(intent, 0);
            }
        });

        /*
         * ---AutoFit-----------------------------------------------------------------------------*/
        int buttonsX = 130, buttonsY = 60, edittextX = 300, edittextY = 70;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        dpWidth = (displayMetrics.widthPixels);
        dpHeight = (displayMetrics.heightPixels);
        dDensity = (displayMetrics.scaledDensity);
        // Imageview: Logo
        ViewGroup.LayoutParams logoP = (ViewGroup.MarginLayoutParams) logo.getLayoutParams();
        logoP.height = calHeight(120);
        // ScrollView: scrollView_Preferences1
        ViewGroup.LayoutParams scrvP1P = (ViewGroup.MarginLayoutParams) scrvP1.getLayoutParams();
        scrvP1P.height = calHeight(608);
        // ConstraintLayout: Cancelar
        ViewGroup.LayoutParams btnOmitirP = (ViewGroup.MarginLayoutParams) botonOmitir.getLayoutParams();
        btnOmitirP.width = calWidth(buttonsX);
        btnOmitirP.height = calHeight(buttonsY);
        // ConstraintLayout: Siguiente
        ViewGroup.LayoutParams btnSiguienteP = (ViewGroup.MarginLayoutParams) botonSiguiente.getLayoutParams();
        btnSiguienteP.width = calWidth(buttonsX);
        btnSiguienteP.height = calHeight(buttonsY);

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

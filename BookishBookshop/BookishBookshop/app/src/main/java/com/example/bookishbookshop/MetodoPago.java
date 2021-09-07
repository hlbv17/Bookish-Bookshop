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

public class MetodoPago extends AppCompatActivity {

    /*
     * ---Variables--------------------------------------------------------------------------------*/
    ImageView logo;
    ScrollView scrvP;
    ConstraintLayout botonGuardar;

    /*
     * ---AutoFit Variables-----------------------------------------------------------------------*/
    private int dpWidth, dpHeight, designWidth = 360,  desighHeiht = 780;
    private float dDensity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_metodo_pago);

        /*
         * ---Asignar Variables-------------------------------------------------------------------*/
        logo = findViewById(R.id.iv_Logo_Payment);
        scrvP = findViewById(R.id.scrollView_Payment);
        botonGuardar = findViewById(R.id.btnGuardar);

        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MainScreen.class);
                startActivity(intent);
                finish();
            }
        });

        /*
         * ---AutoFit-----------------------------------------------------------------------------*/
        int buttonsX = 150, buttonsY = 50, edittextX = 300, edittextY = 70;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        dpWidth = (displayMetrics.widthPixels);
        dpHeight = (displayMetrics.heightPixels);
        dDensity = (displayMetrics.scaledDensity);
        // Imageview: Logo
        ViewGroup.LayoutParams logoP = (ViewGroup.MarginLayoutParams) logo.getLayoutParams();
        logoP.height = calHeight(120);
        // ScrollView: scrollView_Payment
        ViewGroup.LayoutParams scrvP1P = (ViewGroup.MarginLayoutParams) scrvP.getLayoutParams();
        scrvP1P.height = calHeight(608);
        // ConstraintLayout: Guardar
        ViewGroup.LayoutParams btnOmitirP = (ViewGroup.MarginLayoutParams) botonGuardar.getLayoutParams();
        btnOmitirP.width = calWidth(buttonsX);
        btnOmitirP.height = calHeight(buttonsY);

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

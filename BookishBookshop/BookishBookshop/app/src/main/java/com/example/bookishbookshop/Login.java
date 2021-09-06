package com.example.bookishbookshop;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    ImageButton botonG,botonF,botonT;
    ConstraintLayout botonMail;
    TextView txt;
    ImageView logo;


    /*
     * ---Autofit Variables------------------------------------------------------------------------*/
    private int dpWidth, dpHeight, designWidth = 360,  desighHeiht = 780;
    private float dDensity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        logo = findViewById(R.id.iv_Logo_LogIn);
        botonG = findViewById(R.id.btnGoogle);
        botonF = findViewById(R.id.btnFb);
        botonT = findViewById(R.id.btnTwt);
        botonMail = findViewById(R.id.btnCorreo);
        txt = findViewById(R.id.txtRegistrar);;

        botonG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MainScreen.class);
                startActivityForResult(intent, 0);
            }
        });

        botonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MainScreen.class);
                startActivityForResult(intent, 0);
            }
        });

        botonT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MainScreen.class);
                startActivityForResult(intent, 0);
            }
        });

        botonMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), SignIn.class);
                startActivityForResult(intent, 0);
            }
        });

        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), SignUp.class);
                startActivityForResult(intent, 0);
            }
        });

        /*
         * ---AutoFit------------------------------------------------------------------------------*/
        int buttonsX = 70, buttonsY = 80;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        dpWidth = (displayMetrics.widthPixels);
        dpHeight = (displayMetrics.heightPixels);
        dDensity = (displayMetrics.scaledDensity);
        // Imageview: Logo
        ViewGroup.LayoutParams logoP = (ViewGroup.MarginLayoutParams) logo.getLayoutParams();
        logoP.height = calHeight(158);
        // Button: Google
        ViewGroup.LayoutParams btnGoogleP = (ViewGroup.MarginLayoutParams) botonG.getLayoutParams();
        btnGoogleP.width = calWidth(buttonsX);
        btnGoogleP.height = calHeight(buttonsY);
        // Button: Facebook
        ViewGroup.LayoutParams btnFacebookP = (ViewGroup.MarginLayoutParams) botonF.getLayoutParams();
        btnFacebookP.width = calWidth(buttonsX);
        btnFacebookP.height = calHeight(buttonsY);
        // Button: Twitter
        ViewGroup.LayoutParams btnTwitterP = (ViewGroup.MarginLayoutParams) botonT.getLayoutParams();
        btnTwitterP.width = calWidth(buttonsX);
        btnTwitterP.height = calHeight(buttonsY);
        // Button: Continuar con Correo
        ViewGroup.LayoutParams btnCorreoP = (ViewGroup.MarginLayoutParams) botonMail.getLayoutParams();
        btnCorreoP.width = calWidth(250);
        btnCorreoP.height = calHeight(buttonsY);

    }

    /*
     * ---Method: AutoFit-------------------------------------------------------------------------*/
    // Method: calHeight
    public int calHeight (float value) {
        return (int) (dpHeight * (value/desighHeiht));
    }
    // Method: calWidth
    public int calWidth (float value) {
        return (int) (dpWidth * (value/designWidth));
    }

}

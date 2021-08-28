package com.example.bookishbookshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        Button botonG = findViewById(R.id.btnGoogle);
        Button botonF = findViewById(R.id.btnFb);
        Button botonT = findViewById(R.id.btnTwt);
        LinearLayout botonMail = findViewById(R.id.btnCorreo);
        TextView txt = findViewById(R.id.txtRegistrar);;

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
    }
}

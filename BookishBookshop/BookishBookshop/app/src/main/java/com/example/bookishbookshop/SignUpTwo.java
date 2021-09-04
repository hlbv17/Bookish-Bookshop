package com.example.bookishbookshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class SignUpTwo extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_dos);
        getSupportActionBar().hide();

        LinearLayout btnAnterior = findViewById(R.id.btnAnterior);
        LinearLayout btnCrear = findViewById(R.id.btnCrear);

        btnAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), SignUp.class);
                startActivityForResult(intent, 0);
            }
        });

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), ExitoRegistro.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}

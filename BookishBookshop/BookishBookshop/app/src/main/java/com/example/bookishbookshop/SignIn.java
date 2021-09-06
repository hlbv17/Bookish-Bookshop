package com.example.bookishbookshop;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SignIn extends AppCompatActivity {

    /*
     * ---Variables--------------------------------------------------------------------------------*/
    ImageView logo;
    EditText edtxCorreo, edtxContrasena;
    TextView txtvCorreoR, txtvContrasenaR;
    ConstraintLayout botonIniciar;

    /*
     * ---Autofit Variables------------------------------------------------------------------------*/
    private int dpWidth, dpHeight, designWidth = 360,  desighHeiht = 780;
    private float dDensity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getSupportActionBar().hide();

        /*
         * ---Asignar Variables--------------------------------------------------------------------*/
        logo = findViewById(R.id.iv_Logo_SignIn);
        edtxCorreo = findViewById(R.id.edtx_Correo_SignIn);
        txtvCorreoR = findViewById(R.id.txtv_Correo_SignIn_Error);
        edtxContrasena = findViewById(R.id.edtx_Contrasena_SignIn);
        txtvContrasenaR = findViewById(R.id.txtv_Contrasena_SignIn_Error);
        botonIniciar = findViewById(R.id.btnIniciar);

        /*
         * ---Listener----------------------------------------------------------------------------*/
        // EditText Correo: normal background && clear error
        edtxCorreo.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                edtxCorreo.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.registro_campos));
                txtvCorreoR.setText(null);
                return false;
            }
        });
        // EditText Contrasena: normal background && clear error
        edtxContrasena.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                edtxContrasena.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.registro_campos));
                txtvContrasenaR.setText(null);
                return false;
            }
        });

        /*
         * ---Buttons------------------------------------------------------------------------------*/
        // Button SignIn:
        botonIniciar.setOnClickListener(new View.OnClickListener() { // Press Google button, open activity Menu
            @Override
            public void onClick(View view) {
                if (esCorrecto () == true) {
                    Intent newactivity = new Intent(SignIn.this,MainScreen.class);
                    startActivity (newactivity);
                }
            }
        });

        /*
         * ---AutoFit-----------------------------------------------------------------------------*/
        int buttonsX = 210, buttonsY = 70, edittextX = 300, edittextY = 70;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        dpWidth = (displayMetrics.widthPixels);
        dpHeight = (displayMetrics.heightPixels);
        dDensity = (displayMetrics.scaledDensity);
        // Imageview: Logo
        ViewGroup.LayoutParams logoP = (ViewGroup.MarginLayoutParams) logo.getLayoutParams();
        logoP.height = calHeight(120);
        /*
        // EditText: Correo
        ViewGroup.LayoutParams edtxCorreoP = (ViewGroup.MarginLayoutParams) edtxCorreo.getLayoutParams();
        edtxCorreoP.width = calWidth(edittextX);
        edtxCorreoP.height = calHeight(edittextY);
        // EditText: Contrasena
        ViewGroup.LayoutParams edtxContrasenaP = (ViewGroup.MarginLayoutParams) edtxContrasena.getLayoutParams();
        edtxContrasenaP.width = calWidth(edittextX);
        edtxContrasenaP.height = calHeight(edittextY);
        */
        // Constrain: Inciar Sesión
        ViewGroup.LayoutParams SignInP = (ViewGroup.MarginLayoutParams) botonIniciar.getLayoutParams();
        SignInP.width = calWidth(buttonsX);
        SignInP.height = calHeight(buttonsY);

    }

    /*
     * ---Methods---------------------------------------------------------------------------------*/
    // Method: esCorrecto
    private boolean esCorrecto () {
        boolean output = true;
        // EditText Correo: error
        if (edtxCorreo.length() == 0) {
            //edtxCorreo.setError("Campo obligatorio.");
            edtxCorreo.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.registro_campos_error));
            txtvCorreoR.setText("Campo obligatorio.");
            output = false;
        } else if (!(Patterns.EMAIL_ADDRESS.matcher(edtxCorreo.getText().toString())).matches()) {
            //edtxCorreo.setError("Correo no valido.");
            edtxCorreo.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.registro_campos_error));
            txtvCorreoR.setText("Correo no valido.");
            output = false;
        }
        // EditText Contrasena: error
        if (edtxContrasena.length() == 0) {
            //edtxPassword.setError("Campo obligatorio.");
            edtxContrasena.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.registro_campos_error));
            txtvContrasenaR.setText("Campo obligatorio.");
            output = false;
        } else if (edtxContrasena.length() < 8) {
            //edtxPassword.setError("Contraseña debe tener 8 caracteres minimo.");
            edtxContrasena.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.registro_campos_error));
            txtvContrasenaR.setText("Contraseña debe tener 8 caracteres minimo.");
            output = false;
        }
        return output;
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

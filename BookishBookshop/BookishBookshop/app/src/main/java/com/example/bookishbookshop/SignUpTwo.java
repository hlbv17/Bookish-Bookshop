package com.example.bookishbookshop;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpTwo extends AppCompatActivity {

    // Variables
    Spinner spnrEStadoCivil;
    TextView txtvEstadoCivilR, txtvCelularR, txtvDireccionR, txtvContrasenaR,txtvContrasenaCR;
    EditText edtxCelular, edtxDireccion, edtxContrasena, edtxContrasenaC;
    CheckBox ckbTerminos, ckNoticias;
    ConstraintLayout btnAnterior, btnCrear;
    private boolean isFirstTime = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_dos);
        getSupportActionBar().hide();

        // Asign Variables
        spnrEStadoCivil = findViewById(R.id.spnr_EstadoCivil);
        txtvEstadoCivilR = findViewById(R.id.txtv_EstadoCivil_Error);
        edtxCelular = findViewById(R.id.edtx_Celular);
        txtvCelularR = findViewById(R.id.txtv_Celular_Error);
        edtxDireccion = findViewById(R.id.edtx_Direccion);
        txtvDireccionR = findViewById(R.id.txtv_Direccion_Error);
        edtxContrasena = findViewById(R.id.edtx_Contrasena);
        txtvContrasenaR = findViewById(R.id.txtv_Contrasena_Error);
        edtxContrasenaC = findViewById(R.id.edtx_ContrasenaC);
        txtvContrasenaCR = findViewById(R.id.txtv_ContrasenaC_Error);
        ckbTerminos = findViewById(R.id.ckb_Terminos);
        ckNoticias = findViewById(R.id.ckb_Noticias);
        btnAnterior = findViewById(R.id.btnAnterior);
        btnCrear = findViewById(R.id.btnCrear);

        // max length input
        edtxCelular.setFilters (new InputFilter[]{new InputFilter.LengthFilter (13)});

        /*
         * ---Listeners----------------------------------------------------------------------------*/

        // Spinner EstadoCivil: normal background && clear error
        spnrEStadoCivil.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (isFirstTime) {
                    isFirstTime = false;
                } else if (!spnrEStadoCivil.getSelectedItem().toString().equals("Seleccione")) {
                    spnrEStadoCivil.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.registro_campos));
                    txtvEstadoCivilR.setText(null);
                } else {
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // EditText Celular: normal background && clear error
        edtxCelular.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                edtxCelular.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.registro_campos));
                txtvCelularR.setText(null);
                return false;
            }
        });

        // EditText Direccion: normal background && clear error
        edtxDireccion.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                edtxDireccion.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.registro_campos));
                txtvDireccionR.setText(null);
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

        // EditText ContrasenaC: normal background && clear error
        edtxContrasenaC.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                edtxContrasenaC.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.registro_campos));
                txtvContrasenaCR.setText(null);
                return false;
            }
        });





        /*
         * ---Buttons------------------------------------------------------------------------------*/
        // Button: Crear
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (esCorrecto () == true) {
                    Intent newactivity = new Intent(SignUpTwo.this,ExitoRegistro.class);
                    startActivity (newactivity);
                }
            }
        });

        // Button: Anterior
        btnAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newactivity = new Intent(SignUpTwo.this,SignUp.class);
                startActivity (newactivity);
            }
        });

    }

    // Method: esCorrecto
    private boolean esCorrecto() {
        boolean output = true;

        if (spnrEStadoCivil.getSelectedItem().toString().equals("Seleccione")) {
            //Toast.makeText (getApplicationContext(), "Seleccione Estado Civil.",Toast.LENGTH_SHORT).show();
            spnrEStadoCivil.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.registro_campos_error));
            txtvEstadoCivilR.setText("Seleccione Estado Civil.");
            output = false;
        }
        if (edtxCelular.length() == 0) {
            //edtxCelular.setError("Campo obligatorio.");
            edtxCelular.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.registro_campos_error));
            txtvCelularR.setText("Campo obligatorio.");
            output = false;
        } else if (edtxCelular.length() < 10) {
            //edtxCelular.setError("Número no valido.");
            edtxCelular.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.registro_campos_error));
            txtvCelularR.setText("Número no valido.");
            output = false;
        }
        if (edtxDireccion.getText().toString().trim().length() == 0) {
            //edtxDireccion.setError("Campo obligatorio.");
            edtxDireccion.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.registro_campos_error));
            txtvDireccionR.setText("Campo obligatorio.");
            output = false;
        }
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
        if (!edtxContrasenaC.getText().toString().equals(edtxContrasena.getText().toString())) {
            //edtxPasswordC.setError("Las contraseñas deben coincidir.");
            edtxContrasenaC.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.registro_campos_error));
            txtvContrasenaCR.setText("Las contraseñas deben coincidir.");
            output = false;
        } else if (edtxContrasenaC.length() == 0) {
            edtxContrasenaC.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.registro_campos_error));
            txtvContrasenaCR.setText("Campo obligatorio.");
        }
        if (!ckbTerminos.isChecked()) {
            //ckbTerminos.setError("Debe aceptar los terminos.");
            Toast.makeText (getApplicationContext(), "Debe aceptar términos y condiciones.",Toast.LENGTH_SHORT).show();
            output = false;
        }

        return output;
    }
}

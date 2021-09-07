package com.example.bookishbookshop;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpTwo extends AppCompatActivity {

    /*
    * ---Variables--------------------------------------------------------------------------------*/
    ImageView logo;
    ScrollView scrvSU2;
    Spinner spnrEStadoCivil;
    TextView txtvEstadoCivilR, txtvCelularR, txtvDireccionR, txtvContrasenaR,txtvContrasenaCR;
    EditText edtxCelular, edtxDireccion, edtxContrasena, edtxContrasenaC;
    CheckBox ckbTerminos, ckNoticias;
    ConstraintLayout btnAnterior, btnCrear;
    private boolean isFirstTime = true;
    TextWatcher twDireccion, twContrasena, twCotrasenaC;

    /*
     * ---AutFit Variables-------------------------------------------------------------------------*/
    private int dpWidth, dpHeight, designWidth = 360,  desighHeiht = 780;
    private float dDensity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_dos);
        getSupportActionBar().hide();

        // Asign Variables
        logo = findViewById(R.id.iv_Logo_SignUp2);
        scrvSU2 = findViewById(R.id.scrollView_SignUp2);
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
        twDireccion = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edtxDireccion.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.registro_campos));
                txtvDireccionR.setText(null);
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        };
        edtxDireccion.addTextChangedListener(twDireccion);

        // EditText Contrasena: normal background && clear error
        twContrasena = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edtxContrasena.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.registro_campos));
                txtvContrasenaR.setText(null);
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        };
        edtxContrasena.addTextChangedListener(twContrasena);

        // EditText ContrasenaC: normal background && clear error
        twCotrasenaC = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edtxContrasenaC.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.registro_campos));
                txtvContrasenaCR.setText(null);
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        };
        edtxContrasenaC.addTextChangedListener(twCotrasenaC);


        /*
         * ---Buttons------------------------------------------------------------------------------*/
        // Button: Crear
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (esCorrecto () == true) {
                   finish();
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

        /*
         * ---AutoFit------------------------------------------------------------------------------*/
        int buttonsX = 130, buttonsY = 60, edittextX = 300, edittextY = 70;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        dpWidth = (displayMetrics.widthPixels);
        dpHeight = (displayMetrics.heightPixels);
        dDensity = (displayMetrics.scaledDensity);
        // Imageview: Logo
        ViewGroup.LayoutParams logoP = (ViewGroup.MarginLayoutParams) logo.getLayoutParams();
        logoP.height = calHeight(120);
        // ScrollView: scrollView_SignUp2
        ViewGroup.LayoutParams scrvSU2P = (ViewGroup.MarginLayoutParams) scrvSU2.getLayoutParams();
        scrvSU2P.height = calHeight(608);
        // ConstraintLayout: Anterior
        ViewGroup.LayoutParams btnAnterioP = (ViewGroup.MarginLayoutParams) btnAnterior.getLayoutParams();
        btnAnterioP.width = calWidth(buttonsX);
        btnAnterioP.height = calHeight(buttonsY);
        // ConstraintLayout: Crear
        ViewGroup.LayoutParams btnCrearP = (ViewGroup.MarginLayoutParams) btnCrear.getLayoutParams();
        btnCrearP.width = calWidth(buttonsX);
        btnCrearP.height = calHeight(buttonsY);

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

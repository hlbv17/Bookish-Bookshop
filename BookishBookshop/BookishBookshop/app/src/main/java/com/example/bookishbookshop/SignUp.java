package com.example.bookishbookshop;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.DisplayMetrics;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    /*
     * ---Variables-------------------------------------------------------------------------------*/
    ImageView logo;
    ScrollView scrvSU1;
    Spinner spnrID;
    TextView txtvID, txtvsIDR, txtvIDR, txtvNombreR, txtvCorreoR, txtvSexoR, txtvEdadR;
    EditText edtxID, edtxNombre,edtxCorreo, edtxEdad;
    RadioGroup rdgSexo;
    RadioButton rdbFemenino, rdbMasculino, rdbOtros;
    ConstraintLayout btnSiguiente, btnCancelar;
    private boolean isFirstTime = true;
    TextWatcher twNombre, twCorreo;

    /*
     * ---AutoFit Variables-----------------------------------------------------------------------*/
    private int dpWidth, dpHeight, designWidth = 360,  desighHeiht = 780;
    private float dDensity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_sign_up);


        // Asign Variables
        logo = findViewById(R.id.iv_Logo_SignUp1);
        scrvSU1 = findViewById(R.id.scrollView_SignUp1);
        spnrID = findViewById(R.id.spnr_ID);
        txtvsIDR = findViewById(R.id.txtv_sID_Error);
        txtvID = findViewById(R.id.txtv_ID);
        edtxID = findViewById(R.id.edtx_ID);
        txtvIDR = findViewById(R.id.txtv_ID_Error);
        edtxNombre = findViewById(R.id.edtx_Nombre);
        txtvNombreR = findViewById(R.id.txtv_Nombre_Error);
        edtxCorreo = findViewById(R.id.edtx_Correo);
        txtvCorreoR = findViewById(R.id.txtv_Correo_Error);
        rdgSexo = findViewById(R.id.rdg_Sexo);
        txtvSexoR = findViewById(R.id.txtv_Sexo_Error);
        rdbFemenino = findViewById(R.id.rdb_Femenino);
        rdbMasculino = findViewById(R.id.rdb_Masculino);
        rdbOtros = findViewById(R.id.rdb_Otros);
        edtxEdad = findViewById(R.id.edtx_Edad);
        txtvEdadR = findViewById(R.id.txtv_Edad_Error);
        btnSiguiente = findViewById(R.id.btnSiguiente);
        btnCancelar =  findViewById(R.id.btnCancelar);

        // max length input
        edtxEdad.setFilters (new InputFilter[]{new InputFilter.LengthFilter (2)});
        edtxID.setFilters (new InputFilter[]{new InputFilter.LengthFilter (10)});

        /*
         * ---Listeners----------------------------------------------------------------------------*/

        // Spinner ID: Cédula/Pasaporte && normal background && clear error
        spnrID.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (isFirstTime) {
                    isFirstTime = false;
                } else if (!spnrID.getSelectedItem().toString().equals("Seleccione")) {
                    txtvID.setText(spnrID.getSelectedItem().toString());
                    spnrID.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.registro_campos));
                    txtvsIDR.setText(null);
                } else {
                    txtvID.setText("Identificación");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // EditText ID: normal background && clear error
        edtxID.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                edtxID.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.registro_campos));
                txtvIDR.setText(null);
                return false;
            }
        });

        // EditText Nombre: normal background && clear error
        twNombre = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edtxNombre.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.registro_campos));
                txtvNombreR.setText(null);
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        };
        edtxNombre.addTextChangedListener(twNombre);

        // EditText Correo: normal background && clear error
        twCorreo = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                edtxCorreo.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.registro_campos));
                txtvCorreoR.setText(null);
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        };

        // RadioGroup Sexo: clear error
        rdgSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                txtvSexoR.setText(null);
            }
        });

        // EditText Edad: normal background && clear error
        edtxEdad.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                edtxEdad.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.registro_campos));
                txtvEdadR.setText(null);
                return false;
            }
        });

        /*
         * ---Buttons------------------------------------------------------------------------------*/

        // Button: Siguiente
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (esCorrecto () == true) {
                    Intent newactivity = new Intent(SignUp.this,SignUpTwo.class);
                    startActivity (newactivity);
                }
            }
        });

        // Button: Cancelar
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                /*Intent newactivity = new Intent(SignUp.this,Login.class);
                startActivity (newactivity);*/
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
        // ScrollView: scrollView_SignUp1
        ViewGroup.LayoutParams scrvSU1P = (ViewGroup.MarginLayoutParams) scrvSU1.getLayoutParams();
        scrvSU1P.height = calHeight(608);
        // ConstraintLayout: Cancelar
        ViewGroup.LayoutParams btnCancelarP = (ViewGroup.MarginLayoutParams) btnCancelar.getLayoutParams();
        btnCancelarP.width = calWidth(buttonsX);
        btnCancelarP.height = calHeight(buttonsY);
        // ConstraintLayout: Siguiente
        ViewGroup.LayoutParams btnSiguienteP = (ViewGroup.MarginLayoutParams) btnSiguiente.getLayoutParams();
        btnSiguienteP.width = calWidth(buttonsX);
        btnSiguienteP.height = calHeight(buttonsY);

    }


    // Method: esCorrecto
    private boolean esCorrecto () {
        boolean output = true;
        // Spinner ID: error
        if (spnrID.getSelectedItem().toString().equals("Seleccione")) {
            //Toast.makeText (getApplicationContext(), "Seleccione tipo de ID",Toast.LENGTH_SHORT).show();
            spnrID.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.registro_campos_error));
            txtvsIDR.setText("Seleccione tipo de ID");
            output = false;
        }
        // EditText ID: error
        if (edtxID.length() == 0) {
            //edtxID.setError("Campo obligatorio.");
            edtxID.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.registro_campos_error));
            txtvIDR.setText("Campo obligatorio.");
            output = false;
        } else if (edtxID.length() < 10) {
            //edtxID.setError("ID no valido.");
            edtxID.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.registro_campos_error));
            txtvIDR.setText("ID no valido.");
            output = false;
        }
        // EditText Nombre: error
        if (edtxNombre.getText().toString().trim().length() == 0) {
            //edtxNombre.setError("Campo obligatorio.");
            edtxNombre.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.registro_campos_error));
            txtvNombreR.setText("Campo obligatorio.");
            output = false;
        }
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
        // RadioButton Sexo: error
        if (rdgSexo.getCheckedRadioButtonId() == -1) {
            Toast.makeText (getApplicationContext(), "Seleccione sexo",Toast.LENGTH_SHORT).show();
            txtvSexoR.setText("Seleccione sexo");
            output = false;
        }
        // EditText Edad: error
        if (edtxEdad.length() == 0) {
            //edtxEdad.setError("Campo obligatorio.");
            edtxEdad.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.registro_campos_error));
            txtvEdadR.setText("Campo obligatorio.");
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


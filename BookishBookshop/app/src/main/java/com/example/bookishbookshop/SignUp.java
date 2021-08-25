package com.example.bookishbookshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    Spinner tipoId;


    EditText nombre;
    EditText id;
    EditText edad;
    EditText correo;
    EditText direccion;
    EditText celular;
    RadioButton F;
    RadioButton M;
    Spinner estadoCivil;
    Validacion validar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_sign_up);

        validar = new Validacion();
        tipoId = findViewById(R.id.spinner);
        LinearLayout botonSiguiente = findViewById(R.id.btnSiguiente);
        LinearLayout botonCancelar = findViewById(R.id.btnCancelar);
        nombre = findViewById(R.id.txtNombre);
        id = findViewById(R.id.txtId);
        edad = findViewById(R.id.txtEdad);
        direccion = findViewById(R.id.txtDireccion);
        correo = findViewById(R.id.txtCorreo);
        celular = findViewById(R.id.txtCelular);
        F = findViewById(R.id.rdbF);
        M = findViewById(R.id.rdbM);
        estadoCivil = findViewById(R.id.spinner2);


        String []opciones={"Seleccione","Cédula","Pasaporte"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, opciones);
        tipoId.setAdapter(adapter);

        /*if (EsCorrecto(View nombre, id, edad, correo, direccion, celular){

        }*/

        botonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), SignUpTwo.class);
                startActivityForResult(intent, 0);
            }
        });

        botonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Login.class);
                startActivityForResult(intent, 0);
            }
        });


    }

    public boolean Registra(View v){
        //capturo datos editext
        String numero1 = id.getText().toString().trim();
        String numero2 = celular.getText().toString().trim();
        boolean flag = true;
        //valido que los editext no esten vacios
        if(!validar.Vacio(id) && !validar.Vacio(nombre) ){
            //valido que los datos ingresados sean numeros
            if(validar.isNumeric(numero1) && validar.isNumeric(numero2)){
                //si son numeros hago la suma
                flag = true;
            }
            else{
                //si los  valores no son numericos
                Toast.makeText(getApplicationContext(),"Ingrese Valores Numericos", Toast.LENGTH_SHORT).show();
                flag = false;
            }
        }
        return flag;
    }

    public boolean EsCorrecto(View v)
    {

        boolean x = false;
        String nombreS = nombre.getText().toString().trim();
        String edadS = edad.getText().toString().trim();
        String direccionS = direccion.getText().toString().trim();
        String celularS = celular.getText().toString().trim();
        String correoS = correo.getText().toString().trim();
        if (validar.Vacio(nombre) && validar.isNumeric(edadS)&& validar.Vacio(edad) && validar.Vacio(direccion)
                && validar.Vacio(celular) && validar.isNumeric(celularS) && validar.Vacio(correo)
                && validar.isEmail(correoS))
        {
            Toast.makeText(getApplicationContext(), "Datos registrados", Toast.LENGTH_SHORT).show();
            x = true;
        } else {
            Toast.makeText(getApplicationContext(), "Ingrese todos los datos", Toast.LENGTH_SHORT).show();
            x = false;
        }
        return x;
    }



}

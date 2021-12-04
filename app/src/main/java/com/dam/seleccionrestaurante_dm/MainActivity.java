package com.dam.seleccionrestaurante_dm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAccAct2;
    EditText etNombre;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAccAct2 = findViewById(R.id.btnAccederAct2);
        etNombre = findViewById(R.id.etNombreUser);

        btnAccAct2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String nombre = etNombre.getText().toString();

        if (nombre.isEmpty()) {
            Toast toast = Toast.makeText(getApplicationContext(), "Debe introducir un nombre", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        } else {
            ((MiApplication) getApplicationContext()).setNombre(nombre);

            Intent i = new Intent(this, IndicacionesActivity.class);
            startActivity(i);
        }


    }
}
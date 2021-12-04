package com.dam.seleccionrestaurante_dm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class DatosActivity extends AppCompatActivity implements View.OnClickListener{
    static String CLAVE_REST1 = "RES_1";
    static String CLAVE_REST2 = "RES_2";

    TextView tvIntro;
    EditText etNom;
    EditText etTel;
    EditText etWeb;
    EditText etDistancia;
    RadioGroup rdbgroupTrafico;
    RadioButton rdbtnSeleccionado;
    Button btnAceptar;
    Button btnCancelar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        tvIntro = findViewById(R.id.tvIntroActDatos);
        etNom = findViewById(R.id.etNombreRes);
        etTel = findViewById(R.id.etTelRes);
        etWeb = findViewById(R.id.etWebRes);
        etDistancia = findViewById(R.id.etDisRes);
        rdbgroupTrafico = findViewById(R.id.rdbgroupTrafico);

        btnAceptar = findViewById(R.id.btnAceptarDatosRes);
        btnCancelar = findViewById(R.id.btnCancelarDatosRes);

        btnAceptar.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);

        if (IndicacionesActivity.isRes1) {
            tvIntro.setText(String.format(getResources().getString(R.string.tv_intro_act_datos),
                    ((MiApplication) getApplicationContext()).getNombre(), getResources().getString(R.string.res_primero)));
        } else if (IndicacionesActivity.isRes2) {
            tvIntro.setText(String.format(getResources().getString(R.string.tv_intro_act_datos),
                    ((MiApplication) getApplicationContext()).getNombre(), getResources().getString(R.string.res_segundo)));

        }



    }

    private String gettextRadioButton() {
        rdbtnSeleccionado = findViewById(rdbgroupTrafico.getCheckedRadioButtonId());
        String boton = rdbtnSeleccionado.getText().toString();
        return boton;
    }

    @Override
    public void onClick(View view) {

        String nombre = etNom.getText().toString();
        String tel = etTel.getText().toString();
        String web = etWeb.getText().toString();
        int dis = Integer.parseInt(etDistancia.getText().toString());


        if (view.equals(btnAceptar)) {

            if(isVacio()) {
                Toast.makeText(this, getResources().getString(R.string.toastVacio), Toast.LENGTH_SHORT).show();
            } else if(IndicacionesActivity.isRes1) {
                String traf1 = gettextRadioButton();
                System.out.println(traf1);
                OpcionRestaurante res1 = new OpcionRestaurante(nombre, tel, web, dis, traf1);
                Intent datos = new Intent();
                datos.putExtra(CLAVE_REST1, res1);
                setResult(RESULT_OK, datos);

                finish();

            } else if (IndicacionesActivity.isRes2) {
                String traf2 = gettextRadioButton();
                System.out.println(traf2);
                OpcionRestaurante res2 = new OpcionRestaurante(nombre, tel, web, dis, traf2);
                Intent datos = new Intent();
                datos.putExtra(CLAVE_REST2, res2);
                setResult(RESULT_OK, datos);

                finish();
            }
        } else if (view.equals(btnCancelar)){
            setResult(RESULT_CANCELED);
            finish();
            IndicacionesActivity.isRes1 = false;
            IndicacionesActivity.isRes2 = false;
        }
    }

    private boolean isVacio(){
        boolean vacio = false;
        if(etNom.getText().toString().isEmpty() || etDistancia.getText().toString().isEmpty() ||
                etWeb.getText().toString().isEmpty() || etTel.getText().toString().isEmpty() ||
                rdbgroupTrafico.getCheckedRadioButtonId() == -1) {
            vacio = true;
        }

        return  vacio;
    }
}
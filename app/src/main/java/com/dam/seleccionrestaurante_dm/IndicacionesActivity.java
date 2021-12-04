package com.dam.seleccionrestaurante_dm;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class IndicacionesActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tvIntro;
    Button btnRes1;
    Button btnRes2;
    Button btnCalcular;
    TextView tvNom1;
    TextView tvTel1;
    TextView tvWeb1;
    TextView tvNom2;
    TextView tvTel2;
    TextView tvWeb2;

    public static boolean isRes1;
    public static boolean isRes2;

    static String CLAVE_REST_FINAL = "RES_FINAL";

    OpcionRestaurante res1 = null;
    OpcionRestaurante res2 = null;

    //public static double tiempoFinal;


    ActivityResultLauncher<Intent> arl = registerForActivityResult(

            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == DatosActivity.RESULT_OK) {
                        if (isRes1) {
                            res1 = result.getData().getParcelableExtra(DatosActivity.CLAVE_REST1);


                            tvNom1.setText(String.format(getResources().getString(R.string.tv_nombre), res1.getNombre()));


                            tvTel1.setText(String.format(getResources().getString(R.string.tv_tel), res1.getTelefono()));


                            tvWeb1.setText(String.format(getResources().getString(R.string.tv_web), res1.getOpcionTrafico()));


                            btnRes1.setEnabled(false);
                            isRes1 = false;
                        } else if (isRes2) {
                            res2 = result.getData().getParcelableExtra(DatosActivity.CLAVE_REST2);

                            tvNom2.setText(String.format(getResources().getString(R.string.tv_nombre2), res2.getNombre()));


                            tvTel2.setText(String.format(getResources().getString(R.string.tv_tel2), res2.getTelefono()));


                            tvWeb2.setText(String.format(getResources().getString(R.string.tv_web2), res2.getWeb()));


                            btnRes2.setEnabled(false);
                            isRes2 = false;
                        }


                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indicaciones);

        tvIntro = findViewById(R.id.tvIntroAct2);
        btnRes1 = findViewById(R.id.btnIntroDatos1);
        btnRes2 = findViewById(R.id.btnIntroDatos2);
        btnCalcular = findViewById(R.id.btnCalcular);

        tvNom1 = findViewById(R.id.tvNombre1);
        tvTel1 = findViewById(R.id.tvTelefono1);
        tvWeb1 = findViewById(R.id.tvWeb1);

        tvNom2 = findViewById(R.id.tvNombre2);
        tvTel2 = findViewById(R.id.tvTelefono2);
        tvWeb2 = findViewById(R.id.tvWeb2);


        btnRes1.setOnClickListener(this);
        btnRes2.setOnClickListener(this);
        btnCalcular.setOnClickListener(this);


        isRes1 = false;
        isRes2 = false;

        tvIntro.setText(String.format(getResources().getString(R.string.tv_intro_act2),
                ((MiApplication) getApplicationContext()).getNombre()));

    }



    @Override
    public void onClick(View view) {

        double tiempoRes1 = 0;
        double tiempoRes2 = 0;

        if(view.equals(btnRes1)) {
            Intent i = new Intent(this, DatosActivity.class);
            isRes1 = true;
            arl.launch(i);
        } else if (view.equals(btnRes2)) {
            Intent i = new Intent(this, DatosActivity.class);
            isRes2 = true;
            arl.launch(i);
        } else if (view.equals(btnCalcular)){
            OpcionRestaurante resFinal;
            if (res1 == null) {
                Toast.makeText(this, String.format(getResources().getString(R.string.toastResNull), "1"), Toast.LENGTH_SHORT).show();
            } else if (res2 == null) {
                Toast.makeText(this, String.format(getResources().getString(R.string.toastResNull), "2"), Toast.LENGTH_SHORT).show();
            } else {
                System.out.println(res1.getWeb());
                System.out.println(res2.getOpcionTrafico());

                String traf1 = res1.getOpcionTrafico();
                String traf2 = res2.getOpcionTrafico();

                tiempoRes1 = calcTiempo(traf1, res1.getDistanciaKM());
                tiempoRes2 = calcTiempo(traf2, res2.getDistanciaKM());

                if (tiempoRes1 >= tiempoRes2) {
                    //tiempoFinal = tiempoRes1;
                    resFinal = res1;
                    Intent i = new Intent(this, SeleccionActivity.class);
                    i.putExtra(CLAVE_REST_FINAL, resFinal);
                    startActivity(i);
                } else {
                    //tiempoFinal = tiempoRes2;
                    resFinal = res2;
                    Intent i = new Intent(this, SeleccionActivity.class);
                    i.putExtra(CLAVE_REST_FINAL, resFinal);
                    startActivity(i);
                }
            }
        }


    }




    public double calcTiempo(String trafico, double distancia){
        double tiempo = 0;
        int velocidad = 0;


        System.out.println(trafico);
        switch (trafico) {
            case "Poco":
                velocidad = 80;
            break;

            case "Medio":
                velocidad = 60;
            break;

            case "Mucho":
                velocidad = 40;
            break;
        }

        tiempo = (distancia/velocidad) * 60;


        return tiempo;
    }
}
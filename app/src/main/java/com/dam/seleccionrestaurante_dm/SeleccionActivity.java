package com.dam.seleccionrestaurante_dm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SeleccionActivity extends AppCompatActivity implements View.OnClickListener {

/*
    TextView tvIntro;
    TextView tvResFinal;
    TextView tvTelFinal;
    Button btnLlamar;
    TextView tvWebFinal;
    Button btnWeb;
    TextView tvDisFinal;
    TextView tvTiempoFinal;
    Button btnReiniciar;

    OpcionRestaurante restaurante;
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion);
/*
        tvIntro = findViewById(R.id.tvIntroFinal);
        tvResFinal = findViewById(R.id.tvResultadoRes);
        tvTelFinal = findViewById(R.id.tvTelFinal);
        btnLlamar = findViewById(R.id.btnLlamar);
        tvWebFinal = findViewById(R.id.tvWebFinal);
        btnWeb = findViewById(R.id.btnWebFinal);
        tvDisFinal = findViewById(R.id.tvDisFinal);
        tvTiempoFinal = findViewById(R.id.tvTiempoFinal);
        btnReiniciar = findViewById(R.id.btnReiniciar);

        btnReiniciar.setOnClickListener(this);
        btnWeb.setOnClickListener(this);
        btnLlamar.setOnClickListener(this);

        tvIntro.setText(String.format(getResources().getString(R.string.tv_intro_final),
                ((MiApplication) getApplicationContext()).getNombre()));

        restaurante = getIntent().getExtras().getParcelable(IndicacionesActivity.CLAVE_REST_FINAL);

        String nombre = restaurante.getNombre();
        String tel = restaurante.getTelefono();
        String web = restaurante.getWeb();
        Double dis = restaurante.getDistanciaKM();
        Double temp = calcTiempo(restaurante.getOpcionTrafico(), dis);
        //Double temp = Double.valueOf(Math.round(calcTiempo(restaurante.getOpcionTrafico(), dis) * 100) / 100);

        String distancia = dis.toString() + " ";
        String tiempo = temp.toString() + " ";

        //tvResFinal.setText(nombre);

        //tvTelFinal.setText(String.format(getResources().getString(R.string.tv_tel_final), tel));
        //tvWebFinal.setText(String.format(getResources().getString(R.string.tv_web_final), web));
        //tvDisFinal.setText(String.format(getResources().getString(R.string.tv_dis_final), distancia));
        //tvTiempoFinal.setText(String.format(getResources().getString(R.string.tv_tiempo_final), tiempo));

*/




    }

    @Override
    public void onClick(View view) {

    }

    public double calcTiempo(String trafico, double distancia){
        double tiempo = 0;
        int velocidad = 0;

        switch (trafico.toLowerCase()) {
            case "poco":
                velocidad = 80;
            break;

            case "medio":
                velocidad = 60;
            break;

            case "mucho":
                velocidad = 40;
            break;
        }

        tiempo = (distancia/velocidad) * 60;


        return tiempo;
    }
}
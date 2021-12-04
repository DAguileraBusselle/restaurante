package com.dam.seleccionrestaurante_dm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SeleccionActivity extends AppCompatActivity implements View.OnClickListener {


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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion);

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

        Double temp = IndicacionesActivity.tiempoFinal;

        String distancia = dis.toString();

        String tiempo = temp.toString();
        if (tiempo.length() > 7) {
            tiempo = tiempo.substring(0, 7);
        }

        tvResFinal.setText(nombre);

        tvTelFinal.setText(String.format(getResources().getString(R.string.tv_tel_final), tel));
        tvWebFinal.setText(String.format(getResources().getString(R.string.tv_web_final), web));
        tvDisFinal.setText(String.format(getResources().getString(R.string.tv_dis_final), distancia));
        tvTiempoFinal.setText(String.format(getResources().getString(R.string.tv_tiempo_final), tiempo));






    }

    @Override
    public void onClick(View view) {
        if(view.equals(btnLlamar)){
            Uri telf = Uri.parse("tel:" + restaurante.getTelefono());
            Intent llamada = new Intent(Intent.ACTION_DIAL, telf);
            if (llamada.resolveActivity(getPackageManager()) != null){
                startActivity(llamada);
            }
        }else if(view.equals(btnWeb)){
            Uri url = Uri.parse("https://" + restaurante.getWeb());
            Intent navegar = new Intent(Intent.ACTION_VIEW, url);
            if (navegar.resolveActivity(getPackageManager()) != null){
                startActivity(navegar);
            }
        }else{
            Intent intent = new Intent(getApplicationContext(),
                    MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }

    }


}
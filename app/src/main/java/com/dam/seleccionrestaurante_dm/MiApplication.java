package com.dam.seleccionrestaurante_dm;

import android.app.Application;

public class MiApplication extends Application {

    private String nombre;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

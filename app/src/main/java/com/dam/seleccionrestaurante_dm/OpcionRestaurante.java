package com.dam.seleccionrestaurante_dm;

import android.os.Parcel;
import android.os.Parcelable;

import java.net.URI;

public class OpcionRestaurante implements Parcelable {
    private String nombre;
    private String telefono;
    private String web;
    private double distanciaKM;
    private String opcionTrafico;

    public OpcionRestaurante(String nombre, String telefono, String web, double distanciaKM, String opcionTrafico) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.web = web;
        this.distanciaKM = distanciaKM;
        this.opcionTrafico = opcionTrafico;
    }

    protected OpcionRestaurante(Parcel in) {
        nombre = in.readString();
        telefono = in.readString();
        web = in.readString();
        distanciaKM = in.readInt();
        opcionTrafico = in.readString();
    }

    public static final Creator<OpcionRestaurante> CREATOR = new Creator<OpcionRestaurante>() {
        @Override
        public OpcionRestaurante createFromParcel(Parcel in) {
            return new OpcionRestaurante(in);
        }

        @Override
        public OpcionRestaurante[] newArray(int size) {
            return new OpcionRestaurante[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getWeb() {
        return web;
    }

    public double getDistanciaKM() {
        return distanciaKM;
    }

    public String getOpcionTrafico() {
        return opcionTrafico;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeString(telefono);
        parcel.writeString(web);
        parcel.writeDouble(distanciaKM);
        parcel.writeString(opcionTrafico);
    }
}

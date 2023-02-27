package com.mdgz.dam.labdam2022.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Hotel implements Parcelable {
    Integer id;
    String nombre;
    Integer categoria;
    Ubicacion ubicacion;

    public Hotel(){
        super();
    }

    public Hotel(Integer id, String nombre, Integer categoria, Ubicacion ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.ubicacion = ubicacion;
    }

    protected Hotel(Parcel in) {
        id = in.readInt();
        nombre = in.readString();
        categoria = in.readInt();
        ubicacion = in.readParcelable(Ubicacion.class.getClassLoader());
    }

    public static final Creator<Hotel> CREATOR = new Creator<Hotel>() {
        @Override
        public Hotel createFromParcel(Parcel in) {
            return new Hotel(in);
        }

        @Override
        public Hotel[] newArray(int size) {
            return new Hotel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.id);
        parcel.writeString(this.nombre);
        parcel.writeValue(this.categoria);
        parcel.writeParcelable(this.ubicacion, i);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
    public String toString (){
        return nombre;
    }


}

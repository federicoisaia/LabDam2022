package com.mdgz.dam.labdam2022.model;

import android.os.Parcel;

import java.util.UUID;

public class Habitacion  extends Alojamiento {

    private int camasIndividuales;
    private int camasMatrimoniales;
    private Boolean tieneEstacionamiento;
    private Hotel hotel;

    public Habitacion() {
        super();
    }

    public Habitacion(UUID id, String titulo, String descripcion, Integer capacidad, Double precioBase, int camasIndividuales, int camasMatrimoniales, Boolean tieneEstacionamiento, Hotel hotel) {
        super(id, titulo, descripcion, capacidad, precioBase);
        this.camasIndividuales = camasIndividuales;
        this.camasMatrimoniales = camasMatrimoniales;
        this.tieneEstacionamiento = tieneEstacionamiento;
        this.hotel = hotel;
    }
    public Habitacion( String titulo, String descripcion, Integer capacidad, Double precioBase, int camasIndividuales, int camasMatrimoniales, Boolean tieneEstacionamiento, Hotel hotel) {
        super(titulo, descripcion, capacidad, precioBase);
        this.camasIndividuales = camasIndividuales;
        this.camasMatrimoniales = camasMatrimoniales;
        this.tieneEstacionamiento = tieneEstacionamiento;
        this.hotel = hotel;
    }
    protected Habitacion(Parcel in) {
        this.camasIndividuales = (Integer) in.readValue(Integer.class.getClassLoader());
        this.camasMatrimoniales = (Integer) in.readValue(Integer.class.getClassLoader());
        this.tieneEstacionamiento = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.hotel = in.readParcelable(Hotel.class.getClassLoader());
        this.id = (UUID) in.readSerializable();
        this.titulo = in.readString();
        this.descripcion = in.readString();
        this.capacidad = (Integer) in.readValue(Integer.class.getClassLoader());
        this.precioBase = (Double) in.readValue(Double.class.getClassLoader());
    }

    public static final Creator<Habitacion> CREATOR = new Creator<Habitacion>() {
        @Override
        public Habitacion createFromParcel(Parcel source) {
            return new Habitacion(source);
        }

        @Override
        public Habitacion[] newArray(int size) {
            return new Habitacion[size];
        }
    };

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {this.id = id;}

    public int getCamasIndividuales() {
        return camasIndividuales;
    }

    public void setCamasIndividuales(int camasIndividuales) {
        this.camasIndividuales = camasIndividuales;
    }

    public int getCamasMatrimoniales() {
        return camasMatrimoniales;
    }

    public void setCamasMatrimoniales(int camasMatrimoniales) {
        this.camasMatrimoniales = camasMatrimoniales;
    }

    public Boolean getTieneEstacionamiento() {
        return tieneEstacionamiento;
    }

    public void setTieneEstacionamiento(Boolean tieneEstacionamiento) {
        this.tieneEstacionamiento = tieneEstacionamiento;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public Ubicacion getUbicacion() {
        return hotel.getUbicacion();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.camasIndividuales);
        parcel.writeValue(this.camasMatrimoniales);
        parcel.writeValue(this.tieneEstacionamiento);
        parcel.writeParcelable(this.hotel, i);
        parcel.writeSerializable(this.id);
        parcel.writeString(this.titulo);
        parcel.writeString(this.descripcion);
        parcel.writeValue(this.capacidad);
        parcel.writeValue(this.precioBase);
    }
}

package com.mdgz.dam.labdam2022.model;

import android.os.Parcel;

import java.util.UUID;

public class Departamento extends Alojamiento {

    private Boolean tieneWifi;
    private Double costoLimpieza;
    private Integer cantidadHabitaciones;
    private Ubicacion ubicacion;
    private UUID idAlojamiento;

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Departamento(){
        super();
    }

    public Departamento(UUID id, String titulo, String descripcion, Integer capacidad, Double precioBase, Boolean tieneWifi, Double costoLimpieza, Integer cantidadHabitaciones, Ubicacion ubicacion) {
        super(id, titulo, descripcion, capacidad, precioBase);
        this.tieneWifi = tieneWifi;
        this.costoLimpieza = costoLimpieza;
        this.cantidadHabitaciones = cantidadHabitaciones;
        this.ubicacion = ubicacion;
        this.idAlojamiento=idAlojamiento;
    }
    public Departamento( String titulo, String descripcion, Integer capacidad, Double precioBase, Boolean tieneWifi, Double costoLimpieza, Integer cantidadHabitaciones, Ubicacion ubicacion) {
        super(titulo, descripcion, capacidad, precioBase);
        this.tieneWifi = tieneWifi;
        this.costoLimpieza = costoLimpieza;
        this.cantidadHabitaciones = cantidadHabitaciones;
        this.ubicacion = ubicacion;
    }

    protected Departamento(Parcel in) {
        this.tieneWifi = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.costoLimpieza = (Double) in.readValue(Double.class.getClassLoader());
        this.cantidadHabitaciones = (Integer) in.readValue(Integer.class.getClassLoader());
        this.ubicacion = in.readParcelable(Ubicacion.class.getClassLoader());
        this.id = (UUID) in.readSerializable();
        this.titulo = in.readString();
        this.descripcion = in.readString();
        this.capacidad = (Integer) in.readValue(Integer.class.getClassLoader());
        this.precioBase = (Double) in.readValue(Double.class.getClassLoader());
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.tieneWifi);
        parcel.writeValue(this.costoLimpieza);
        parcel.writeValue(this.cantidadHabitaciones);
        parcel.writeParcelable(this.ubicacion, i);
        parcel.writeSerializable(this.id);
        parcel.writeString(this.titulo);
        parcel.writeString(this.descripcion);
        parcel.writeValue(this.capacidad);
        parcel.writeValue(this.precioBase);
    }
    public static final Creator<Departamento> CREATOR = new Creator<Departamento>() {
        @Override
        public Departamento createFromParcel(Parcel source) {
            return new Departamento(source);
        }

        @Override
        public Departamento[] newArray(int size) {
            return new Departamento[size];
        }
    };


    public Boolean getTieneWifi() {
        return tieneWifi;
    }

    public void setTieneWifi(Boolean tieneWifi) {
        this.tieneWifi = tieneWifi;
    }

    public Double getCostoLimpieza() {
        return costoLimpieza;
    }

    public void setCostoLimpieza(Double costoLimpieza) {
        this.costoLimpieza = costoLimpieza;
    }

    public Integer getCantidadHabitaciones() {
        return cantidadHabitaciones;
    }

    public void setCantidadHabitaciones(Integer cantidadHabitaciones) {
        this.cantidadHabitaciones = cantidadHabitaciones;
    }

    @Override
    public Ubicacion getUbicacion() {
        return ubicacion;
    }

}

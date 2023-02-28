package com.mdgz.dam.labdam2022.model;

import android.os.Parcelable;

import java.util.UUID;

public abstract class Alojamiento implements Parcelable {

    protected UUID id;
    protected String titulo;
    protected String descripcion;
    protected Integer capacidad;
    protected Double precioBase;

    public abstract Ubicacion getUbicacion();
    public Double costoDia(){
        return precioBase;
    }

    public Alojamiento(){
        super();
    }

    public Alojamiento(UUID id, String titulo, String descripcion, Integer capacidad, Double precioBase) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
        this.precioBase = precioBase;
    }
    public Alojamiento(String titulo, String descripcion, Integer capacidad, Double precioBase) {
        this.id = null;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.capacidad = capacidad;
        this.precioBase = precioBase;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public void setPrecioBase(Double precioBase) {
        this.precioBase = precioBase;
    }

    public String getTitulo(){
        return titulo;
    }

    public Double getPrecioBase() {
        return precioBase;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public UUID getId() {
        return id;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    @Override
    public String toString() {
        return "Alojamiento{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", capacidad=" + capacidad +
                ", precioBase=" + precioBase +
                '}';
    }
}

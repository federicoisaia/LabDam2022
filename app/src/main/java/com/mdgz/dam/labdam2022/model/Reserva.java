package com.mdgz.dam.labdam2022.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.time.LocalDate;
import java.util.UUID;

public class Reserva implements Parcelable {

    private UUID id;
    private UUID alojamientoID;
    private String tituloAlojamiento;
    private LocalDate fechaIngreso;
    private LocalDate fechaEgreso;
    private Double monto;

    public Reserva() {
        super();
    }

    public Reserva(UUID id,UUID alojamientoID, String tituloAlojamiento, LocalDate fechaIngreso, LocalDate fechaEgreso, Double monto) {
        this.id = id;
        this.alojamientoID = alojamientoID;
        this.tituloAlojamiento=tituloAlojamiento;
        this.fechaIngreso = fechaIngreso;
        this.fechaEgreso = fechaEgreso;
        this.monto = monto;
    }
    public Reserva(UUID alojamientoID,String tituloAlojamiento,  LocalDate fechaIngreso, LocalDate fechaEgreso, Double monto) {

        this.alojamientoID = alojamientoID;
        this.tituloAlojamiento=tituloAlojamiento;
        this.fechaIngreso = fechaIngreso;
        this.fechaEgreso = fechaEgreso;
        this.monto = monto;
    }

    public Reserva(UUID alojamientoID) {
        this.alojamientoID = alojamientoID;
    }

    protected Reserva(Parcel in) {
        tituloAlojamiento = in.readString();
        fechaIngreso=LocalDate.parse(in.readString());
        fechaEgreso=LocalDate.parse(in.readString());
            monto = in.readDouble();
    }

    public static final Creator<Reserva> CREATOR = new Creator<Reserva>() {
        @Override
        public Reserva createFromParcel(Parcel in) {
            return new Reserva(in);
        }

        @Override
        public Reserva[] newArray(int size) {
            return new Reserva[size];
        }
    };

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(LocalDate fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public UUID getAlojamientoID() {
        return alojamientoID;
    }

    public void setAlojamientoID(UUID alojamientoID) {
        this.alojamientoID = alojamientoID;
    }

    public String getTituloAlojamiento() {
        return tituloAlojamiento;
    }

    public void setTituloAlojamiento(String tituloAlojamiento) {
        this.tituloAlojamiento = tituloAlojamiento;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(tituloAlojamiento);
        parcel.writeString(fechaIngreso.toString());
        parcel.writeString(fechaEgreso.toString());
        parcel.writeDouble(monto);
        }
}

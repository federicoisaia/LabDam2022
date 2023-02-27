package com.mdgz.dam.labdam2022.model;

import java.util.Date;
import java.util.UUID;

public class Reserva {

    private UUID id;
    private UUID alojamientoID;
    private Date fechaIngreso;
    private Date fechaEgreso;
    private Double monto;

    public Reserva() {
        super();
    }

    public Reserva(UUID id,UUID alojamientoID,  Date fechaIngreso, Date fechaEgreso, Double monto) {
        this.id = id;
        this.alojamientoID = alojamientoID;
        this.fechaIngreso = fechaIngreso;
        this.fechaEgreso = fechaEgreso;
        this.monto = monto;
    }

    public Reserva(UUID alojamientoID) {
        this.alojamientoID = alojamientoID;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(Date fechaEgreso) {
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
}

package com.mdgz.dam.labdam2022.data.datasource.retrofit.entities;

import java.util.Date;
import java.util.UUID;

public class ReservaRestEntity {
        UUID alojamientoId;
        UUID usuarioId;
        Date fechaIngreso;
        Date fechaSalida;

    public ReservaRestEntity(UUID alojamientoId, UUID usuarioId, Date fechaIngreso, Date fechaEgreso) {
        this.alojamientoId = alojamientoId;
        this.usuarioId=usuarioId;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaEgreso;
    }

    public UUID getAlojamientoId() {
        return alojamientoId;
    }

    public void setAlojamientoId(UUID alojamientoId) {
        this.alojamientoId = alojamientoId;
    }

    public UUID getUsuarioID() {
        return usuarioId;
    }

    public void setUsuarioID(UUID usuarioID) {
        this.usuarioId = usuarioID;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
}

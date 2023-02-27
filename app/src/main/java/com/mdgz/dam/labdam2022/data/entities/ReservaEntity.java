package com.mdgz.dam.labdam2022.data.entities;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Date;
import java.util.UUID;

@Entity(indices = @Index(value = { "alojamiento_id" }),
        foreignKeys = @ForeignKey(entity = AlojamientoEntity.class, parentColumns = "id", childColumns = "alojamiento_id", onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE))
public class ReservaEntity {
    @PrimaryKey
    @NonNull
    private UUID id;
    @ColumnInfo(name = "alojamiento_id")
    private UUID alojamientoID;
    @ColumnInfo(name = "usuario_id")
    private UUID usuarioID;
    @ColumnInfo(name = "fecha_Ingreso")
    private Date fechaIngreso;
    @ColumnInfo(name = "fecha_Salida")
    private Date fechaSalida;
    private Double monto;

    public ReservaEntity(@NonNull UUID id, final UUID alojamientoID, final UUID usuarioID,final Date fechaIngreso, final Date fechaSalida, final Double monto) {
        this.id = id;
        this.alojamientoID = alojamientoID;
        this.usuarioID = usuarioID;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.monto = monto;
    }

    @Ignore
    public ReservaEntity(final UUID alojamientoID, final UUID usuarioID, final Date fechaIngreso, final Date fechaSalida, final Double monto) {
        this.id= UUID.randomUUID();
        this.alojamientoID = alojamientoID;
        this.usuarioID = usuarioID;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.monto = monto;

    }

    @NonNull
    public UUID getId() {
        return id;
    }

    public void setId(@NonNull final UUID id) {
        this.id = id;
    }

    public UUID getAlojamientoID() {
        return alojamientoID;
    }

    public void setAlojamientoID(final UUID alojamientoID) {
        this.alojamientoID = alojamientoID;
    }

    public UUID getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(final UUID usuarioID) {
        this.usuarioID = usuarioID;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(final Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(final Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
}

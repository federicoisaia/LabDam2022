package com.mdgz.dam.labdam2022.data.entities;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.time.LocalDate;
import java.util.UUID;

@Entity(indices = @Index(value = { "alojamiento_id" }),
        foreignKeys = @ForeignKey(entity = AlojamientoEntity.class, parentColumns = "id", childColumns = "alojamiento_id", onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE))
public class ReservaEntity {
    @PrimaryKey
    @NonNull
    private UUID id;
    @ColumnInfo(name = "alojamiento_id")
    private UUID alojamientoID;
    @ColumnInfo(name = "titulo_alojamiento")
    private String tituloAlojamiento;
    @ColumnInfo(name = "usuario_id")
    private UUID usuarioID;
    @ColumnInfo(name = "fecha_Ingreso")
    private LocalDate fechaIngreso;
    @ColumnInfo(name = "fecha_Salida")
    private LocalDate fechaSalida;
    private Double monto;

    public ReservaEntity(@NonNull UUID id, final UUID alojamientoID,String tituloAlojamiento, final UUID usuarioID,final LocalDate fechaIngreso, final LocalDate fechaSalida, final Double monto) {
        this.id = id;
        this.alojamientoID = alojamientoID;
        this.tituloAlojamiento=tituloAlojamiento;
        this.usuarioID = usuarioID;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.monto = monto;
    }

    @Ignore
    public ReservaEntity(final UUID alojamientoID,String tituloAlojamiento, final UUID usuarioID, final LocalDate fechaIngreso, final LocalDate fechaSalida, final Double monto) {
        this.id= UUID.randomUUID();
        this.alojamientoID = alojamientoID;
        this.tituloAlojamiento=tituloAlojamiento;
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

    public String getTituloAlojamiento() {
        return tituloAlojamiento;
    }

    public void setTituloAlojamiento(String tituloAlojamiento) {
        this.tituloAlojamiento = tituloAlojamiento;
    }

    public UUID getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(final UUID usuarioID) {
        this.usuarioID = usuarioID;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(final LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(final LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
}

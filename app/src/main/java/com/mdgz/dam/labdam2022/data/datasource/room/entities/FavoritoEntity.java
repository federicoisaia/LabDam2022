package com.mdgz.dam.labdam2022.data.datasource.room.entities;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

import java.util.UUID;

@Entity(
        indices = @Index(value = {"alojamiento_id"}),
        foreignKeys = @ForeignKey(entity = AlojamientoEntity.class, parentColumns = "id", childColumns = "alojamiento_id",
                onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE),
        primaryKeys = {"alojamiento_id", "usuario_id"})
public class FavoritoEntity {

    @NonNull
    @ColumnInfo(name = "alojamiento_id")
    private UUID alojamientoID;
    @NonNull
    @ColumnInfo(name = "usuario_id")
    private UUID usuarioID;

    public FavoritoEntity(@NonNull final UUID alojamientoID, @NonNull final UUID usuarioID) {
        this.alojamientoID = alojamientoID;
        this.usuarioID = usuarioID;
    }
    @NonNull
    public UUID getAlojamientoID() {
        return alojamientoID;
    }

    public void setAlojamientoID(@NonNull final UUID alojamientoID) {
        this.alojamientoID = alojamientoID;
    }
    @NonNull
    public UUID getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(@NonNull final UUID usuarioID) {
        this.usuarioID = usuarioID;
    }
}



package com.mdgz.dam.labdam2022.data.datasource.retrofit.entities;

import java.util.UUID;

public class FavoritoRestEntity {
    UUID alojamientoId;
    UUID usuarioId;

    public FavoritoRestEntity(UUID alojamientoID, UUID usuarioID){
        this.alojamientoId = alojamientoID;
        this.usuarioId = usuarioID;
    }

    public UUID getAlojamientoId() {
        return alojamientoId;
    }

    public void setAlojamientoId(UUID alojamientoId) {
        this.alojamientoId = alojamientoId;
    }

    public UUID getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(UUID usuarioId) {
        this.usuarioId = usuarioId;
    }
}

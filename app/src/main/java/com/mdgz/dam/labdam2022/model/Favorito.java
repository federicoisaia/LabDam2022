package com.mdgz.dam.labdam2022.model;

import java.util.UUID;

public class Favorito {
    UUID alojamientoId;
    UUID usuarioId;

    public Favorito() {
        super();
    }

    public Favorito( UUID alojamientoID, UUID usuarioID){
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

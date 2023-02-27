package com.mdgz.dam.labdam2022.model;

import java.util.UUID;

public class Favorito {
    UUID alojamientoID;
    UUID usuarioID;

    public Favorito() {
        super();
    }

    public Favorito( UUID alojamientoID, UUID usuarioID){
        this.alojamientoID = alojamientoID;
        this.usuarioID = usuarioID;
    }



    public UUID getAlojamientoID() {
        return alojamientoID;
    }

    public void setAlojamientoID(UUID alojamientoID) {
        this.alojamientoID = alojamientoID;
    }

    public UUID getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(UUID usuarioID) {
        this.usuarioID = usuarioID;
    }
}

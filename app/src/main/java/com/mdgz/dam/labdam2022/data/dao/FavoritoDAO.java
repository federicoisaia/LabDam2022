package com.mdgz.dam.labdam2022.data.dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.mdgz.dam.labdam2022.data.entities.FavoritoEntity;

import java.util.UUID;

@Dao
public interface FavoritoDAO {
    @Insert
     void insertar(FavoritoEntity favorito);

    @Delete
    void eliminar (FavoritoEntity favorito);

    @Query("SELECT * FROM favoritoentity")
    FavoritoEntity[] recuperarFavoritos();

    @Query("SELECT * FROM favoritoentity where alojamiento_id=:alojamientoID and usuario_id=:usuarioID")
    FavoritoEntity recuperarFavorito(UUID alojamientoID, UUID usuarioID);

}

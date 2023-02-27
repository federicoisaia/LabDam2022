package com.mdgz.dam.labdam2022.data.dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.mdgz.dam.labdam2022.data.entities.AlojamientoEntity;

import java.util.UUID;
@Dao
public interface AlojamientoDAO {
    @Insert
    void insertar(AlojamientoEntity alojamiento);

    @Query("SELECT * FROM alojamientoentity")
    AlojamientoEntity[] recuperarAlojamientos();

    @Query("SELECT * FROM alojamientoentity where id=:alojamientoId")
    AlojamientoEntity recuperarAlojamientos(UUID alojamientoId);


}

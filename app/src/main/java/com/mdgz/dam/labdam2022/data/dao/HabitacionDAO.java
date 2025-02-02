package com.mdgz.dam.labdam2022.data.dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.mdgz.dam.labdam2022.data.entities.HabitacionEntity;

import java.util.UUID;

@Dao
public interface HabitacionDAO {
    @Insert()
    void insertar(HabitacionEntity habitacion);

    @Query("SELECT * FROM habitacionentity")
    HabitacionEntity[] recuperarHabitaciones();

    @Query("SELECT * FROM habitacionentity where id=:habitacionId")
    HabitacionEntity recuperarHabitacion(UUID habitacionId);

    @Query("SELECT * FROM habitacionentity where alojamiento_id=:alojamientoId")
    HabitacionEntity recuperarHabitacionConAlojamiento(UUID alojamientoId);
}

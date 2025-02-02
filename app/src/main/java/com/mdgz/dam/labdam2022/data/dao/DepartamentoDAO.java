package com.mdgz.dam.labdam2022.data.dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.mdgz.dam.labdam2022.data.entities.DepartamentoEntity;

import java.util.UUID;

@Dao
public interface DepartamentoDAO {
    @Insert()
    void insertar(DepartamentoEntity departamento);

    @Query("SELECT * FROM departamentoentity")
    DepartamentoEntity[] recuperarDepartamentos();

    @Query("SELECT * FROM departamentoentity where id=:departamentoId")
    DepartamentoEntity recuperarDepartamentos(UUID departamentoId);

    @Query("SELECT * FROM departamentoentity where alojamiento_id=:alojamientoId")
    DepartamentoEntity recuperarDepartamentoConAlojamiento(UUID alojamientoId);
}

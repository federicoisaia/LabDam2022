package com.mdgz.dam.labdam2022.data.datasource.room.dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.mdgz.dam.labdam2022.data.datasource.room.entities.ReservaEntity;

import java.util.UUID;

@Dao
public interface ReservaDAO {
    @Insert()
    void insertar(ReservaEntity reserva);

    @Delete
    void eliminar(ReservaEntity reserva);

    @Query("SELECT * FROM reservaentity ")
    ReservaEntity[] recuperarReservas();

    @Query("SELECT * FROM reservaentity where id=:reservaId")
    ReservaEntity recuperarReserva(UUID reservaId);

    @Query("SELECT * FROM reservaentity where alojamiento_id=:alojamiento_id and usuario_id =:usuario_id")
    ReservaEntity[] rescuperarReservas(UUID alojamiento_id, UUID usuario_id);

}

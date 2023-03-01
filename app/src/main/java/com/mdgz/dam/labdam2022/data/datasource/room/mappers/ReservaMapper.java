package com.mdgz.dam.labdam2022.data.datasource.room.mappers;

import com.mdgz.dam.labdam2022.data.datasource.room.entities.ReservaEntity;
import com.mdgz.dam.labdam2022.model.Reserva;
import com.mdgz.dam.labdam2022.data.repo.UserRepository;

import java.util.UUID;

public class ReservaMapper {
    private ReservaMapper(){
    }
    public static ReservaEntity toEntity(final Reserva reserva){
        return new ReservaEntity(
                reserva.getId()==null? UUID.randomUUID(): reserva.getId(),
                reserva.getAlojamientoID(),
                reserva.getTituloAlojamiento(),
                UserRepository.currentUserId(),
                reserva.getFechaIngreso(),
                reserva.getFechaEgreso(),
                reserva.getMonto());
    }
    public static Reserva fromEntity(final ReservaEntity reserva){
        return new Reserva(
                reserva.getId(),
                reserva.getAlojamientoID(),
                reserva.getTituloAlojamiento(),
                reserva.getFechaIngreso(),
                reserva.getFechaSalida(),
                reserva.getMonto());
    }

}

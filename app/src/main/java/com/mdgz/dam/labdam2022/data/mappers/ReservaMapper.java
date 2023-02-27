package com.mdgz.dam.labdam2022.data.mappers;

import com.mdgz.dam.labdam2022.data.entities.ReservaEntity;
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
                UserRepository.currentUserId(),
                reserva.getFechaIngreso(),
                reserva.getFechaEgreso(),
                reserva.getMonto());
    }
    public static Reserva fromEntity(final ReservaEntity reserva){
        return new Reserva(
                reserva.getId(),
                reserva.getAlojamientoID(),
                reserva.getFechaIngreso(),
                reserva.getFechaSalida(),
                reserva.getMonto());
    }

}

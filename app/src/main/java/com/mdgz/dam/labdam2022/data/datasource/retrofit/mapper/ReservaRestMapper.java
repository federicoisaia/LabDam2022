package com.mdgz.dam.labdam2022.data.datasource.retrofit.mapper;

import com.mdgz.dam.labdam2022.data.datasource.retrofit.entities.ReservaRestEntity;
import com.mdgz.dam.labdam2022.data.repo.UserRepository;
import com.mdgz.dam.labdam2022.model.Reserva;

import java.time.ZoneId;
import java.util.Date;

public class ReservaRestMapper {
    private ReservaRestMapper(){
    }
    public static ReservaRestEntity toEntity(final Reserva reserva){
        return new ReservaRestEntity(reserva.getAlojamientoID(),
                UserRepository.currentUserId(),
                Date.from(reserva.getFechaIngreso().atStartOfDay(ZoneId.systemDefault()).toInstant()),
                Date.from(reserva.getFechaEgreso().atStartOfDay(ZoneId.systemDefault()).toInstant()));
    }
    public static Reserva fromEntity(final ReservaRestEntity reservaRest){
        return new Reserva(null,
                reservaRest.getAlojamientoId(),
                reservaRest.getFechaIngreso().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                reservaRest.getFechaSalida().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                null);
    }
}

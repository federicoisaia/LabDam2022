package com.mdgz.dam.labdam2022.data.mappers;

import com.mdgz.dam.labdam2022.data.entities.*;
import com.mdgz.dam.labdam2022.model.Habitacion;
import com.mdgz.dam.labdam2022.data.repo.HotelRepository;

import java.util.UUID;

public class HabitacionMapper {

    private HabitacionMapper() {
    }

    public static HabitacionEntity toEntity(final Habitacion habitacion, final UUID alojamientoId) {
        return new HabitacionEntity(
                alojamientoId,
                habitacion.getCamasIndividuales(),
                habitacion.getCamasMatrimoniales(),
                habitacion.getTieneEstacionamiento(),
                alojamientoId,
                habitacion.getHotel().getId()
        );
    }

    public static Habitacion fromEntity(HabitacionEntity habitacion, AlojamientoEntity alojamiento) {
        return new Habitacion(
                alojamiento.getId(),
                alojamiento.getTitulo(),
                alojamiento.getDescripcion(),
                alojamiento.getCapacidad(),
                alojamiento.getPrecioBase(),
                habitacion.getCamasIndividuales(),
                habitacion.getCamasMatrimoniales(),
                habitacion.getTieneEstacionamiento(),
                HotelRepository.recuperarHotel(habitacion.getHotelID())
        );
    }
}

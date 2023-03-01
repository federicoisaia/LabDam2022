package com.mdgz.dam.labdam2022.data.datasource.room.mappers;


import com.mdgz.dam.labdam2022.data.datasource.room.entities.AlojamientoEntity;
import com.mdgz.dam.labdam2022.model.*;

public abstract class AlojamientoMapper {
    private AlojamientoMapper() {
    }

    public static AlojamientoEntity toEntity(final Alojamiento alojamiento) {
        return new AlojamientoEntity(
                alojamiento.getTitulo(),
                alojamiento instanceof Habitacion ? AlojamientoEntity.TIPO_HABITACION : AlojamientoEntity.TIPO_DEPARTAMENTO,
                alojamiento.getDescripcion(),
                alojamiento.getCapacidad(),
                alojamiento.getPrecioBase()
        );
    }}

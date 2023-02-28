package com.mdgz.dam.labdam2022.data.mappers;

import android.util.Log;

import com.mdgz.dam.labdam2022.data.entities.AlojamientoEntity;
import com.mdgz.dam.labdam2022.data.entities.DepartamentoEntity;
import com.mdgz.dam.labdam2022.data.repo.UbicacionRepository;
import com.mdgz.dam.labdam2022.model.Departamento;

import java.util.UUID;

public final class DepartamentoMapper {
    private DepartamentoMapper() {
    }

    public static DepartamentoEntity toEntity(final Departamento departamento, final UUID alojamientoId) {
        return new DepartamentoEntity(
                alojamientoId,
                departamento.getTieneWifi(),
                departamento.getCostoLimpieza(),
                departamento.getCantidadHabitaciones(),
                alojamientoId,
                departamento.getUbicacion().getId()
        );
    }

    public static Departamento fromEntity(DepartamentoEntity departamento, AlojamientoEntity alojamiento) {
        if(departamento.getId()==null){
            Log.d("asd","asd");
        }
        return new Departamento(
                alojamiento.getId(),
                alojamiento.getTitulo(),
                alojamiento.getDescripcion(),
                alojamiento.getCapacidad(),
                alojamiento.getPrecioBase(),
                departamento.getTieneWifi(),
                departamento.getCostoLimpieza(),
                departamento.getCantidadHabitaciones(),
                UbicacionRepository.recuperarUbicacion(departamento.getUbicacionId())        );
    }
}

package com.mdgz.dam.labdam2022.data.datasource;

import com.mdgz.dam.labdam2022.data.OnResult;
import com.mdgz.dam.labdam2022.model.Reserva;

import java.util.List;
import java.util.UUID;

public interface ReservaDataSource {

    void guardarReserva(Reserva reserva, OnResult<Reserva> callback);

    void recuperarReservas(OnResult<List<Reserva>> callback);

    void eliminarReserva(Reserva reserva, OnResult<Void> callback);

    void existe(UUID id, OnResult<Boolean> callback);
}

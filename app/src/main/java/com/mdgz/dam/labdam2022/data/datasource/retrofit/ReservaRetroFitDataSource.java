package com.mdgz.dam.labdam2022.data.datasource.retrofit;

import com.mdgz.dam.labdam2022.data.OnResult;
import com.mdgz.dam.labdam2022.data.datasource.ReservaDataSource;
import com.mdgz.dam.labdam2022.data.datasource.retrofit.rest.ReservaRest;
import com.mdgz.dam.labdam2022.data.datasource.retrofit.server.AppServer;
import com.mdgz.dam.labdam2022.model.Reserva;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Response;

public class ReservaRetroFitDataSource implements ReservaDataSource {
    private final ReservaRest reservaRest;

    public ReservaRetroFitDataSource(){
        this(AppServer.getInstance());
    }
    public ReservaRetroFitDataSource(AppServer server) {
        reservaRest = server.reservaRest;
    }
    @Override
    public void guardarReserva(Reserva reserva, OnResult<Reserva> callback) {
    }

    @Override
    public void recuperarReservas(OnResult<List<Reserva>> callback) {

        try {
            return reservaRest.listarReservas().execute();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarReserva(Reserva reserva, OnResult<Void> callback) {

    }

    @Override
    public void existe(UUID id, OnResult<Boolean> callback) {

    }
}

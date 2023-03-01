package com.mdgz.dam.labdam2022.data.datasource.retrofit;

import com.mdgz.dam.labdam2022.data.OnResult;
import com.mdgz.dam.labdam2022.data.datasource.ReservaDataSource;
import com.mdgz.dam.labdam2022.data.datasource.retrofit.entities.ReservaRestEntity;
import com.mdgz.dam.labdam2022.data.datasource.retrofit.mapper.ReservaRestMapper;
import com.mdgz.dam.labdam2022.data.datasource.retrofit.rest.ReservaRest;
import com.mdgz.dam.labdam2022.data.datasource.retrofit.server.AppServer;
import com.mdgz.dam.labdam2022.model.Reserva;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
        ReservaRestEntity reservaRestEntity = ReservaRestMapper.toEntity(reserva);
        try {
            Response<ReservaRestEntity> res = reservaRest.crearReserva(reservaRestEntity).execute();
            if(res.isSuccessful()){
                callback.onSuccess(ReservaRestMapper.fromEntity(res.body()));
            }
            else{
                callback.onError(new Exception("Response not Succesfull"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void recuperarReservas(OnResult<List<Reserva>> callback) {

        try {
            Response<List<ReservaRestEntity>> res= reservaRest.listarReservas().execute();
            if(res.isSuccessful()){
                ArrayList<Reserva> reservas = new ArrayList<>();
                for(ReservaRestEntity rre: res.body()){
                    reservas.add(ReservaRestMapper.fromEntity(rre));
                }
            callback.onSuccess(reservas);
            }else{
                callback.onError(new Exception("Response not Succesfull"));
            }

        }catch (Exception e) {
            callback.onError(e);
        }
    }

    @Override
    public void eliminarReserva(Reserva reserva, OnResult<Void> callback) {
        try{
            Response<String> res = reservaRest.eliminarReserva(reserva.getAlojamientoID()).execute();
            if(res.isSuccessful()){
                callback.onSuccess(null);
            }
            else{
                callback.onError(new Exception("Response not Succesfull"));
            }
        } catch (IOException e) {
        callback.onError(e);
        }
    }

    @Override
    public void existe(UUID id, OnResult<Boolean> callback) {
        //TODO (implementacion no necesaria)
    }
}

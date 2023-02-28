package com.mdgz.dam.labdam2022.data.datasource.room;

import android.content.Context;

import com.mdgz.dam.labdam2022.data.OnResult;
import com.mdgz.dam.labdam2022.data.dao.ReservaDAO;
import com.mdgz.dam.labdam2022.data.database.AppDataBase;
import com.mdgz.dam.labdam2022.data.datasource.ReservaDataSource;
import com.mdgz.dam.labdam2022.data.entities.ReservaEntity;
import com.mdgz.dam.labdam2022.data.mappers.ReservaMapper;
import com.mdgz.dam.labdam2022.model.Reserva;
import com.mdgz.dam.labdam2022.data.repo.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ReservaRoomDataSource implements ReservaDataSource {
    private final ReservaDAO reservaDAO;

    public ReservaRoomDataSource(final Context context) {
        this(AppDataBase.getInstance(context));
    }

    public ReservaRoomDataSource(final AppDataBase db) {
        reservaDAO = db.reservaDAO();
    }

    public void guardarReserva(final Reserva reserva, final OnResult<Reserva> callback){
        try {
            final ReservaEntity re = ReservaMapper.toEntity(reserva);
            reservaDAO.insertar(re);
            callback.onSuccess(reserva);
        } catch( final Exception e){
            callback.onError(e);
        }
    }
    public void recuperarReservas(final OnResult<List<Reserva>> callback){
        try{
            final ReservaEntity[] reCollection = reservaDAO.recuperarReservas();
            final List<Reserva> reservas = new ArrayList();
            for (final ReservaEntity re: reCollection){
                reservas.add(ReservaMapper.fromEntity(re));
            }
            callback.onSuccess(reservas);
        }catch (Exception e){
            callback.onError(e);
        }
    }
    public void eliminarReserva(final Reserva reserva, final OnResult<Void> callback){
    try{
        reservaDAO.eliminar(ReservaMapper.toEntity(reserva));
        callback.onSuccess(null);
    }catch(Exception e){
        callback.onError(e);
    }
    }
    public void existe(final UUID alojamientoID, final OnResult<Boolean> callback) {
        try {
            if (reservaDAO.rescuperarReservas(alojamientoID, UserRepository.currentUserId()).length>0)
                callback.onSuccess(true);
            else {
                callback.onSuccess(false);
            }
        } catch (final Exception e) {
            callback.onError(e);
        }
    }}

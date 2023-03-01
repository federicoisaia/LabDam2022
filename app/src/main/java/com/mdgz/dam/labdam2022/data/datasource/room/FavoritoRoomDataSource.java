package com.mdgz.dam.labdam2022.data.datasource.room;

import android.content.Context;

import com.mdgz.dam.labdam2022.data.OnResult;
import com.mdgz.dam.labdam2022.data.datasource.room.dao.FavoritoDAO;
import com.mdgz.dam.labdam2022.data.datasource.room.database.AppDataBase;
import com.mdgz.dam.labdam2022.data.datasource.FavoritoDataSource;
import com.mdgz.dam.labdam2022.data.datasource.room.entities.FavoritoEntity;
import com.mdgz.dam.labdam2022.data.datasource.room.mappers.FavoritoMapper;
import com.mdgz.dam.labdam2022.model.Favorito;

import java.util.LinkedList;
import java.util.List;
public class FavoritoRoomDataSource implements FavoritoDataSource {
    private final FavoritoDAO favoritoDAO;

    public FavoritoRoomDataSource(final Context context) {
        this(AppDataBase.getInstance(context));
    }
    public FavoritoRoomDataSource(final AppDataBase db) {
        favoritoDAO = db.favoritoDAO();
    }
    public void guardarFavorito(final Favorito favorito, final OnResult<Favorito> callback) {
        try {
            final FavoritoEntity f = FavoritoMapper.toEntity(favorito);
            favoritoDAO.insertar(f);
            callback.onSuccess(favorito);
        } catch (final Exception e) {
            callback.onError(e);
        }
    }
    public void recuperarFavoritos (final OnResult<List<Favorito>> callback) {
        try {
            final FavoritoEntity[] fCollection = favoritoDAO.recuperarFavoritos();
        final List<Favorito> favoritos = new LinkedList<>();
        for (final FavoritoEntity fe : fCollection) {
            favoritos.add(FavoritoMapper.fromEntity(fe));
        }
        callback.onSuccess(favoritos);
    }
         catch (final Exception e) {
             callback.onError(e);
         }
    }
    public void eliminarFavorito(final Favorito favorito,final OnResult<Void> callback){
        try {
            favoritoDAO.eliminar(FavoritoMapper.toEntity(favorito));
            callback.onSuccess(null);
        }catch (final Exception e){
            callback.onError(e);
        }
    }

    public void existe(final Favorito favorito, final OnResult<Boolean> callback) {
        try {
            FavoritoEntity fe = FavoritoMapper.toEntity(favorito);
            if (favoritoDAO.recuperarFavorito(fe.getAlojamientoID(), fe.getUsuarioID()) != null)
                callback.onSuccess(true);
            else {
                callback.onSuccess(false);
            }
        } catch (final Exception e) {
            callback.onError(e);
        }
    }

}

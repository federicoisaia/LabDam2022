package com.mdgz.dam.labdam2022.data.datasource.retrofit;

import com.mdgz.dam.labdam2022.data.OnResult;
import com.mdgz.dam.labdam2022.data.datasource.FavoritoDataSource;
import com.mdgz.dam.labdam2022.data.datasource.retrofit.entities.FavoritoRestEntity;
import com.mdgz.dam.labdam2022.data.datasource.retrofit.mapper.FavoritoRestMapper;
import com.mdgz.dam.labdam2022.data.datasource.retrofit.rest.FavoritoRest;
import com.mdgz.dam.labdam2022.data.datasource.retrofit.server.AppServer;
import com.mdgz.dam.labdam2022.model.Favorito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

public class FavoritoRetrofitDataSourse implements FavoritoDataSource {
    private final FavoritoRest favoritoRest;

    public FavoritoRetrofitDataSourse(){
        this(AppServer.getInstance());
    }
    public FavoritoRetrofitDataSourse(AppServer server) {
        favoritoRest = server.favoritoRest;
    }
    @Override
    public void guardarFavorito(Favorito favorito, OnResult<Favorito> callback) {
        FavoritoRestEntity favoritoRestEntity = FavoritoRestMapper.toEntity(favorito);
        try {
            Response<FavoritoRestEntity> res = favoritoRest.crearFavorito(favoritoRestEntity).execute();
            if(res.isSuccessful()){
                callback.onSuccess(FavoritoRestMapper.fromEntity(res.body()));
            }
            else{
                callback.onError(new Exception("Response not Succesfull "+res.code()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarFavorito(Favorito favorito, OnResult<Void> callback) {
        try{
            Response<String> res = favoritoRest.eliminarFavorito(favorito.getAlojamientoId()).execute();
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
    public void existe(Favorito favorito, OnResult<Boolean> callback) {
    OnResult<List<Favorito>> favoritosCallback = new OnResult<List<Favorito>>() {
        @Override
        public void onSuccess(List<Favorito> result) {
            if(result.contains(favorito)){
                callback.onSuccess(true);
            }else{
                callback.onSuccess(false);
            }
        }

        @Override
        public void onError(Throwable exception) {
            callback.onError(exception);
        }
    };
    recuperarFavoritos(favoritosCallback);
    }

    @Override
    public void recuperarFavoritos(OnResult<List<Favorito>> callback) {


        try {
            Response<List<FavoritoRestEntity>> res= favoritoRest.listarFavoritos().execute();
            if(res.isSuccessful()){
                ArrayList<Favorito> favoritos = new ArrayList<>();
                for(FavoritoRestEntity fre: res.body()){
                    favoritos.add(FavoritoRestMapper.fromEntity(fre));
                }
                callback.onSuccess(favoritos);
            }else{
                callback.onError(new Exception("Response not Succesfull"));
            }

        }catch (Exception e) {
            callback.onError(e);
        }
    }
}

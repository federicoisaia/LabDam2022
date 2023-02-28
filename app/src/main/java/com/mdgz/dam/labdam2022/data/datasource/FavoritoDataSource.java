package com.mdgz.dam.labdam2022.data.datasource;

import com.mdgz.dam.labdam2022.data.OnResult;
import com.mdgz.dam.labdam2022.model.Favorito;

import java.util.List;

public interface FavoritoDataSource {

    void guardarFavorito(Favorito favorito, OnResult<Favorito> callback);

    void eliminarFavorito(Favorito favorito, OnResult<Void> callback);

    void existe(Favorito favorito, OnResult<Boolean> callback);

    void recuperarFavoritos( OnResult<List<Favorito>> callback);

}

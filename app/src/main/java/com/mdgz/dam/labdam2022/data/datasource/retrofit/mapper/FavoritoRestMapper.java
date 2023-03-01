package com.mdgz.dam.labdam2022.data.datasource.retrofit.mapper;

import com.mdgz.dam.labdam2022.data.datasource.retrofit.entities.FavoritoRestEntity;
import com.mdgz.dam.labdam2022.model.Favorito;

public class FavoritoRestMapper {
    private FavoritoRestMapper() {
    }

    public static FavoritoRestEntity toEntity(final Favorito favorito){
        return new FavoritoRestEntity(favorito.getAlojamientoId(),favorito.getUsuarioId());
    }
    public static Favorito fromEntity(final FavoritoRestEntity favoritoRest){
        return new Favorito(favoritoRest.getAlojamientoId(), favoritoRest.getUsuarioId());
    }
}

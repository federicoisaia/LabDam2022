package com.mdgz.dam.labdam2022.data.mappers;

import com.mdgz.dam.labdam2022.data.entities.FavoritoEntity;
import com.mdgz.dam.labdam2022.model.Favorito;

public class FavoritoMapper {
    private FavoritoMapper(){
    }
    public static FavoritoEntity toEntity(final Favorito favorito){
        return new FavoritoEntity(favorito.getAlojamientoID(),
                favorito.getUsuarioID()
        );
    }
    public static Favorito fromEntity(FavoritoEntity favoritoEntity){
        return new Favorito(
                favoritoEntity.getAlojamientoID(),
                favoritoEntity.getUsuarioID());
    }
}

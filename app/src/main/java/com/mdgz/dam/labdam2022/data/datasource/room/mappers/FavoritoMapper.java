package com.mdgz.dam.labdam2022.data.datasource.room.mappers;

import com.mdgz.dam.labdam2022.data.datasource.room.entities.FavoritoEntity;
import com.mdgz.dam.labdam2022.model.Favorito;

public class FavoritoMapper {
    private FavoritoMapper(){
    }
    public static FavoritoEntity toEntity(final Favorito favorito){
        return new FavoritoEntity(favorito.getAlojamientoId(),
                favorito.getUsuarioId()
        );
    }
    public static Favorito fromEntity(FavoritoEntity favoritoEntity){
        return new Favorito(
                favoritoEntity.getAlojamientoID(),
                favoritoEntity.getUsuarioID());
    }
}

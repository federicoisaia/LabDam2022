package com.mdgz.dam.labdam2022.factory;

import android.content.Context;

import com.mdgz.dam.labdam2022.data.datasource.retrofit.FavoritoRetrofitDataSourse;
import com.mdgz.dam.labdam2022.data.datasource.retrofit.ReservaRetroFitDataSource;
import com.mdgz.dam.labdam2022.data.datasource.room.AlojamientoRoomDataSource;
import com.mdgz.dam.labdam2022.data.datasource.room.FavoritoRoomDataSource;
import com.mdgz.dam.labdam2022.data.datasource.room.ReservaRoomDataSource;
import com.mdgz.dam.labdam2022.data.repo.AlojamientoRepository;
import com.mdgz.dam.labdam2022.data.repo.UserRepository;

import java.util.UUID;

public final class AlojamientoRepositoryFactory {
    //Lo ideal sería que esto sea una SharedPreference.
    private static Boolean retroFit=false;
    private AlojamientoRepositoryFactory() {
    }

    public static AlojamientoRepository create(final Context context) {
        final UUID currentUserId = UserRepository.currentUserId();
        if(retroFit){
            return new AlojamientoRepository(
                    new AlojamientoRoomDataSource(context),
                    new FavoritoRetrofitDataSourse(),
                    new ReservaRetroFitDataSource()
            );
        }else {
            return new AlojamientoRepository(
                    new AlojamientoRoomDataSource(context),
                    new FavoritoRoomDataSource(context),
                    new ReservaRoomDataSource(context)
            );
        }
    }
}

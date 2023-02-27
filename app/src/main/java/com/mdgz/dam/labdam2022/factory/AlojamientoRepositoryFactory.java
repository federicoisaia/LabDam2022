package com.mdgz.dam.labdam2022.factory;

import android.content.Context;

import com.mdgz.dam.labdam2022.data.datasource.room.AlojamientoRoomDataSource;
import com.mdgz.dam.labdam2022.data.datasource.room.FavoritoRoomDataSource;
import com.mdgz.dam.labdam2022.data.datasource.room.ReservaRoomDataSource;
import com.mdgz.dam.labdam2022.data.repo.AlojamientoRepository;
import com.mdgz.dam.labdam2022.data.repo.UserRepository;

import java.util.UUID;

public final class AlojamientoRepositoryFactory {
    private AlojamientoRepositoryFactory() {
    }

    public static AlojamientoRepository create(final Context context) {
        final UUID currentUserId = UserRepository.currentUserId();
        return new AlojamientoRepository(
                new AlojamientoRoomDataSource(context),
                new FavoritoRoomDataSource(context),
                new ReservaRoomDataSource(context)
        );
    }}

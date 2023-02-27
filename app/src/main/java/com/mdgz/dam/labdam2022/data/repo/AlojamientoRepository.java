package com.mdgz.dam.labdam2022.data.repo;

import com.mdgz.dam.labdam2022.data.OnResult;
import com.mdgz.dam.labdam2022.data.datasource.AlojamientoDataSource;
import com.mdgz.dam.labdam2022.data.datasource.FavoritoDataSource;
import com.mdgz.dam.labdam2022.data.datasource.ReservaDataSource;
import com.mdgz.dam.labdam2022.model.Alojamiento;
import com.mdgz.dam.labdam2022.model.Departamento;
import com.mdgz.dam.labdam2022.model.Favorito;
import com.mdgz.dam.labdam2022.model.Habitacion;
import com.mdgz.dam.labdam2022.model.Reserva;

import java.util.ArrayList;
import java.util.List;

public class AlojamientoRepository {
    final AlojamientoDataSource alojamientoDataSource;
    final FavoritoDataSource favoritoDataSource;
    final ReservaDataSource reservaDataSource;

    public AlojamientoRepository(final AlojamientoDataSource alojamientoDataSource,
                                 final FavoritoDataSource favoritoDataSource, final ReservaDataSource reservaDataSource) {
        this.alojamientoDataSource = alojamientoDataSource;
        this.favoritoDataSource = favoritoDataSource;
        this.reservaDataSource = reservaDataSource;
    }

    public void guardarHabitacion(final Habitacion habitacion, final OnResult<Habitacion> callback) {
        alojamientoDataSource.guardarHabitacion(habitacion, callback);
    }

    public void guardarDepartamento(final Departamento departamento, final OnResult<Departamento> callback) {
        alojamientoDataSource.guardarDepartamento(departamento, callback);
    }

    public void recuperarHabitaciones(final OnResult<List<Habitacion>> callback) {
        alojamientoDataSource.recuperarHabitaciones(callback);
    }

    public void recuperarDepartamentos(final OnResult<List<Departamento>> callback) {
        alojamientoDataSource.recuperarDepartamentos(callback);
    }

    public void recuperarAlojamientos(final OnResult<List<Alojamiento>> callback) {
        alojamientoDataSource.recuperarAlojamientos(callback);
    }

    public void recuperarFavoritos(final OnResult<List<Alojamiento>> callback) {
        favoritoDataSource.recuperarFavoritos(new OnResult<List<Favorito>>() {
            @Override
            public void onSuccess(final List<Favorito> favoritos) {
                alojamientoDataSource.recuperarAlojamientos(new OnResult<List<Alojamiento>>() {
                    @Override
                    public void onSuccess(final List<Alojamiento> alojamientos) {
                        final List<Alojamiento> alojamientosFavoritos = new ArrayList<>();
                        for (final Alojamiento alojamiento : alojamientos) {
                            for (final Favorito favorito : favoritos) {
                                if (favorito.getAlojamientoID().equals(alojamiento.getId())) {
                                    alojamientosFavoritos.add(alojamiento);
                                    break;
                                }
                            }
                        }
                        callback.onSuccess(alojamientosFavoritos);
                    }

                    @Override
                    public void onError(final Throwable exception) {
                        callback.onError(exception);
                    }
                });
            }

            @Override
            public void onError(final Throwable exception) {
                callback.onError(exception);
            }
        });
    }

    public void agregarFavorito(final Alojamiento alojamiento, final OnResult<Favorito> callback) {
        favoritoDataSource.guardarFavorito(new Favorito(alojamiento.getId(), UserRepository.currentUserId()), callback);
    }

    public void quitarFavorito(final Alojamiento alojamiento, final OnResult<Void> callback) {
        favoritoDataSource.eliminarFavorito(new Favorito(alojamiento.getId(), UserRepository.currentUserId()), callback);
    }

    public void esFavorito(final Alojamiento alojamiento, final OnResult<Boolean> callback) {
        favoritoDataSource.existe(new Favorito(alojamiento.getId(), UserRepository.currentUserId()), callback);
    }

    public void recuperarReservas(final OnResult<List<Alojamiento>> callback) {
        reservaDataSource.recuperarReservas(new OnResult<List<Reserva>>() {
            @Override
            public void onSuccess(final List<Reserva> reservas) {
                alojamientoDataSource.recuperarAlojamientos(new OnResult<List<Alojamiento>>() {
                    @Override
                    public void onSuccess(final List<Alojamiento> alojamientos) {
                        final List<Alojamiento> alojamientosFavoritos = new ArrayList<>();
                        for (final Alojamiento alojamiento : alojamientos) {
                            for (final Reserva reserva : reservas) {
                                if (reserva.getAlojamientoID().equals(alojamiento.getId())) {
                                    alojamientosFavoritos.add(alojamiento);
                                    break;
                                }
                            }
                        }
                        callback.onSuccess(alojamientosFavoritos);
                    }

                    @Override
                    public void onError(final Throwable exception) {
                        callback.onError(exception);
                    }
                });
            }

            @Override
            public void onError(final Throwable exception) {
                callback.onError(exception);
            }
        });
    }

    public void agregarReserva(final Reserva reserva ,
                        final OnResult<Reserva> callback) {
        reservaDataSource.guardarReserva(reserva, callback);
    }

    void quitarReserva(final Reserva reserva, final OnResult<Void> callback) {
        reservaDataSource.eliminarReserva(reserva, callback);
    }

    void estaReservado(final Alojamiento alojamiento, final OnResult<Boolean> callback) {
        reservaDataSource.existe(alojamiento.getId(), callback);
    }}

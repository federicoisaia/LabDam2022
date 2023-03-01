package com.mdgz.dam.labdam2022.data.datasource.retrofit.rest;

import com.mdgz.dam.labdam2022.model.Favorito;
import com.mdgz.dam.labdam2022.model.Reserva;

import java.util.List;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface FavoritoRest {
    @Headers("Authorization: Basic UkFORzoxMjM0NQ==")
    @GET("favorito")
    Call<List<Reserva>> listarReservas();

    @Headers("Authorization: Basic UkFORzoxMjM0NQ==")
    @POST("favorito")
    Call<Reserva> crearReserva(@Body Favorito f);

    @Headers("Authorization: Basic UkFORzoxMjM0NQ==")
    @DELETE("favorito")
    Call<String> eliminarFavorito(@Query("alojamientoid") UUID alojamientoId);
}

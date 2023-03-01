package com.mdgz.dam.labdam2022.data.datasource.retrofit.rest;

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

public interface ReservaRest {
    @Headers("Authorization: Basic UkFORzoxMjM0NQ==")
    @GET("reserva")
    Call<List<Reserva>> listarReservas();

    @Headers("Authorization: Basic UkFORzoxMjM0NQ==")
    @POST("reserva")
    Call<Reserva> crearReserva(@Body Reserva r);

    @Headers("Authorization: Basic UkFORzoxMjM0NQ==")
    @DELETE("reserva")
    Call<String> eliminarReserva(@Query("alojamientoId") UUID alojamientoId);

}

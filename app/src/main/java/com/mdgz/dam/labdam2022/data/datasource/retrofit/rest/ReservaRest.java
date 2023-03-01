package com.mdgz.dam.labdam2022.data.datasource.retrofit.rest;

import com.mdgz.dam.labdam2022.data.datasource.retrofit.entities.ReservaRestEntity;

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
    @Headers("Authorization: Basic ZmVkZXJpY286ZmVkZXJpY28=")
    @GET("reserva")
    Call<List<ReservaRestEntity>> listarReservas();

    @Headers("Authorization: Basic ZmVkZXJpY286ZmVkZXJpY28=")
    @POST("reserva")
    Call<ReservaRestEntity> crearReserva(@Body ReservaRestEntity r);

    @Headers("Authorization: Basic ZmVkZXJpY286ZmVkZXJpY28=")
    @DELETE("reserva")
    Call<String> eliminarReserva(@Query("alojamientoId") UUID alojamientoId);

}

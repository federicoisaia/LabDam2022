package com.mdgz.dam.labdam2022.data.datasource.retrofit.rest;

import com.mdgz.dam.labdam2022.data.datasource.retrofit.entities.FavoritoRestEntity;

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
    @Headers("Authorization: Basic ZmVkZXJpY286ZmVkZXJpY28=")
    @GET("favorito")
    Call<List<FavoritoRestEntity>> listarFavoritos();

    @Headers("Authorization: Basic ZmVkZXJpY286ZmVkZXJpY28=")
    @POST("favorito")
    Call<FavoritoRestEntity> crearFavorito(@Body FavoritoRestEntity f);

    @Headers("Authorization: Basic ZmVkZXJpY286ZmVkZXJpY28=")
    @DELETE("favorito")
    Call<String> eliminarFavorito(@Query("alojamientoid") UUID alojamientoId);


}

package com.mdgz.dam.labdam2022.data.datasource.retrofit.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mdgz.dam.labdam2022.data.datasource.retrofit.adapter.GsonIsoDateAdapter;
import com.mdgz.dam.labdam2022.data.datasource.retrofit.rest.FavoritoRest;
import com.mdgz.dam.labdam2022.data.datasource.retrofit.rest.ReservaRest;

import java.util.Date;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppServer {
    private static final String DATABASE_NAME = "db_sistema_alojamientos";
    private static AppServer instance;

    public FavoritoRest favoritoRest;
    public ReservaRest reservaRest;

    public static  AppServer getInstance() {
        if (instance == null) {
            instance = new AppServer();
        }
        return instance;
    }
    public AppServer(){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Date.class, new GsonIsoDateAdapter())
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dam-recordatorio-favoritos-api.duckdns.org/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
        reservaRest= retrofit.create(ReservaRest.class);
        favoritoRest= retrofit.create(FavoritoRest.class);
    }
}

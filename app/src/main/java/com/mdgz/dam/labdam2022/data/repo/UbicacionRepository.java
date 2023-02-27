package com.mdgz.dam.labdam2022.data.repo;

import com.mdgz.dam.labdam2022.model.Ubicacion;

import java.util.List;

public class UbicacionRepository {
    private static final Ubicacion ubicacion1 = new Ubicacion(1, -42.6,-38.3,"San Martin","1989",CiudadRepository._CIUDADES.get(0));
    private static final Ubicacion ubicacion2 = new Ubicacion(2,-42.25,-38.2,"Lopez y Planes","2007",CiudadRepository._CIUDADES.get(1));
    private static final Ubicacion ubicacion3 = new Ubicacion(3,-42.9,-38.7,"9 de Julio","5000",CiudadRepository._CIUDADES.get(0));
    private static final Ubicacion ubicacion4 = new Ubicacion(4,-42.3,-38.9,"4 de Enero","2840",CiudadRepository._CIUDADES.get(0));
    private static final Ubicacion ubicacion5 = new Ubicacion(5,-42.5,-38.9,"4 de Enero","2478",CiudadRepository._CIUDADES.get(3));
    private static final Ubicacion ubicacion6 = new Ubicacion(6,-42.5,-39.5,"1° de Mayo","4978",CiudadRepository._CIUDADES.get(2));
    private static final Ubicacion ubicacion7 = new Ubicacion(7,-41.8,-37.9,"Av. Freyre","3268",CiudadRepository._CIUDADES.get(2));
    private static final Ubicacion ubicacion8 = new Ubicacion(8,-42.7,-39.0,"Urquiza","2968",CiudadRepository._CIUDADES.get(2));
    private static final Ubicacion ubicacion9 = new Ubicacion(9,-40.8,-39.7,"Belgrano","2287",CiudadRepository._CIUDADES.get(3));




    private static final List<Ubicacion> _UBICACIONES = List.of(ubicacion1, ubicacion2,ubicacion3,ubicacion4,ubicacion5,ubicacion6,ubicacion7,ubicacion8,ubicacion9);
    public List<Ubicacion> listaUbicaciones(){
        return  _UBICACIONES;
    }

    public static Ubicacion recuperarUbicacion(Integer id){
        for (Ubicacion u:_UBICACIONES){
            if(u.getId().equals(id))return u;
        }
        return null;
    }

}

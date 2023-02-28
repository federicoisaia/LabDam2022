package com.mdgz.dam.labdam2022.data.repo;

import com.mdgz.dam.labdam2022.model.Hotel;

import java.util.List;

public class HotelRepository {
        public static final Hotel hotel1 = new Hotel(1,"Hotel 1",3, UbicacionRepository.recuperarUbicacion(1));
        public static final Hotel hotel2 = new Hotel(2,"Hotel 2",3, UbicacionRepository.recuperarUbicacion(2));

    private static final List<Hotel> _HOTELES = List.of(hotel1, hotel2);

    public List<Hotel> listaHoteles(){
        return  _HOTELES;
    }
    public static Hotel recuperarHotel(Integer id){
        for (Hotel h:_HOTELES){
            if(h.getId()==id)return h;
        }
        return null;
    }
}

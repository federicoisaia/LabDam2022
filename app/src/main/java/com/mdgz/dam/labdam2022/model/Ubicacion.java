package com.mdgz.dam.labdam2022.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Ubicacion implements Parcelable {
    private Integer id;
    private double lat;
    private double lng;
    private String calle;
    private String numero;
    private Ciudad ciudad;

    public Ubicacion(){

    }

    public Ubicacion(Integer id, double lat, double lng, String calle, String numero, Ciudad ciudad) {
        this.id = id;
        this.lat = lat;
        this.lng = lng;
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
    }

    protected Ubicacion(Parcel in) {
        this.id= in.readInt();
        this.lat = in.readDouble();
        this.lng = in.readDouble();
        this.calle = in.readString();
        this.numero = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeDouble(lat);
        dest.writeDouble(lng);
        dest.writeString(calle);
        dest.writeString(numero);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Ubicacion> CREATOR = new Creator<Ubicacion>() {
        @Override
        public Ubicacion createFromParcel(Parcel in) {
            return new Ubicacion(in);
        }

        @Override
        public Ubicacion[] newArray(int size) {
            return new Ubicacion[size];
        }
    };

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    public String toString(){
        return getCalle()+" "+ getNumero()+", "+ getCiudad();
    }


}

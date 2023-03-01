package com.mdgz.dam.labdam2022.UI.adaptadoresRV;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.mdgz.dam.labdam2022.R;
import com.mdgz.dam.labdam2022.model.Alojamiento;
import com.mdgz.dam.labdam2022.model.Departamento;

import java.text.DecimalFormat;
import java.util.List;

public class FavoritosRecyclerAdapter extends RecyclerView.Adapter<FavoritosRecyclerAdapter.AlojamientosViewHolder> {
    private List<Alojamiento> dataAlojamientos ;
    Bundle bundle= new Bundle();
    public static class AlojamientosViewHolder extends RecyclerView.ViewHolder{
        CardView card;
        TextView titulo;
        TextView precio;
        ImageView imgTipo;
        ImageView imgFav;
        TextView capacidad;

        public AlojamientosViewHolder(@NonNull View itemView) {

            super(itemView);
            card = itemView.findViewById(R.id.card_view_alojamiento);
            titulo = itemView.findViewById(R.id.titulo_card_alojamiento);
            precio = itemView.findViewById(R.id.texto_precio);
            imgTipo=itemView.findViewById(R.id.imagen_tipo);
            imgFav= itemView.findViewById(R.id.img_favorito);
            capacidad=itemView.findViewById(R.id.texto_capacidad);




        }
    }

    public FavoritosRecyclerAdapter(List<Alojamiento> data) {
        dataAlojamientos=data;
    }

    @NonNull
    @Override
    public AlojamientosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_busqueda_alojamiento, parent, false);
        AlojamientosViewHolder vh = new AlojamientosViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AlojamientosViewHolder holder, @SuppressLint("RecyclerView") int position) {

    Alojamiento alojamiento = dataAlojamientos.get(position);

        completarHolder(holder, alojamiento, position);

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bundle.putParcelable("alojamiento_seleccionado",alojamiento);
                bundle.putBoolean("es_favorito", true);
                Navigation.findNavController(view).navigate(R.id.to_detalleAlojamientoFragment,bundle);

            }
        });


    }

    private void completarHolder(AlojamientosViewHolder holder, Alojamiento alojamiento, int position) {
        if(alojamiento instanceof  Departamento)
            holder.imgTipo.setImageResource(R.drawable.ic_baseline_apartment_24);
        else holder.imgTipo.setImageResource(R.drawable.ic_baseline_hotel_24);

        holder.titulo.setText(alojamiento.getTitulo());
        DecimalFormat format= new DecimalFormat();
        format.setMaximumFractionDigits(2);
        holder.precio.setText("$ "+format.format(alojamiento.getPrecioBase()));
        holder.capacidad.setText((alojamiento.getCapacidad().toString()));
        holder.imgFav.setImageResource(R.drawable.ic_baseline_star_24);




    }


    @Override
    public int getItemCount() {
        return dataAlojamientos.size();
    }


}

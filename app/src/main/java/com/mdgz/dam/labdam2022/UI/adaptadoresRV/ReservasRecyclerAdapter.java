package com.mdgz.dam.labdam2022.UI.adaptadoresRV;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.mdgz.dam.labdam2022.R;
import com.mdgz.dam.labdam2022.data.OnResult;
import com.mdgz.dam.labdam2022.data.database.AppDataBase;
import com.mdgz.dam.labdam2022.factory.AlojamientoRepositoryFactory;
import com.mdgz.dam.labdam2022.model.Reserva;

import java.text.DecimalFormat;
import java.util.List;

public class ReservasRecyclerAdapter extends RecyclerView.Adapter<ReservasRecyclerAdapter.ReservasViewHolder> {
    private List<Reserva> dataReserva ;
    Bundle bundle= new Bundle();
    public static class ReservasViewHolder extends RecyclerView.ViewHolder{
        CardView card;
        TextView titulo;
        TextView precio;
        TextView desde;
        TextView hasta;
        ImageButton eliminar;

        public ReservasViewHolder(@NonNull View itemView) {

            super(itemView);
            card = itemView.findViewById(R.id.card_view_reserva);
            titulo = itemView.findViewById(R.id.titulo_alojamiento_reserva);
            precio = itemView.findViewById(R.id.texto_precio_reserva);
            desde = itemView.findViewById(R.id.fecha_desde);
            hasta = itemView.findViewById(R.id.fecha_hasta);
            eliminar = itemView.findViewById(R.id.boton_eliminar);




        }
    }

    public ReservasRecyclerAdapter(List<Reserva> data) {
        dataReserva=data;
    }

    @NonNull
    @Override
    public ReservasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_reserva, parent, false);
        ReservasViewHolder vh = new ReservasViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ReservasViewHolder holder, int position) {
        Reserva reserva = dataReserva.get(position);

        completarHolder(holder, reserva);
        holder.eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO agregar dialogo que confirme que se desea eliminar la reserva.
                OnResult<Void> eliminarCallback = new OnResult<Void>() {
                    @Override
                    public void onSuccess(Void result) {
                    dataReserva.remove(reserva);
                    notifyItemChanged(position);
                    notifyDataSetChanged();

                    }

                    @Override
                    public void onError(Throwable exception) {

                    }
                };
                AppDataBase.EXECUTOR_DB.execute(()->{
                    AlojamientoRepositoryFactory.create(holder.card.getContext()).quitarReserva(reserva,eliminarCallback);
                });
            }
        });
    }


    private void completarHolder(ReservasViewHolder holder, Reserva reserva) {
        holder.titulo.setText(reserva.getTituloAlojamiento());
        DecimalFormat format= new DecimalFormat();
        format.setMaximumFractionDigits(2);
        holder.precio.setText("$ "+format.format(reserva.getMonto()));
        holder.desde.setText("Desde: "+reserva.getFechaEgreso());
        holder.hasta.setText("Hasta: "+reserva.getFechaEgreso());

    }

    @Override
    public int getItemCount() {
        return dataReserva.size();
    }

}

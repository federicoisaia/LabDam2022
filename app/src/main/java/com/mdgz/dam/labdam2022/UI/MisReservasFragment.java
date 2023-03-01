package com.mdgz.dam.labdam2022.UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mdgz.dam.labdam2022.UI.adaptadoresRV.ReservasRecyclerAdapter;
import com.mdgz.dam.labdam2022.databinding.FragmentMisReservasBinding;
import com.mdgz.dam.labdam2022.model.Alojamiento;
import com.mdgz.dam.labdam2022.model.Reserva;

import java.util.ArrayList;

public class MisReservasFragment extends Fragment {
    private FragmentMisReservasBinding binding;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter rvAdapter;

    public MisReservasFragment() {
        // Required empty public constructor
    }


    public static MisReservasFragment newInstance(String param1, String param2) {
        MisReservasFragment fragment = new MisReservasFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMisReservasBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<Reserva> reservas = new ArrayList<>();
        ArrayList<Alojamiento> alojamientos = new ArrayList<>();
        if (getArguments() != null) {
            reservas = getArguments().getParcelableArrayList("reservas");
            alojamientos = getArguments().getParcelableArrayList("alojamientos");

        }
        recyclerView=binding.recyclerReservas;

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);

        rvAdapter = new ReservasRecyclerAdapter(reservas, alojamientos);
        recyclerView.setAdapter(rvAdapter);


    }
}
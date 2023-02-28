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

import com.mdgz.dam.labdam2022.UI.adaptadoresRV.AlojamientosRecyclerAdapter;
import com.mdgz.dam.labdam2022.databinding.FragmentFavoritosBinding;
import com.mdgz.dam.labdam2022.model.Alojamiento;

import java.util.ArrayList;


public class FavoritosFragment extends Fragment {

    private FragmentFavoritosBinding binding;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter rvAdapter;

    public FavoritosFragment() {
        // Required empty public constructor
    }


    public static FavoritosFragment newInstance(String param1, String param2) {
        FavoritosFragment fragment = new FavoritosFragment();
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
        binding = FragmentFavoritosBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<Alojamiento> alojamientos = new ArrayList<>();
        if (getArguments() != null) {
            alojamientos = getArguments().getParcelableArrayList("favoritos");
        }
        recyclerView=binding.recyclerFavoritos;

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);

        rvAdapter = new AlojamientosRecyclerAdapter(alojamientos);
        recyclerView.setAdapter(rvAdapter);


    }
}
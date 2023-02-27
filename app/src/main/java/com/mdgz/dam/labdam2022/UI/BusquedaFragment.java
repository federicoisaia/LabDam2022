package com.mdgz.dam.labdam2022.UI;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.preference.PreferenceManager;

import com.mdgz.dam.labdam2022.R;
import com.mdgz.dam.labdam2022.data.OnResult;
import com.mdgz.dam.labdam2022.data.database.AppDataBase;
import com.mdgz.dam.labdam2022.data.repo.CiudadRepository;
import com.mdgz.dam.labdam2022.databinding.FragmentBusquedaBinding;
import com.mdgz.dam.labdam2022.factory.AlojamientoRepositoryFactory;
import com.mdgz.dam.labdam2022.model.Alojamiento;
import com.mdgz.dam.labdam2022.model.Ciudad;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class BusquedaFragment extends Fragment {

    private FragmentBusquedaBinding binding;
    final String [] tiposAlojamientos=new String[]{"Departamento", "Hotel", "Todos"};
    final List<Ciudad> ciudades = CiudadRepository._CIUDADES;
    private ArrayList<Alojamiento> alojamientos = new ArrayList<>();
    Instant inicioConsulta;
    Instant finConsulta;
    boolean sinResultados=false; //hardcodeado


    public static BusquedaFragment newInstance() {
        BusquedaFragment fragment = new BusquedaFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding =  FragmentBusquedaBinding.inflate(inflater, container,  false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayAdapter<String> adapterAlojamientos = new ArrayAdapter<String>(binding.getRoot().getContext(),
                android.R.layout.simple_spinner_dropdown_item,
                tiposAlojamientos);
        binding.spinnerTipoHospedaje.setAdapter(adapterAlojamientos);
        ArrayAdapter<Ciudad> adapterCiudades = new ArrayAdapter<Ciudad>(binding.getRoot().getContext(),
                android.R.layout.simple_spinner_dropdown_item,
                ciudades);
        binding.spinnerCiudad.setAdapter(adapterCiudades);
        binding.botonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            final OnResult<List<Alojamiento>> alojamientosCallback = new OnResult<List<Alojamiento>>() {
                @Override
                public void onSuccess(List<Alojamiento> result) {
                    alojamientos.addAll(result);
                    finConsulta = Instant.now();
                    requireActivity().runOnUiThread(()->{
                        Bundle bundle = new Bundle();
                        bundle.putParcelableArrayList("alojamientos", alojamientos);
                        NavHostFragment.findNavController(BusquedaFragment.this).navigate(R.id.action_busquedaFragment_to_resultadoBusquedaFragment,bundle);

                    });
                }
                @Override
                public void onError(Throwable exception) {sinResultados=true;}
            };
                 inicioConsulta = Instant.now();
                AppDataBase.EXECUTOR_DB.execute(()-> AlojamientoRepositoryFactory.create(getContext()).recuperarAlojamientos(alojamientosCallback));



            guardarBusquedaEnHistorial();
            }
        });
        binding.botonLimpiarFiltros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpiarfiltros();
            }
        });
    }

    private void guardarBusquedaEnHistorial() {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        if(sharedPrefs.getBoolean("guardado_info",false)) {
            String filename = "datos_uso_app";
            String salida= (new Timestamp(finConsulta.toEpochMilli()-inicioConsulta.toEpochMilli())).toString();
            String conWifi = "no";
            String  tipoHospedaje = binding.spinnerTipoHospedaje.getSelectedItem().toString();
            Integer huespedes;
            if(binding.cantidadPersonas.getText().toString().isEmpty())huespedes=0;
            else  huespedes = Integer.parseInt(binding.cantidadPersonas.getText().toString());
            Boolean wifi = binding.wifi.isChecked();
            verificarRangoPrecio();
            Double precioMax;
            if(binding.precioMaximo.getText().toString().isEmpty())precioMax=100000.0;
            else precioMax = Double.parseDouble(binding.precioMaximo.getText().toString());
            Double precioMin;
            if(binding.precioMinimo.getText().toString().isEmpty()) precioMin=0.0;
            else precioMin = Double.parseDouble(binding.precioMinimo.getText().toString());
            Ciudad destino = (Ciudad) binding.spinnerCiudad.getSelectedItem();
            if (wifi) conWifi = "si";
            salida +="Tipo de Hospedaje: "+tipoHospedaje+" - Cantidad de huéspedes: "+huespedes.toString()+" - con Wifi: "
                    +conWifi+" - Precio Min: "+precioMin+ " - Precio Max: "+precioMax+" - Ciudad: "+destino.toString()+"\n";
            try {
                FileOutputStream fos = getActivity().openFileOutput(filename, Context.MODE_APPEND);
                fos.write(salida.getBytes());
                fos.flush();
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void verificarRangoPrecio( ){
        String maximo = binding.precioMaximo.getText().toString();
        String minimo = binding.precioMinimo.getText().toString();

        if(!maximo.isEmpty() && !minimo.isEmpty()){
            if (Double.parseDouble(minimo) > Double.parseDouble(maximo)) {
                binding.precioMaximo.setText(minimo);
                binding.precioMinimo.setText(maximo);

            }
            return;
        }
    }
    private void limpiarfiltros(){
        binding.spinnerTipoHospedaje.setSelection(0);
        binding.spinnerCiudad.setSelection(0);
        binding.cantidadPersonas.setText("");
        if(binding.wifi.isChecked()) binding.wifi.toggle();
        binding.precioMinimo.setText("");
        binding.precioMaximo.setText("");
    }
}
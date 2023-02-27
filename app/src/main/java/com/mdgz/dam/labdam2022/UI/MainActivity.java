package com.mdgz.dam.labdam2022.UI;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.mdgz.dam.labdam2022.R;
import com.mdgz.dam.labdam2022.data.OnResult;
import com.mdgz.dam.labdam2022.data.database.AppDataBase;
import com.mdgz.dam.labdam2022.databinding.ActivityMainBinding;
import com.mdgz.dam.labdam2022.factory.AlojamientoRepositoryFactory;
import com.mdgz.dam.labdam2022.model.Alojamiento;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(findViewById(R.id.materialToolbar));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        Fragment fragment = binding.fragmentContainerView.getFragment();
         navController = NavHostFragment.findNavController(fragment);
        switch (item.getItemId()){
            case R.id.opcion_configuracion:
                if(navController.getCurrentDestination().getId() != R.id.configuracionFragment) {
                    navController.navigate(R.id.to_configuracionFragment);
                    return true;
                }
            case R.id.opcion_buscar:
                if(navController.getCurrentDestination().getId() != R.id.opcion_buscar){
                    navController.navigate(R.id.to_busquedaFragment);
                }
            case R.id.opcion_favoritos:
                if(navController.getCurrentDestination().getId() != R.id.opcion_buscar){
                    irAFavoritos();
                }
            default:  return false;
        }
    }

    private void irAFavoritos() {
        ArrayList<Alojamiento> favoritos = new ArrayList<>();
        OnResult<List<Alojamiento>> favoritosCallback= new OnResult<List<Alojamiento>>() {
            @Override
            public void onSuccess(List<Alojamiento> result) {
                favoritos.addAll(result);
                runOnUiThread(()->{
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("favoritos", favoritos);
                    navController.navigate(R.id.to_favoritosFragment, bundle);
                });
            }

            @Override
            public void onError(Throwable exception) {

            }
        };

        AppDataBase.EXECUTOR_DB.execute(()->{
            AlojamientoRepositoryFactory.create(getApplicationContext()).recuperarFavoritos(favoritosCallback);
        });
    }

}
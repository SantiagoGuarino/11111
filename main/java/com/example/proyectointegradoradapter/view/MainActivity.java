package com.example.proyectointegradoradapter.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.proyectointegradoradapter.R;
import com.example.proyectointegradoradapter.controller.PeliculaController;
import com.example.proyectointegradoradapter.model.pojo.Genero;
import com.example.proyectointegradoradapter.model.pojo.GeneroContainer;
import com.example.proyectointegradoradapter.model.pojo.Pelicula;
import com.example.proyectointegradoradapter.model.pojo.PeliculaContainer;
import com.example.proyectointegradoradapter.util.ResultListener;
import com.google.android.youtube.player.YouTubePlayerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends  AppCompatActivity implements  MainFragment.SeleccionarGeneroListener
        ,FragmentDetallePeliculas.SeleccionarPeliculaListenerRecycleView
        ,EstrenosFragment.PosicionElegida {
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    private List<com.example.proyectointegradoradapter.model.pojo.Pelicula> peliculasList;
    private List<com.example.proyectointegradoradapter.model.pojo.Pelicula> listaPeliculas = new ArrayList<>();
    private String claveYoutube = "AIzaSyA0xL44e09eiiyD3jgp3SjsyFgTpTxwaP8";
    private  LoadingScene loadingScene;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadingScene = new LoadingScene();
        navigationView=findViewById(R.id.navigationView);
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                OnNavigationItemSelectedSwitch(menuItem);
                return true;
            }
        });
         getGeneros();


    }

    public void pegarFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.MainFragmentContainer, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    public void pegarFragmentLosfing(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.MainFragmentContainer, fragment);
        fragmentTransaction.commit();
    }

    public void getGeneros() {
        PeliculaController peliculaController = new PeliculaController();
        peliculaController.getGeneros(new ResultListener<GeneroContainer>() {
            @Override
            public void finish(GeneroContainer result) {
                cambiarAFragmentMain(result);
            }
        });

    }

    public void OnNavigationItemSelectedSwitch(MenuItem item){
        switch (item.getItemId()){
            case R.id.boton_inicio_menu:
                drawerLayout.closeDrawers();
                EstrenosFragment estrenosFragment = new EstrenosFragment();
                pegarFragment(estrenosFragment);
                break;

            case R.id.boton_recomendados:
                drawerLayout.closeDrawers();
                getGeneros();

                break;
        }
    }



    public void cambiarAFragmentMain(GeneroContainer result){
      Bundle unBundle = new Bundle();
        unBundle.putSerializable(MainFragment.KEY_GENERO, (Serializable) result.getGeneros());
        MainFragment fragmentMain = new MainFragment();
        fragmentMain.setArguments(unBundle);

        pegarFragment(fragmentMain);


    }
   //Esto lo tenemos que usar despues


  /*  @Override
    public void seleccionarPeliculaListenerRecyclerView(String pelicula) {
        Intent intent =  new Intent(MainActivity.this, YoutubeActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(YoutubeActivity.KEY_PEIVULA_NOMBRE,pelicula);
        intent.putExtras(bundle);
        startActivity(intent);
    }*/

  /* @Override
    public void seleccionarListadoPeliculas(List<Pelicula> peliculas) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(FragmentHome.KEY_BUNDLE, (Serializable) peliculas);
        FragmentHome fragmentHome = new FragmentHome();
        fragmentHome.setArguments(bundle);
        pegarFragment(fragmentHome);
    }*/

    @Override
    public void posicionElegidaListener(Integer posicion, List<Pelicula> listaPeliculas) {

        Bundle bundle = new Bundle();
        bundle.putInt(FragmentHome.KEY_POSITION, posicion);
        bundle.putSerializable(FragmentHome.KEY_BUNDLE, (Serializable) listaPeliculas);
        FragmentHome fragmentHome = new FragmentHome();
        fragmentHome.setArguments(bundle);
        pegarFragment(fragmentHome);
    }


    @Override
    public void seleccionarPeliculaListenerRecyclerView(String pelicula) {

    }

    @Override
    public void seleccionarGeneroListener(List<Genero> generos) {
         FragmentEstrenosHome fragmentEstrenosHome = new FragmentEstrenosHome();
         Bundle bundle = new Bundle();
         bundle.putSerializable(FragmentEstrenosHome.KEY_GENERO,(Serializable)generos);
         fragmentEstrenosHome.setArguments(bundle);
         pegarFragment(fragmentEstrenosHome);
    }


}



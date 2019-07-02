package com.example.proyectointegradoradapter.view;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.proyectointegradoradapter.R;
import com.example.proyectointegradoradapter.controller.PeliculaController;
import com.example.proyectointegradoradapter.model.pojo.Genero;
import com.example.proyectointegradoradapter.model.pojo.Pelicula;
import com.example.proyectointegradoradapter.model.pojo.PeliculaContainer;
import com.example.proyectointegradoradapter.util.ResultListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHome extends Fragment {
    final static String KEY_BUNDLE = "paquete";
    final static String KEY_POSITION = "position";
    private ViewPager viewPager;
    private ViewPagerHomeAdapter viewPagerHomeAdapter;

    private View view;
    private Bundle bundle = new Bundle();
    private List<Pelicula>peliculas = new ArrayList<>();
    public FragmentHome() {
        // Required empty public constructor
    }


    /*
    TENEMOS QUE HACER AHORA un PEDIDO RANDOM DE GENEROS donde la cantidad de peliculas a pedir debe tener un maximo de 20 elementos.
    Ej. 4 de Terror + 3 de Suspenso + 1 de Thriller.

     */




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        bundle = getArguments();
         viewPager = view.findViewById(R.id.fragment_home_viewpager);
         viewPagerHomeAdapter = new ViewPagerHomeAdapter(getChildFragmentManager(), (List<Pelicula>) bundle.getSerializable(KEY_BUNDLE));
        Integer position = bundle.getInt(KEY_POSITION);
                //viewPager.setCurrentItem(0);
        viewPager.setAdapter(viewPagerHomeAdapter);
        viewPager.setCurrentItem(position);

        return view;
    }



}

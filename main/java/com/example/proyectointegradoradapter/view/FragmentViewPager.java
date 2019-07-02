package com.example.proyectointegradoradapter.view;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyectointegradoradapter.R;
import com.example.proyectointegradoradapter.model.pojo.Pelicula;
import com.example.proyectointegradoradapter.model.pojo.PeliculaContainer;


public class FragmentViewPager extends Fragment {


    public FragmentViewPager() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view =inflater.inflate(R.layout.fragment_view_pager, container, false);
        Bundle bundle = getArguments();
        ViewPager viewPager = view.findViewById(R.id.view_pager_detalle_pelicula);
        FragmentAdapterViewPagerDetallesPeliculas fragmentAdapterViewPagerDetallesPeliculas = new FragmentAdapterViewPagerDetallesPeliculas(getChildFragmentManager(),Pelicula.getPeliculas() );
        viewPager.setAdapter(fragmentAdapterViewPagerDetallesPeliculas);
        viewPager.setCurrentItem(bundle.getInt("position"));
        return  view;
    }


    }


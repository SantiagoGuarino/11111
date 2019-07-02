package com.example.proyectointegradoradapter.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.proyectointegradoradapter.model.pojo.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerHomeAdapter extends FragmentStatePagerAdapter {
    private List<FragmentDetallePeliculas> listaFragmentDetalle;

    public ViewPagerHomeAdapter(FragmentManager fm,List<Pelicula> listaPeliculas) {
        super(fm);
        this.listaFragmentDetalle=new ArrayList<>();
        for (Pelicula track: listaPeliculas
        ) {
            listaFragmentDetalle.add(FragmentDetallePeliculas.generadorDeFragmentDetallePelicula(track));
        }
    }

    @Override
    public Fragment getItem(int i) {
        return this.listaFragmentDetalle.get(i);
    }

    @Override
    public int getCount() {
        return listaFragmentDetalle.size();
    }
}
package com.example.proyectointegradoradapter.view;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyectointegradoradapter.R;
import com.example.proyectointegradoradapter.controller.PeliculaController;
import com.example.proyectointegradoradapter.model.pojo.Genero;
import com.example.proyectointegradoradapter.model.pojo.Pelicula;
import com.example.proyectointegradoradapter.model.pojo.PeliculaContainer;
import com.example.proyectointegradoradapter.util.ResultListener;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MultiRecyclerGeneroFragment extends Fragment {
    private List<Pelicula> listaDePeliculas;
    private List<Genero> listaDeGeneros;

    public MultiRecyclerGeneroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_multi_recycler_genero, container, false);
        Bundle bundle = getArguments();


        return view;
    }

    public void recyclerList( View view){
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_multi_genero);
        AdapterEstrenosHome adapterGenerosHome = new AdapterEstrenosHome(getContext(), listaDePeliculas);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext()
                , RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapterGenerosHome);
    }
    public void genreListIterator(View view){
        for (Genero track: listaDeGeneros){
            getPeliculaPorGenero(track);
            recyclerList(view);
        }
    }

    public void getPeliculaPorGenero(final Genero genero){
        PeliculaController peliculaController = new PeliculaController();
        peliculaController.getPeliculasConGeneros(Integer.parseInt(genero.getId()), new ResultListener<PeliculaContainer>() {
            @Override
            public void finish(PeliculaContainer result) {
                listaDePeliculas=result.getPeliculas();
                //recyclerView.setAdapter(fragmentMainAdapter);
                // fragmentMainAdapter.setPeliculas(result.getPeliculas());
                /*listagenero.remove(0);

                if(listagenero.size()>0){
                    arrangeGenero(listagenero);
                }*/
            }
        });
    }


}

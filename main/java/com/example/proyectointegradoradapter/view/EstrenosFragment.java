package com.example.proyectointegradoradapter.view;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyectointegradoradapter.R;
import com.example.proyectointegradoradapter.controller.PeliculaController;
import com.example.proyectointegradoradapter.model.pojo.Pelicula;
import com.example.proyectointegradoradapter.model.pojo.PeliculaContainer;
import com.example.proyectointegradoradapter.util.ResultListener;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EstrenosFragment extends Fragment implements EstrenosFragmentAdapter.SeleccionarPeliculasListener{
private EstrenosFragmentAdapter adapter;
private  RecyclerView recyclerView;
private  PosicionElegida posicionElegidalistener;
    public EstrenosFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        posicionElegidalistener=(PosicionElegida)context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_estrenos, container, false);
        /* recyclerView = view.findViewById(R.id.recyclerViewPeliculasEstreno);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2, LinearLayoutManager.VERTICAL,false));
        adapter =new EstrenosFragmentAdapter(this);
        getPeliculasEstreno();*/
        return  view;
    }

    public void getPeliculasEstreno(){
        PeliculaController peliculaController = new PeliculaController();
        peliculaController.getPersonajes(new ResultListener<PeliculaContainer>() {
            @Override
            public void finish(PeliculaContainer result) {
            adapter.setGeneros(result.getPeliculas());
            recyclerView.setAdapter(adapter);
            }
        });

    }




    @Override
    public void seleccionarPeliculas(Integer position, List<Pelicula> listPeliculas) {
        posicionElegidalistener.posicionElegidaListener(position,listPeliculas);
    }

    public interface PosicionElegida{
        public void posicionElegidaListener(Integer posicion, List<Pelicula> listPeliculas);
    }

}

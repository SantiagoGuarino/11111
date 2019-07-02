package com.example.proyectointegradoradapter.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.proyectointegradoradapter.R;
import com.example.proyectointegradoradapter.controller.PeliculaController;
import com.example.proyectointegradoradapter.model.pojo.Genero;
import com.example.proyectointegradoradapter.model.pojo.Pelicula;
import com.example.proyectointegradoradapter.model.pojo.PeliculaContainer;
import com.example.proyectointegradoradapter.util.ResultListener;

import java.util.ArrayList;
import java.util.List;

public class AdapterGenerosHome extends RecyclerView.Adapter<AdapterGenerosHome.RecyclerViewAdapterGenerosHome> {
    private List<Genero> listaGenero;
    private List<Pelicula> listaPeliculas;
    private Context context;


    public void setPeliculas(List<Genero> generos) {
        this.listaGenero = generos;
        notifyDataSetChanged();
    }


    public AdapterGenerosHome(Context context, List<Genero> generos) {
        this.listaGenero = new ArrayList<>();
        this.listaPeliculas = new ArrayList<>();
        this.listaGenero = generos;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterGenerosHome onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.celda_recycleview_secundario, viewGroup, false);
        RecyclerViewAdapterGenerosHome fragmentMainRecyclerView = new RecyclerViewAdapterGenerosHome(view);
        return fragmentMainRecyclerView;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterGenerosHome recyclerViewAdapterGenerosHome, int i) {
        recyclerViewAdapterGenerosHome.bindPelicula(listaGenero.get(i));
    }

    @Override
    public int getItemCount() {
        return listaGenero.size();
    }

    public class RecyclerViewAdapterGenerosHome extends RecyclerView.ViewHolder {

        private RecyclerView recyclerView;
        private AdapterEstrenosHome fragmentMainAdapter;



        public RecyclerViewAdapterGenerosHome(@NonNull View itemView) {
            super(itemView);
            // View view=  inflater.inflate(R.layout.celda_recyclerview_estrenos, container, false);
            recyclerView = itemView.findViewById(R.id.recyclerview_celdaRecycler);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

        }

        public void bindPelicula(Genero genero) {
            recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            getPeliculaPorGenero(genero);

        }

        public void getPeliculaPorGenero(final Genero genero) {
            PeliculaController peliculaController = new PeliculaController();
            peliculaController.getPeliculasConGeneros(Integer.parseInt(genero.getId()), new ResultListener<PeliculaContainer>() {
                @Override
                public void finish(PeliculaContainer result) {
                    fragmentMainAdapter = new AdapterEstrenosHome(context, result.getPeliculas());
                    recyclerView.setAdapter(fragmentMainAdapter);

                }
            });
        }
    }

}

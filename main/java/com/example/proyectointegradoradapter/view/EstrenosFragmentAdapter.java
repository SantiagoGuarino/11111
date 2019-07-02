package com.example.proyectointegradoradapter.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.proyectointegradoradapter.R;
import com.example.proyectointegradoradapter.model.pojo.Genero;
import com.example.proyectointegradoradapter.model.pojo.Pelicula;

import java.util.List;

public class EstrenosFragmentAdapter extends RecyclerView.Adapter<EstrenosFragmentAdapter.RecyclerView> {
private List<Pelicula> listPeliculas;
private SeleccionarPeliculasListener seleccionarPeliculasListener;
private Context context;


    public void setGeneros(List<Pelicula> peliculas) {
        this.listPeliculas = peliculas;
        notifyDataSetChanged();
    }

    public EstrenosFragmentAdapter( EstrenosFragment estrenosFragmentAdapter) {
              seleccionarPeliculasListener= (SeleccionarPeliculasListener) estrenosFragmentAdapter;
    }

    @NonNull
    @Override
    public RecyclerView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
          //  View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.celda_recycler_view,viewGroup,false);
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.celda_recycler_view,viewGroup,false);
            RecyclerView fragmentMainRecyclerView = new RecyclerView(view);
        return fragmentMainRecyclerView;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView recyclerView, int i) {
        Pelicula pelicula = listPeliculas.get(i);
        recyclerView.bindPelicula(pelicula);
    }

    @Override
    public int getItemCount() {
        return listPeliculas.size();
    }

    public class RecyclerView extends android.support.v7.widget.RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewNombrePeliculas;
        TextView textViewNombreID;

        public RecyclerView(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imagen_celda_busqueda);
            textViewNombrePeliculas = itemView.findViewById(R.id.titulo_pelicula_celda_busqueda);
            textViewNombreID = itemView.findViewById(R.id.fecha_pelicula_celda_busqueda);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    seleccionarPeliculasListener.seleccionarPeliculas(getAdapterPosition(),listPeliculas);
                }
            });
        }
        public void bindPelicula(Pelicula pelicula){
            Glide.with(itemView.getContext())
                    .load("http://image.tmdb.org/t/p/w185/"+pelicula.getPosterPath())
                    .into(imageView);
            textViewNombrePeliculas.setText(pelicula.getTitle());
            textViewNombreID.setText(pelicula.getId().toString());
        }
    }

    public interface SeleccionarPeliculasListener{
        public void seleccionarPeliculas (Integer position, List<Pelicula> listPeliculas);
    }

}

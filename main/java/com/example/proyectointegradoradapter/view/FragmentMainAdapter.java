package com.example.proyectointegradoradapter.view;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.proyectointegradoradapter.R;
import com.example.proyectointegradoradapter.model.pojo.Genero;
import com.example.proyectointegradoradapter.model.pojo.Pelicula;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class FragmentMainAdapter extends RecyclerView.Adapter<FragmentMainAdapter.FragmentMainRecyclerView> {

    private List<Genero> generos;
    private List<Genero> generosSeleccionados=new ArrayList<>();
    private List<Pelicula> listPelicula;
    private SeleccionarGenerosListener seleccionarGenerosListener;
    private SeleccionarPeliculasListener seleccionarPeliculasListener;

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
        notifyDataSetChanged();
    }


    public FragmentMainAdapter(SeleccionarGenerosListener seleccionarGenerosListener,List<Genero> generos) {
        this.generos=new ArrayList<>();
        this.seleccionarGenerosListener=seleccionarGenerosListener;
        this.generos = generos;
    }

    @NonNull
    @Override
    public FragmentMainRecyclerView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.celda_generos,viewGroup,false);
            FragmentMainRecyclerView fragmentMainRecyclerView = new FragmentMainRecyclerView(view);
            return fragmentMainRecyclerView;


    }

    @Override
    public void onBindViewHolder(@NonNull FragmentMainRecyclerView fragmentMainRecyclerView, int i) {

        Genero genero = generos.get(i);
        fragmentMainRecyclerView.bindGenero(genero);
    }

    @Override
    public int getItemCount() {
        return generos.size();
    }

    public class FragmentMainRecyclerView extends RecyclerView.ViewHolder{
        TextView nombreGenero;

        public FragmentMainRecyclerView(@NonNull View itemView) {
            super(itemView);
            nombreGenero=itemView.findViewById(R.id.celda_generos_nombre_genero);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Genero genero = generos.get(getAdapterPosition());
                    seleccionarGenerosListener.seleccionarGenero(genero);

                    if(generosSeleccionados.size()==0){
                        generosSeleccionados.add(genero);
                        nombreGenero.setBackgroundColor(Color.parseColor("#E7B72D"));
                    }else{
                        if(generosSeleccionados.contains(genero)){
                                generosSeleccionados.remove(genero);
                                nombreGenero.setBackgroundColor(Color.parseColor("#00FFFFFF"));

                        }else {
                            generosSeleccionados.add(genero);
                            nombreGenero.setBackgroundColor(Color.parseColor("#E7B72D"));
                        }
                    }



                }
            });
        }

        public void bindGenero(Genero genero){
            nombreGenero.setText(genero.getNombre());
        }
    }


    public interface SeleccionarGenerosListener {
        public void seleccionarGenero (Genero genero);

    }
    public interface SeleccionarPeliculasListener {
        public void seleccionarPeliculas (Pelicula pelicula);

    }

}

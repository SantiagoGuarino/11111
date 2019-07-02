package com.example.proyectointegradoradapter.view;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.proyectointegradoradapter.R;
import com.example.proyectointegradoradapter.model.pojo.Pelicula;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetallePeliculas extends Fragment {



private SeleccionarPeliculaListenerRecycleView seleccionarPeliculaListenerRecycleView;
final static String KEY_NOMBRE_PELICULA = "nombre";
final static String KEY_DURACION_PELICULA = "duracion";
final static String KEY_FECHA_PELICULA = "fecha";
final static String KEY_DESCRIPCION_PELICULA = "descripcion";
final static String KEY_IMAGEN_PELICULA = "imagen";
final static String KEY_ELENCO_PELICULA = "elenco";
final static String KEY_PUNTUACION_PELICULA = "puntaje";
final static String KEY_DIRECTOR_PELICULA = "director";
final static String KEY_ID_PELICULA = "idpelicula";
final static String KEY_GENEROS_PELICULA = "generos";
private String url;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        seleccionarPeliculaListenerRecycleView=(SeleccionarPeliculaListenerRecycleView)context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_detalle_peliculas, container, false);
        final Bundle bundle = getArguments();

        TextView nombrePelicula = view.findViewById(R.id.nombre_pelicula_detalles);
        TextView duracionPelicula = view.findViewById(R.id.duracion_pelicula_detalles);
        TextView fechaLanzamientoPelicula = view.findViewById(R.id.fecha_de_estreno_detalles);
        TextView descripcionPelicula = view.findViewById(R.id.descripcion_pelicula_detalles);
        ImageView imagenPelicula = view.findViewById(R.id.imagen_detalles);
        TextView elencoPelicula = view.findViewById(R.id.elenco_text_view_detalles);
        TextView puntajePelicula = view.findViewById(R.id.puntuacion_pelicula_detalles);
        TextView directorPelicula = view.findViewById(R.id.director_pelicula_detalles);
        TextView idPelicula = view.findViewById(R.id.id_unica_pelicula_detalle);
        TextView generosPelicula = view.findViewById(R.id.generos_pelicula_detalles);
        nombrePelicula.setText(bundle.getString(KEY_NOMBRE_PELICULA));

        duracionPelicula.setText(bundle.getString(KEY_DURACION_PELICULA));
        fechaLanzamientoPelicula.setText(bundle.getString(KEY_FECHA_PELICULA));
        descripcionPelicula.setText(bundle.getString(KEY_DESCRIPCION_PELICULA));
        url = bundle.getString(KEY_IMAGEN_PELICULA);
        Glide.with(getContext())
                .load(url)
                .into(imagenPelicula);
        elencoPelicula.setText(bundle.getString(KEY_ELENCO_PELICULA));
        puntajePelicula.setText(bundle.getString(KEY_PUNTUACION_PELICULA));
        directorPelicula.setText(bundle.getString(KEY_DIRECTOR_PELICULA));
        idPelicula.setText(bundle.getString(KEY_ID_PELICULA));
        generosPelicula.setText(bundle.getString(KEY_GENEROS_PELICULA));

        imagenPelicula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionarPeliculaListenerRecycleView.seleccionarPeliculaListenerRecyclerView(bundle.getString(KEY_NOMBRE_PELICULA));
            }
        });

        return view;
    }

    public static FragmentDetallePeliculas generadorDeFragmentDetallePelicula(Pelicula pelicula){
         FragmentDetallePeliculas fragmentDetallePeliculas = new FragmentDetallePeliculas();
        Bundle bundle = new Bundle();
        bundle.putString(FragmentDetallePeliculas.KEY_NOMBRE_PELICULA,pelicula.getTitle());
        bundle.putString(FragmentDetallePeliculas.KEY_DESCRIPCION_PELICULA, pelicula.getOverview());
       // bundle.putString(FragmentDetallePeliculas.KEY_DURACION_PELICULA, pelicula.getDuracion());
       // bundle.putString(FragmentDetallePeliculas.KEY_ELENCO_PELICULA, pelicula.getElencoPelicula());
       // bundle.putString(FragmentDetallePeliculas.KEY_FECHA_PELICULA, pelicula.getFehcaDeEstrenoPelicula());
       // bundle.putString(FragmentDetallePeliculas.KEY_DIRECTOR_PELICULA, pelicula.getDirectorPelicula());
        bundle.putString(FragmentDetallePeliculas.KEY_IMAGEN_PELICULA, "http://image.tmdb.org/t/p/w185//" +pelicula.getPosterPath());
        //bundle.putString(FragmentDetallePeliculas.KEY_PUNTUACION_PELICULA,pelicula.getPuntajeImdbPelicula().toString());
        //bundle.putString(FragmentDetallePeliculas.KEY_GENEROS_PELICULA,pelicula.getGenerosPelicula());
        //bundle.putString(FragmentDetallePeliculas.KEY_ID_PELICULA,pelicula.getIdPelicula().toString());
        fragmentDetallePeliculas.setArguments(bundle);
        return fragmentDetallePeliculas;
    }

    public interface SeleccionarPeliculaListenerRecycleView {
        public void seleccionarPeliculaListenerRecyclerView (String pelicula);
    }

}

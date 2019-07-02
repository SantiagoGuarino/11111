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
import android.widget.Button;
import android.widget.Toast;

import com.example.proyectointegradoradapter.R;
import com.example.proyectointegradoradapter.controller.PeliculaController;
import com.example.proyectointegradoradapter.model.pojo.Genero;
import com.example.proyectointegradoradapter.model.pojo.GeneroContainer;
import com.example.proyectointegradoradapter.model.pojo.Pelicula;
import com.example.proyectointegradoradapter.model.pojo.PeliculaContainer;
import com.example.proyectointegradoradapter.util.ResultListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements FragmentMainAdapter.SeleccionarGenerosListener{
private SeleccionarPeliculasListener seleccionarPeliculaListener;
private SeleccionarGeneroListener seleccionarGeneroListener;

    //private List<com.example.proyectointegradoradapter.model.pojo.Pelicula> peliculasList=new ArrayList<>();
    public static final String KEY_GENERO = "Genero";
    public static final String KEY_SOURCE = "Navigation";


    private List<Genero> listaGenero = new ArrayList<>();
    private Integer auxiliar = 0;

    private List<Pelicula> listaDePeliculasParaArmar = new ArrayList<>();
    private List<Pelicula> listaDePeliculasAuxiliar = new ArrayList<>();
    private Pelicula listaDePeliculasParaListener;

    private FragmentMainAdapter fragmentMainAdapter;
    private View view;
    private Button botonOK;

    public MainFragment() {
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
       // seleccionarPeliculaListener=(SeleccionarPeliculasListener)context;
        seleccionarGeneroListener=(SeleccionarGeneroListener)context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_main, container, false);

        Bundle bundle = getArguments();
        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewFragmentMain);
        botonOK = view.findViewById(R.id.button_OK);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2,LinearLayoutManager.VERTICAL,false));

        fragmentMainAdapter = new FragmentMainAdapter(this,(List<Genero>) bundle.getSerializable(KEY_GENERO));
        recyclerView.setAdapter(fragmentMainAdapter);
        botonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaDePeliculasParaArmar.clear();

                auxiliar = listaGenero.size();
                armadorDePeliculas();
                seleccionarGeneroListener.seleccionarGeneroListener(listaGenero);
            }
        });
        return view;
    }




    public void getPeliculaPorGenero(final Integer genero){
        PeliculaController peliculaController = new PeliculaController();
        peliculaController.getPeliculasConGeneros(genero, new ResultListener<PeliculaContainer>() {
            @Override
            public void finish(PeliculaContainer result) {
                Integer auxiliar2 = listaDePeliculasParaArmar.size();
                listaGenero.remove(auxiliar-1);
                auxiliar--;
                //Toast.makeText(getContext(),result.getPeliculas().toString(),Toast.LENGTH_SHORT).show();
                listaDePeliculasAuxiliar=result.getPeliculas();

                for (int i = 0; i <2 ; i++) {
                    listaDePeliculasParaArmar.add(listaDePeliculasAuxiliar.get(i));
                    listaDePeliculasParaArmar.get(auxiliar2).SetGenero(genero);
                    auxiliar2++;
                 }

                armadorDePeliculas();
                if(auxiliar<=0){
                    //Toast.makeText(getContext(),result.getPeliculas().toString(),Toast.LENGTH_SHORT).show();
//                    seleccionarPeliculaListener.seleccionarListadoPeliculas(listaDePeliculasParaArmar);
                }
            }
        });
    }

    public void armadorDePeliculas (){
        if(listaGenero.size()>0){
            getPeliculaPorGenero(Integer.parseInt(listaGenero.get(auxiliar-1).getId()));
        }
    }

    public Boolean cheqeuarPeliculaRepetida(Pelicula peliculaReferencia){
       Boolean resultado = Boolean.FALSE;
        for (Pelicula track:listaDePeliculasParaArmar
             ) {
            if(track.getTitle().equals(peliculaReferencia.getTitle())){
                resultado = Boolean.TRUE;
            }
        }
    return resultado;
    }


    @Override
    public void seleccionarGenero(Genero genero) {

    if(listaGenero.size()==0){
        listaGenero.add(genero);
    }else{
        if(listaGenero.contains(genero)){
            listaGenero.remove(genero);
        }else {
            listaGenero.add(genero);
        }
    }

  }


    public interface SeleccionarPeliculasListener {
        public void seleccionarListadoPeliculas (List<Pelicula> peliculas);
    }

    public interface SeleccionarGeneroListener {
        public void seleccionarGeneroListener (List<Genero> generos);
    }

}

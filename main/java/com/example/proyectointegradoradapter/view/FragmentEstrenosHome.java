package com.example.proyectointegradoradapter.view;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

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
public class FragmentEstrenosHome extends Fragment {
private AdapterGenerosHome fragmentMainAdapter;
public final static String KEY_GENERO="genero";
private List<Genero>listagenero=new ArrayList<>();
private List<Pelicula>listaPeliculas=new ArrayList<>();
private Integer aux = 0;
private LaPutaListaDelRecycler laPutaListaDelRecycler;
private List<Pelicula> listaDePeliculas;
private List<Genero> listaDeGeneros;
private RecyclerView recyclerView;
private AdapterEstrenosHome adapterGenerosHome;
private MultiRecyclerGeneroFragment multiRecyclerGeneroFragment = new MultiRecyclerGeneroFragment();
    public FragmentEstrenosHome() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view=  inflater.inflate(R.layout.fragment_fragment_estrenos_home, container, false);
        Bundle bundle = getArguments();
        listaDeGeneros = (List<Genero>) bundle.getSerializable(KEY_GENERO);
        creadorFragmentMultiRecyclerGenero(listaDeGeneros, container);

      //  getGeneros();
        return view;

    }
    public void creadorFragmentMultiRecyclerGenero(List<Genero> listaDeGenero, View view){

        for (Genero track: listaDeGenero){
            sumarFragmentMultiRecyclerGenero(track, view);
        }

    }





    public void sumarFragmentMultiRecyclerGenero(Genero genero, View view){
        recyclerView = view.findViewById(R.id.recycler_view_multi_genero);
        getPeliculaPorGenero(genero);
// add rowLayout to the root layout somewhere here
        adapterGenerosHome = new AdapterEstrenosHome(getContext(), listaPeliculas);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext()
                , RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapterGenerosHome);
        FragmentManager fragMan = getFragmentManager();
        FragmentTransaction fragTransaction = fragMan.beginTransaction();
        Fragment myFrag = new MultiRecyclerGeneroFragment();
        fragTransaction.add(R.id.linear_layour_fragment_estrenos_home_scroll_view, myFrag);
        fragTransaction.commit();
    }

    public void getPeliculasEstreno(){
        PeliculaController peliculaController = new PeliculaController();
        peliculaController.getPersonajes(new ResultListener<PeliculaContainer>() {
            @Override
            public void finish(PeliculaContainer result) {
            }
        });

    }

    public void getGeneros() {
        PeliculaController peliculaController = new PeliculaController();
        peliculaController.getGeneros(new ResultListener<GeneroContainer>() {
            @Override
            public void finish(GeneroContainer result) {
                //listagenero=result.getGeneros();
                //arrangeGenero(listagenero);
                fragmentMainAdapter.setPeliculas(result.getGeneros());
            }
        });

    }



    public interface LaPutaListaDelRecycler{
        public List<Pelicula> listaDelMultiRecycler();
    }

    public void arrangeGenero(List<Genero>generos){
        List<Genero> listaAuxiliar = new ArrayList<>();
        listaAuxiliar=generos;
        getPeliculaPorGenero(listaAuxiliar.get(0));
    }
    public void getPeliculaPorGenero(final Genero genero){
        PeliculaController peliculaController = new PeliculaController();
        peliculaController.getPeliculasConGeneros(Integer.parseInt(genero.getId()), new ResultListener<PeliculaContainer>() {
            @Override
            public void finish(PeliculaContainer result) {
                listaPeliculas = result.getPeliculas();


            }
        });
    }

}

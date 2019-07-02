package com.example.proyectointegradoradapter.view;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.example.proyectointegradoradapter.R;
import com.example.proyectointegradoradapter.model.pojo.Genero;
import com.example.proyectointegradoradapter.util.ListenerGenero;
import com.example.proyectointegradoradapter.util.ResultListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentGeneros extends Fragment {

    private final static String TERROR = "Horror";
    private final static String CIENCIA_FICCION = "Science Fiction";
    private final static String DRAMA = "Drama";
    private final static String THRILLER = "";
    private final static String COMEDY = "Comedy";
    private final static String ACTION = "Action";
    private final static String ADVENTURE = "Adventure";
    private final static String ANIMATION = "Animation";
    private final static String DOCUMENTARY = "Documentary";
    private final static String FAMILY = "Family";
    private final static String FANTASY = "Fantasy";
    private final static String MUSIC = "Music";
    private final static String MYSTERY = "Mystery";
    private final static String ROMANCE = "Romance";
    private final static String WAR = "War";
    private final static String WESTERN = "Western";
    private final static String HYSTORY = "History";




    private List<Genero> listaDeGeneros = new ArrayList<>();
    private ListenerGenero listenerGenero;
    private List<Genero> generosSeleccionados = new ArrayList<>();
    private List<Integer>idGeneros = new ArrayList<>();

    private CheckBox terror;
    private CheckBox cienciaFiccion;
    private CheckBox drama;
    private CheckBox thriller;
    private CheckBox comedia;
    private CheckBox accion;
    private CheckBox aventura;
    private CheckBox animacion;
    private CheckBox documental;
    private CheckBox familiar;
    private CheckBox fantasia;
    private CheckBox historica;
    private CheckBox musical;
    private CheckBox misterio;
    private CheckBox romantica;
    private CheckBox guerra;
    private CheckBox western;
    private Button botonListo;
    //private FragmentGenerosListener fragmentGenerosListener;
    public FragmentGeneros() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //fragmentGenerosListener=(FragmentGenerosListener) context;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_generos, container, false);

        return view;
    }
}






        /*terror = view.findViewById(R.id.fragment_generos_check_terror);
        cienciaFiccion = view.findViewById(R.id.fragment_generos_check_cienciaficcion);
        drama = view.findViewById(R.id.fragment_generos_check_drama);
        thriller = view.findViewById(R.id.fragment_generos_check_thriller);
        comedia =  view.findViewById(R.id.fragment_generos_check_comedia);
        accion = view.findViewById(R.id.fragment_generos_check_accion);
        aventura = view.findViewById(R.id.fragment_generos_check_aventura);
        animacion = view.findViewById(R.id.fragment_generos_check_animacion);
        documental = view.findViewById(R.id.fragment_generos_check_documental);
        familiar = view.findViewById(R.id.fragment_generos_check_familiar);
        fantasia = view.findViewById(R.id.fragment_generos_check_fantasia);
        historica = view.findViewById(R.id.fragment_generos_check_historicas);
        musical = view.findViewById(R.id.fragment_generos_check_musical);
        misterio = view.findViewById(R.id.fragment_generos_check_misterio);
        romantica = view.findViewById(R.id.fragment_generos_check_romantica);
        guerra = view.findViewById(R.id.fragment_generos_check_guerra);
        western = view.findViewById(R.id.fragment_generos_check_western);
        botonListo = view.findViewById(R.id.fragment_generos_listo);
        if(generosSeleccionados.size()>0){
            generosSeleccionados.clear();
        }

        terror.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    for (Genero track: Genero.getLista()){
                        if(track.getNombre().equals(TERROR)){
                            generosSeleccionados.add(track);
                            }
                    }
                }
                else{
                    for (Genero track: Genero.getLista()){
                        if(track.getNombre().equals(TERROR)){
                            generosSeleccionados.remove(track);
                        }
                    }
                }
            }
        });
        cienciaFiccion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    for (Genero track: Genero.getLista()){
                        if(track.getNombre().equals(CIENCIA_FICCION)){
                            generosSeleccionados.add(track);
                        }
                    }
                }
                else{
                    for (Genero track: Genero.getLista()){
                        if(track.getNombre().equals(CIENCIA_FICCION)){
                            generosSeleccionados.remove(track);
                        }
                    }
                }
            }
        });
        drama.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    for (Genero track: Genero.getLista()){
                        if(track.getNombre().equals(DRAMA)){
                            generosSeleccionados.add(track);
                        }
                    }
                }
                else{
                    for (Genero track: Genero.getLista()){
                        if(track.getNombre().equals(DRAMA)){
                            generosSeleccionados.remove(track);
                        }
                    }
                }
            }
        });
        thriller.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    for (Genero track: Genero.getLista()){
                        if(track.getNombre().equals(R.string.thriller)){
                            generosSeleccionados.add(track);
                        }
                    }
                }
                else{
                    for (Genero track: Genero.getLista()){
                        if(track.getNombre().equals("")){
                            generosSeleccionados.remove(track);
                        }
                    }
                }
            }
        });
        comedia.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    for (Genero track: Genero.getLista()){
                        if(track.getNombre().equals(COMEDY)){
                            generosSeleccionados.add(track);
                        }
                    }
                }
                else{
                    for (Genero track: Genero.getLista()){
                        if(track.getNombre().equals(COMEDY)){
                            generosSeleccionados.remove(track);
                        }
                    }
                }
            }
        });
        accion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    for (Genero track: Genero.getLista()){
                        if(track.getNombre().equals(ACTION)){
                            generosSeleccionados.add(track);
                        }
                    }
                }
                else{
                    for (Genero track: Genero.getLista()){
                        if(track.getNombre().equals(ACTION)){
                            generosSeleccionados.remove(track);
                        }
                    }
                }
            }
        });
        aventura.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    for (Genero track: Genero.getLista()){
                        if(track.getNombre().equals(ADVENTURE)){
                            generosSeleccionados.add(track);
                        }
                    }
                }
                else{
                    for (Genero track: Genero.getLista()){
                        if(track.getNombre().equals(ADVENTURE)){
                            generosSeleccionados.remove(track);
                        }
                    }
                }
            }
        });
        animacion.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    for (Genero track: Genero.getLista()){
                        if(track.getNombre().equals(ANIMATION)){
                            generosSeleccionados.add(track);
                        }
                    }
                }
                else{
                    for (Genero track: Genero.getLista()){
                        if(track.getNombre().equals(ANIMATION)){
                            generosSeleccionados.remove(track);
                        }
                    }
                }
            }
        });
        documental.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    for (Genero track: Genero.getLista()){
                        if(track.getNombre().equals(DOCUMENTARY)){
                            generosSeleccionados.add(track);
                        }
                    }
                }
                else{
                    for (Genero track: Genero.getLista()){
                        if(track.getNombre().equals(DOCUMENTARY)){
                            generosSeleccionados.remove(track);
                        }
                    }
                }
            }
        });
        familiar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    for (Genero track: Genero.getLista()){
                        if(track.getNombre().equals(FAMILY)){
                            generosSeleccionados.add(track);
                        }
                    }
                }
                else{
                    for (Genero track: Genero.getLista()){
                        if(track.getNombre().equals(FAMILY)){
                            generosSeleccionados.remove(track);
                        }
                    }
                }
            }
        });
        fantasia.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    for (Genero track: Genero.getLista()){
                        if(track.getNombre().equals(FANTASY)){
                            generosSeleccionados.add(track);
                        }
                    }
                }
                else{
                    for (Genero track: Genero.getLista()){
                        if(track.getNombre().equals(FANTASY)){
                            generosSeleccionados.remove(track);
                        }
                    }
                }
            }
        });
        historica.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    for (Genero track: Genero.getLista()){
                        if(track.getNombre().equals(HYSTORY)){
                            generosSeleccionados.add(track);
                        }
                    }
                }
                else{
                    for (Genero track: Genero.getLista()){
                        if(track.getNombre().equals(HYSTORY)){
                            generosSeleccionados.remove(track);
                        }
                    }
                }
            }
        });
        musical.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    for (Genero track: Genero.getLista()){
                        if(track.getNombre().equals(MUSIC)){
                            generosSeleccionados.add(track);
                        }
                    }
                }
                else{
                    for (Genero track: Genero.getLista()){
                        if(track.getNombre().equals(MUSIC)){
                            generosSeleccionados.remove(track);
                        }
                    }
                }
            }
        });
        misterio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    for (Genero track: Genero.getLista()){
                        if(track.getNombre().equals(MYSTERY)){
                            generosSeleccionados.add(track);
                        }
                    }
                }
                else{
                    for (Genero track: Genero.getLista()){
                        if(track.getNombre().equals(MYSTERY)){
                            generosSeleccionados.remove(track);
                        }
                    }
                }
            }
        });
        romantica.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    for (Genero track: Genero.getLista()){
                        if(track.getNombre().equals(ROMANCE)){
                            generosSeleccionados.add(track);
                        }
                    }
                }
                else{
                    for (Genero track: Genero.getLista()){
                        if(track.getNombre().equals(ROMANCE)){
                            generosSeleccionados.remove(track);
                        }
                    }
                }
            }
        });
        guerra.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    for (Genero track: Genero.getLista()){
                        if(track.getNombre().equals(WAR)){
                            generosSeleccionados.add(track);
                        }
                    }
                }
                else{
                    for (Genero track: Genero.getLista()){
                        if(track.getNombre().equals(WAR)){
                            generosSeleccionados.remove(track);
                        }
                    }
                }
            }

        });
        western.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    for (Genero track: Genero.getLista()){
                        if(track.getNombre().equals(WESTERN)){
                            generosSeleccionados.add(track);
                        }
                    }
                }
                else{
                    for (Genero track: Genero.getLista()){
                        if(track.getNombre().equals(WESTERN)){
                            generosSeleccionados.remove(track);
                        }
                    }
                }
            }
        });

        botonListo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  fragmentGenerosListener.listaDeGeneros(generosSeleccionados);

              }
        });
        return view;
    }




    public interface FragmentGenerosListener{
        public void listaDeGeneros(List<Genero>listaDeGenerosSeleccionados);
    }*/


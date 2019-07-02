package com.example.proyectointegradoradapter.model.pojo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Genero implements Serializable {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String nombre;
    private Integer idNumerico;

    private static List<Genero> generos;
    private static List<Genero> generosSeleccionados;


    public Genero() {
        this.generos = new ArrayList<>();
        this.generosSeleccionados = new ArrayList<>();
        idNumerico = 0;
    }

    public static List<Genero> getLista (){
     return generos;
    }

    public static void setListaSeleccionada (List<Genero> generoslista){
        generosSeleccionados = generoslista;
    }

    public static List<Genero> getListaSeleccionada (){
        return generosSeleccionados;
    }

    public static void  setLista (List<Genero> generoslista){generos = generoslista;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Genero)) return false;
        Genero genero = (Genero) o;
        return nombre.equals(genero.nombre);
    }

}

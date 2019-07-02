package com.example.proyectointegradoradapter.model.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PeliculaContainer {
    @SerializedName("results")
    private  List<Pelicula> peliculas;
    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

}

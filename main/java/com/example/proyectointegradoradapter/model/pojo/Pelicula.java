package com.example.proyectointegradoradapter.model.pojo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pelicula implements Serializable {
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("id")
    private Integer id;
    @SerializedName("title")
    private String title;
    @SerializedName("overview")
    private String overview;
    private Integer genero;


    private static List<Pelicula> peliculas = new ArrayList<>();



    public String getOverview() {
        return overview;
    }

    public Integer getGenero() {
        return genero;
    }

    public void SetGenero(Integer genero){
        this.genero=genero;
    }

    public static void  setPeliculas (List<Pelicula> pelicula){
        peliculas = pelicula;
    }

    public static List<Pelicula> getPeliculas (){
        return peliculas;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}

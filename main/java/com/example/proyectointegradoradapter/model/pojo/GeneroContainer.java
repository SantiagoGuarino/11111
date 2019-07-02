package com.example.proyectointegradoradapter.model.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GeneroContainer {
    @SerializedName("genres")
    private List<Genero> generos;

    public List<Genero> getGeneros() {
        return generos;
    }
}

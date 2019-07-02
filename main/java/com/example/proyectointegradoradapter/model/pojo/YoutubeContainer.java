package com.example.proyectointegradoradapter.model.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class YoutubeContainer {
    @SerializedName("items")
    public List<Youtube> listaYoutube;

    public List<Youtube> getListaYoutube() {
        return listaYoutube;
    }
}

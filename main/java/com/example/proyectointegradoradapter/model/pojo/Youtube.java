package com.example.proyectointegradoradapter.model.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Youtube {
    private YoutubeId id;
    private String videoId;


    private static List<Youtube> lista = new ArrayList<>();

    public static List<Youtube> getLista() {
        return lista;
    }

    public YoutubeId getId() {
        return id;
    }

    public String getVideoId() {
        return id.getVideoId();
    }

    class YoutubeId {
        private String videoId;

        public YoutubeId() {
            this.videoId = videoId;
        }

        public String getVideoId() {
            return videoId;
        }
    }

}


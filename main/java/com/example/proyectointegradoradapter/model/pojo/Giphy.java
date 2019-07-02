package com.example.proyectointegradoradapter.model.pojo;

import com.google.gson.annotations.SerializedName;

public class Giphy {
    private String title;
    private GiphyImages images;

    public GiphyImages getImages() {
        return images;
    }

    public String getTitle() {
        return title;
    }

    public class GiphyImages{
        @SerializedName("preview_gif")
        private PreviewGif previewGif;

        public PreviewGif getPreviewGif() {
            return previewGif;
        }
    }

    public class PreviewGif{
        private String url;

        public String getUrl() {
            return url;
        }
}}


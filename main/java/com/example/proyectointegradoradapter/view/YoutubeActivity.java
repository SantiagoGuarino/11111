package com.example.proyectointegradoradapter.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.proyectointegradoradapter.R;
import com.example.proyectointegradoradapter.controller.YoutubeController;
import com.example.proyectointegradoradapter.model.pojo.Youtube;
import com.example.proyectointegradoradapter.model.pojo.YoutubeContainer;
import com.example.proyectointegradoradapter.util.ResultListener;
import com.example.proyectointegradoradapter.util.YoutubeHelper;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

public class YoutubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    public static final String KEY_PEIVULA_NOMBRE="nombre";
    private String claveYoutube ="AIzaSyA0xL44e09eiiyD3jgp3SjsyFgTpTxwaP8";
    private  YouTubePlayerView youTubePlayer;
    private YoutubeController youtubeController;
    private List<Youtube> listaString = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        youtubeController = new YoutubeController();
        Intent intent = getIntent();
        Bundle nombrePelicula = intent.getExtras();
        getPeliculas(nombrePelicula.getString(KEY_PEIVULA_NOMBRE).toString());
    }

    public void getPeliculas(String nombre){
        youtubeController.getYoubiesBySearch("snippet", nombre + "Trailer", "video", YoutubeHelper.APIKEY, new ResultListener<YoutubeContainer>() {
            @Override
            public void finish(YoutubeContainer result) {
                listaString = result.getListaYoutube();
                youTubePlayer = (YouTubePlayerView) findViewById(R.id.youtube_view);
                youTubePlayer.initialize(claveYoutube, YoutubeActivity.this);
                            }
        });

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
    if(!b){
        youTubePlayer.cueVideo(listaString.get(0).getVideoId());
    }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if(youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(this,1).show();
        }else{
            Toast.makeText(YoutubeActivity.this,"ERROR", Toast.LENGTH_SHORT).show();
        }
    }
}

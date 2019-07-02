package com.example.proyectointegradoradapter.model.dao;

import com.example.proyectointegradoradapter.model.MovieService;
import com.example.proyectointegradoradapter.model.MyRetrofit;
import com.example.proyectointegradoradapter.model.YoutubeService;
import com.example.proyectointegradoradapter.model.pojo.PeliculaContainer;
import com.example.proyectointegradoradapter.model.pojo.YoutubeContainer;
import com.example.proyectointegradoradapter.util.MovieHelper;
import com.example.proyectointegradoradapter.util.ResultListener;
import com.example.proyectointegradoradapter.util.YoutubeHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class YoutubeDAO extends MyRetrofit {
    private YoutubeService service;
    public YoutubeDAO() {
        super(YoutubeHelper.BASE_URL);
        service = retrofit.create(YoutubeService.class);
   }


    public void getPeliculaPorString(String apiKey,String busqueda,String parte,String tipoDeDato, final ResultListener<YoutubeContainer> listenerDelController) {
        Call<YoutubeContainer> call = service.getYoubiesBySearch(apiKey,busqueda,parte,tipoDeDato);
        call.enqueue(new Callback<YoutubeContainer>() {
            //call.request.url
            //Validate()
            //En el Debug
            @Override
            public void onResponse(Call<YoutubeContainer> call, Response<YoutubeContainer> response) {
                YoutubeContainer youtubeContainer = response.body();
                listenerDelController.finish(youtubeContainer);
            }
            @Override
                public void onFailure(Call<YoutubeContainer> call, Throwable t) {
                System.out.println("Hola");
            }
        });
    };




}

package com.example.proyectointegradoradapter.model.dao;

import com.example.proyectointegradoradapter.model.MovieService;
import com.example.proyectointegradoradapter.model.MyRetrofit;
import com.example.proyectointegradoradapter.model.pojo.GeneroContainer;
import com.example.proyectointegradoradapter.model.pojo.PeliculaContainer;
import com.example.proyectointegradoradapter.util.MovieHelper;
import com.example.proyectointegradoradapter.util.ResultListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GeneroDAO extends MyRetrofit {
    private MovieService service;

    public GeneroDAO() {
        super(MovieHelper.BASE_URL);
        service = retrofit.create(MovieService.class);
    }

    public void getGenero(final ResultListener<GeneroContainer> listenerDelController) {
        Call<GeneroContainer> call = service.getGeneros(MovieHelper.APIKEY);
        call.enqueue(new Callback<GeneroContainer>() {
            @Override
            public void onResponse(Call<GeneroContainer> call, Response<GeneroContainer> response) {
                GeneroContainer generoContainer = response.body();
                listenerDelController.finish(generoContainer);
            }
            @Override
            public void onFailure(Call<GeneroContainer> call, Throwable t) {

            }
        });


    }
}




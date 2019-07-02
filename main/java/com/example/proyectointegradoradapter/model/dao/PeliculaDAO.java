package com.example.proyectointegradoradapter.model.dao;


import android.content.Intent;
import android.widget.Toast;

import com.example.proyectointegradoradapter.model.MovieService;
import com.example.proyectointegradoradapter.model.MyRetrofit;
import com.example.proyectointegradoradapter.model.pojo.GeneroContainer;
import com.example.proyectointegradoradapter.model.pojo.PeliculaContainer;
import com.example.proyectointegradoradapter.util.MovieHelper;
import com.example.proyectointegradoradapter.util.ResultListener;
import com.example.proyectointegradoradapter.view.MainActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PeliculaDAO extends MyRetrofit {
    private MovieService service;

    public PeliculaDAO() {
        super(MovieHelper.BASE_URL);
        service = retrofit.create(MovieService.class);
    }

    public void getPelicula(final ResultListener<PeliculaContainer> listenerDelController) {
        Call<PeliculaContainer> call = service.getPeliculas(MovieHelper.APIKEY);
        call.enqueue(new Callback<PeliculaContainer>() {
            @Override
            public void onResponse(Call<PeliculaContainer> call, Response<PeliculaContainer> response) {
                PeliculaContainer peliculaContainer = response.body();
                listenerDelController.finish(peliculaContainer);
            }
            @Override
            public void onFailure(Call<PeliculaContainer> call, Throwable t) {

            }
        });

    }


    public void getPeliculaConGenero(Integer busqueda, final ResultListener<PeliculaContainer> listenerDelController) {
        Call<PeliculaContainer> call = service.getMovieWithGenres(MovieHelper.APIKEY,busqueda);
        call.enqueue(new Callback<PeliculaContainer>() {
            @Override
            public void onResponse(Call<PeliculaContainer> call, Response<PeliculaContainer> response) {
                PeliculaContainer peliculaContainer = response.body();
                listenerDelController.finish(peliculaContainer);
            }

            @Override
            public void onFailure(Call<PeliculaContainer> call, Throwable t) {
                System.out.println("Hola");
            }
        });
    };

}

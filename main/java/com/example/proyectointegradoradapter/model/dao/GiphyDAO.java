package com.example.proyectointegradoradapter.model.dao;

import com.example.proyectointegradoradapter.model.GiphyService;
import com.example.proyectointegradoradapter.model.MyRetrofit;
import com.example.proyectointegradoradapter.model.pojo.GiphyContainer;
import com.example.proyectointegradoradapter.util.GiphyHelper;
import com.example.proyectointegradoradapter.util.ResultListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class GiphyDAO extends MyRetrofit {
    private GiphyService service;

    public GiphyDAO() {
        super(GiphyHelper.BASE_URL);
        this.service = retrofit.create(GiphyService.class);
    }

    public void getGhypiesBySearch( final ResultListener<GiphyContainer> listenerDelController){
        Call<GiphyContainer> call = service.getGiphiesBySearch(GiphyHelper.APIKEY);
        call.enqueue(new Callback<GiphyContainer>() {
            @Override
            public void onResponse(Call<GiphyContainer> call, Response<GiphyContainer> response) {
                GiphyContainer ghipyContainer = response.body();
                listenerDelController.finish(ghipyContainer);
            }

            @Override
            public void onFailure(Call<GiphyContainer> call, Throwable t) {

            }
        });
    }


}

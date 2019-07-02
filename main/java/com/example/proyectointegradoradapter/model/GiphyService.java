package com.example.proyectointegradoradapter.model;

import com.example.proyectointegradoradapter.model.pojo.GiphyContainer;
import com.example.proyectointegradoradapter.util.GiphyHelper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GiphyService {


    @GET(GiphyHelper.SEARCH_ENDPOINT)
    Call<GiphyContainer> getGiphiesBySearch(@Query(GiphyHelper.APIKEY_PARAM) String apiKey);

    @GET(GiphyHelper.SEARCH_ENDPOINT)
    Call<GiphyContainer> getGiphiesBySearchPaginated(@Query(GiphyHelper.APIKEY_PARAM) String apiKey,
                                                     @Query(GiphyHelper.QUERY_PARAM) String busqueda,
                                                     @Query(GiphyHelper.LIMIT_PARAM) Integer limit,
                                                     @Query(GiphyHelper.OFFSET_PARAM) Integer offset);
}

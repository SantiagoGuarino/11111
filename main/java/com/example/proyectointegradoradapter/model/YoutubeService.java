package com.example.proyectointegradoradapter.model;

import com.example.proyectointegradoradapter.model.pojo.GiphyContainer;
import com.example.proyectointegradoradapter.model.pojo.YoutubeContainer;
import com.example.proyectointegradoradapter.util.GiphyHelper;
import com.example.proyectointegradoradapter.util.YoutubeHelper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YoutubeService {

    @GET(YoutubeHelper.SEARCH_ENDPOINT)
    Call<YoutubeContainer> getYoubiesBySearch( @Query(YoutubeHelper.PART_TYPE) String part,
                                               @Query(YoutubeHelper.QUERY_PARAM) String busqueda,
                                               @Query(YoutubeHelper.TYPE) String tipo,
                                               @Query(YoutubeHelper.APIKEY_PARAM) String apiKey
);

}

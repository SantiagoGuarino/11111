package com.example.proyectointegradoradapter.model;


import com.example.proyectointegradoradapter.model.pojo.GeneroContainer;
import com.example.proyectointegradoradapter.model.pojo.PeliculaContainer;
import com.example.proyectointegradoradapter.util.MovieHelper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieService {
        @GET(MovieHelper.MOVIE_ENDPOINT/*?api_key=20ad9fa45070fe47eadc09ea823f6c3c&language=en-US&page=1*/)
    Call<PeliculaContainer> getPeliculas(@Query(MovieHelper.APIKEY_PARAM) String apikey);

    @GET(MovieHelper.GENRE_ENDPOINT/*?api_key=20ad9fa45070fe47eadc09ea823f6c3c&language=en-US&page=1*/)
    Call<GeneroContainer> getGeneros(@Query(MovieHelper.APIKEY_PARAM) String apikey);

    @GET(MovieHelper.GENRE_ASK_ENDPOINT/*?api_key=20ad9fa45070fe47eadc09ea823f6c3c&language=en-US&page=1*/)
    Call<PeliculaContainer> getMovieWithGenres(@Query(MovieHelper.APIKEY_PARAM) String apikey,@Query(MovieHelper.GENRE_SEARCH_PARAM) Integer genre );

}

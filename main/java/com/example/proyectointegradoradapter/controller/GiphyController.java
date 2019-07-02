package com.example.proyectointegradoradapter.controller;

import com.example.proyectointegradoradapter.model.dao.GiphyDAO;
import com.example.proyectointegradoradapter.model.pojo.GiphyContainer;
import com.example.proyectointegradoradapter.util.GiphyHelper;
import com.example.proyectointegradoradapter.util.ResultListener;

public class GiphyController {

    private String busqueda;
    private Integer offset;
    private Integer totalCount;


    public void getGiphiesBySearch(final ResultListener<GiphyContainer> listenerDeLaView){
        GiphyDAO giphyDAO = new GiphyDAO();
        giphyDAO.getGhypiesBySearch(new ResultListener<GiphyContainer>() {
            @Override
            public void finish(GiphyContainer result) {
                listenerDeLaView.finish(result);
            }
        });
    }

}

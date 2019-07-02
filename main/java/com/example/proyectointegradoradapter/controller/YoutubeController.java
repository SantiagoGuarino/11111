package com.example.proyectointegradoradapter.controller;

import com.example.proyectointegradoradapter.model.dao.PeliculaDAO;
import com.example.proyectointegradoradapter.model.dao.YoutubeDAO;
import com.example.proyectointegradoradapter.model.pojo.PeliculaContainer;
import com.example.proyectointegradoradapter.model.pojo.YoutubeContainer;
import com.example.proyectointegradoradapter.util.ResultListener;

public class YoutubeController {

    public void getYoubiesBySearch(String apyKey,String busqueda,String parte,String tipoDeDato,final ResultListener<YoutubeContainer> listenerDeLaView){
        YoutubeDAO youtubeDAO = new YoutubeDAO();
        youtubeDAO.getPeliculaPorString(apyKey,busqueda,parte,tipoDeDato, new ResultListener<YoutubeContainer>() {
            @Override
            public void finish(YoutubeContainer result) {
                listenerDeLaView.finish(result);
            }
       });
    }

}

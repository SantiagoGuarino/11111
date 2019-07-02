package com.example.proyectointegradoradapter.controller;

import com.example.proyectointegradoradapter.model.dao.GeneroDAO;
import com.example.proyectointegradoradapter.model.dao.PeliculaDAO;
import com.example.proyectointegradoradapter.model.pojo.GeneroContainer;
import com.example.proyectointegradoradapter.model.pojo.PeliculaContainer;
import com.example.proyectointegradoradapter.util.ResultListener;

public class PeliculaController {

    public void getPersonajes(final ResultListener<PeliculaContainer> listenerDeLaView){
        PeliculaDAO peliculaDAO = new PeliculaDAO();
        peliculaDAO.getPelicula(new ResultListener<PeliculaContainer>() {
            @Override
            public void finish(PeliculaContainer result) {
                listenerDeLaView.finish(result);
            }
        });

    }



    public void getGeneros(final ResultListener<GeneroContainer> listenerDeLaView){
        GeneroDAO generoDAO = new GeneroDAO();
        generoDAO.getGenero(new ResultListener<GeneroContainer>() {

            @Override
            public void finish(GeneroContainer result) {
                listenerDeLaView.finish(result);
            }
        });

    }


    public void getPeliculasConGeneros(Integer genero,final ResultListener<PeliculaContainer> listenerDeLaView){
        PeliculaDAO peliculaDAO = new PeliculaDAO();
        peliculaDAO.getPeliculaConGenero(genero, new ResultListener<PeliculaContainer>() {
            @Override
            public void finish(PeliculaContainer result) {
            listenerDeLaView.finish(result);
            }
        });
        }



}

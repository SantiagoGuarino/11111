package com.example.proyectointegradoradapter.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.proyectointegradoradapter.R;
import com.example.proyectointegradoradapter.controller.GiphyController;
import com.example.proyectointegradoradapter.model.pojo.Giphy;
import com.example.proyectointegradoradapter.model.pojo.GiphyContainer;
import com.example.proyectointegradoradapter.util.ResultListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoadingScene extends Fragment {
    private GiphyController controller;
    private ImageView imageViewGif;
    private View view;
    public LoadingScene() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view = inflater.inflate(R.layout.fragment_blank, container, false);
        controller = new GiphyController();
        imageViewGif = view.findViewById(R.id.cell_giphy_gif);
        Glide.with(view).load("https://media1.giphy.com/media/3oEjI6SIIHBdRxXI40/giphy-preview.gif?cid=902e6cb35d0ced4658367a715583b472&rid=giphy-preview.gif").into(imageViewGif);

        getGiphiesBySearch();

        return view;
    }

    private void getGiphiesBySearch(){
        controller.getGiphiesBySearch( new ResultListener<GiphyContainer>() {
            @Override
            public void finish(GiphyContainer result) {
                Toast.makeText(getContext(),"Giphyes",Toast.LENGTH_SHORT).show();
            }
        });

    }

public void bind (Giphy giphy){
  //  Glide.with(view).load("https://media1.giphy.com/media/bbshzgyFQDqPHXBo4c/giphy-preview.mp4").into(imageViewGif);
 }

}

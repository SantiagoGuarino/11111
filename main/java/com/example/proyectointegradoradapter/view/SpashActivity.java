package com.example.proyectointegradoradapter.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.proyectointegradoradapter.R;
import com.example.proyectointegradoradapter.view.LogIn.LogInActivity;

public class SpashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash);

        Thread myThread = new Thread(){
            public void run(){
                try {
                    sleep(3000);
                    //Intent intent =  new Intent(SpashActivity.this, LogInActivity.class);
                    Intent intent =  new Intent(SpashActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        };
    myThread.start();

    }
}

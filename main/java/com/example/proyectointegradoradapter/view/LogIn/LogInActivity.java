package com.example.proyectointegradoradapter.view.LogIn;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.proyectointegradoradapter.R;
import com.example.proyectointegradoradapter.view.FragmentMainAdapter;
import com.example.proyectointegradoradapter.view.MainActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogInActivity extends AppCompatActivity implements RegisterFragment.RegisterAndLogInListener, RegisterFragment.LogInListener {
    private FirebaseAuth mAuth;
    private RegisterFragment registerFragment = new RegisterFragment();
    private LogInFragment logInFragment = new LogInFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        mAuth = FirebaseAuth.getInstance();
        pegarFragment(registerFragment);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    @Override
    public void updateUI(FirebaseUser firebaseUser) {
        if (firebaseUser != null){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void logInFragment() {
        pegarFragment(logInFragment);
    }

    public void pegarFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.log_in_container, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }
}

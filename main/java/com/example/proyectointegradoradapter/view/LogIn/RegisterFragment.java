package com.example.proyectointegradoradapter.view.LogIn;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectointegradoradapter.R;
import com.example.proyectointegradoradapter.view.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;

import static android.support.constraint.Constraints.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    EditText user;
    EditText pass;
    Button myBtnRegister;
    Button myBtnLogIn;
    EditText passCheck;
    private RegisterAndLogInListener registerAndLogInListener;
    private LogInListener logInListener;

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        mAuth = FirebaseAuth.getInstance();
        user = view.findViewById(R.id.usuario_register);
        pass = view.findViewById(R.id.password_register);
        myBtnRegister = view.findViewById(R.id.my_btn_register);
        myBtnLogIn = view.findViewById(R.id.my_btn_log_in);
        passCheck = view.findViewById(R.id.password_register_check);
        myBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAccount();
            }
        });

        myBtnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logInListener.logInFragment();
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        registerAndLogInListener = (RegisterAndLogInListener) context;
        logInListener = (LogInListener) context;
    }

    public void createAccount() {
        String email = user.getText().toString().trim();
        String password = pass.getText().toString().trim();
        String passCheckString = passCheck.toString().trim();
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getContext(), "Ingrese un Email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getContext(), "Ingrese una contraseña", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!password.equals(passCheckString)){
            Toast.makeText(getContext(), "Las contraseñas ingresadas no coincides", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!password.equals(password.toLowerCase())){
            Toast.makeText(getContext(), "La contraseña no contiene mayúsculas", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!password.equals(password.toUpperCase())){
            Toast.makeText(getContext(), "La contraseña no contiene minúsculas", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!password.matches("[A-Za-z0-9]*")){
            Toast.makeText(getContext(), "La contraseña contiene valores no alfa numéricos", Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener((Activity) getContext(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(getContext(), "Se ha registrado", Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                            registerAndLogInListener.updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            //si el usuario ya existe
                            if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                Toast.makeText(getContext(), "El usuario ya existe",
                                        Toast.LENGTH_SHORT).show();
                            }
                            Toast.makeText(getContext(), "No se pudo registrar el usuario.",
                                    Toast.LENGTH_SHORT).show();
                            registerAndLogInListener.updateUI(null);
                        }

                        // ...
                    }

                });
    }


    public interface RegisterAndLogInListener{
        void updateUI(FirebaseUser firebaseUser);
    }

    public interface LogInListener{
        void logInFragment();
    }
}

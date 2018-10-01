package com.scrumdog.donationtracker.controllers;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.content.Intent;

import com.scrumdog.donationtracker.R;

public class HomeScreen extends AppCompatActivity {

    private Button Login;
    private Button Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        Login = (Button) findViewById(R.id.loginButton);


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        Register = (Button) findViewById(R.id.registerButton);


        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }
}

//    public void login(View view) {
//        // Do something in response to button click
//        Intent intent = new Intent(HomeScreen.this, LoginActivity.class);
//        startActivity(intent);
//    }


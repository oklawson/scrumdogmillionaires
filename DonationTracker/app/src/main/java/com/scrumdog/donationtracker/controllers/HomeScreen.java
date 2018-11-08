package com.scrumdog.donationtracker.controllers;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.content.Intent;

import com.scrumdog.donationtracker.R;
import com.scrumdog.donationtracker.model.DonationManagement;
import com.scrumdog.donationtracker.model.User;

//import com.google.gson.Gson;
import com.scrumdog.donationtracker.model.UserManagement;

//import java.io.BufferedReader;
import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.io.PrintWriter;
//import java.util.List;

public class HomeScreen extends AppCompatActivity {

    public final static String DEFAULT_BINARY_FILE_NAME = "data.bin";
    public final static String DEFAULT_TEXT_FILE_NAME = "data.txt";
    public final static String DEFAULT_JSON_FILE_NAME = "data.json";
    private User sm;


    private Button Login;
    private Button Register;
    UserManagement umt = UserManagement.getInstance();
    DonationManagement dmt = DonationManagement.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        File file1 = new File(getApplicationContext().getFilesDir(), UserManagement.DEFAULT_JSON_FILE_NAME);
        File file2 = new File(getApplicationContext().getFilesDir(), DonationManagement.DEFAULT_JSON_FILE_NAME);
        umt.loadJson(file1);
        Log.d("MYAPP","Loaded json");
        Log.d("MYAPP", "user list: " + umt.getUsersAsList());
        dmt.loadJson(file2);
        Log.d("MYAPP","Loaded json 2");
        Log.d("MYAPP", "donation list: " + dmt.getDonationsAsList());
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


package com.scrumdog.donationtracker.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
//import android.util.Log;
//import java.util.List;
import java.util.ArrayList;

import com.scrumdog.donationtracker.R;
import com.scrumdog.donationtracker.model.Location;
//import com.scrumdog.donationtracker.model.User;
//import com.scrumdog.donationtracker.model.UserManager;
import com.scrumdog.donationtracker.model.UserManagement;

//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.nio.charset.StandardCharsets;
//
//import java.io.FileOutputStream;
//import java.io.FileInputStream;
//import java.io.File.*;


public class MainActivity extends AppCompatActivity {
    private Button Logout;
    private Button ViewLocations;
    private Button EnterDonations;
    private Button ViewDonationList;
    private Button Search;
    private TextView textview;
    private Button ViewMap;

    static ArrayList<Location> locations;

    UserManagement umt = UserManagement.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview = (TextView) findViewById(R.id.textView);

        // set currentUser within doLogin and doRegister as long as it's before this line of code
        // which it should be, can't do this in MainActivity until someone is logged in conceptually
        if (umt.getCurrentUser().getUserType().equals("Location Employee")) {
            textview.setText("My Location: " + umt.getCurrentUser().getUserLocation());
        }

        ViewLocations = (Button) findViewById(R.id.viewLocationsButton);

        if(umt.getCurrentUser().getUserType().equals("Location Employee")) {
            ViewLocations.setText("View Other Locations");
        }

        ViewLocations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LocationList.class);
                startActivity(intent);
            }
        });

        Search = (Button) findViewById(R.id.search);

        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        //adding middle button to access data entry for donations page
        EnterDonations = (Button) findViewById(R.id.viewDonationEntryPage);
        ViewDonationList = (Button) findViewById(R.id.viewDonationList);

//        if(umt.getCurrentUser().getUserType().equals("Admin")) {
//            EnterDonations.setVisibility(View.VISIBLE);
//            ViewDonationList.setVisibility(View.VISIBLE);
//        }

        if(umt.getCurrentUser().getUserType().equals("Location Employee")) {
            EnterDonations.setVisibility(View.VISIBLE);
            ViewDonationList.setVisibility(View.VISIBLE);
        } else {
            EnterDonations.setVisibility(View.INVISIBLE);
            ViewDonationList.setVisibility(View.INVISIBLE);
        }

        EnterDonations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DonationEntryActivity.class);
                startActivity(intent);
            }
        });

        ViewDonationList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DonationList.class);
                startActivity(intent);
            }
        });


        ViewLocations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LocationList.class);
                startActivity(intent);
            }
        });

        ViewMap = (Button) findViewById(R.id.ViewMap);

        ViewMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });

        Logout = (Button) findViewById(R.id.logoutButton);

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                umt.doLogout();
                Intent intent = new Intent(MainActivity.this, HomeScreen.class);
                startActivity(intent);
            }
        });

    }



}

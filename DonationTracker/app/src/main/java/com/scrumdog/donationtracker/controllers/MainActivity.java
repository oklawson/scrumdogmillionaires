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

    static ArrayList<Location> locations;

    private final UserManagement umt = UserManagement.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textview = (TextView) findViewById(R.id.textView);

        // set currentUser within doLogin and doRegister as long as it's before this line of code
        // which it should be, can't do this in MainActivity until someone is logged in conceptually
        if (umt.getCurrentUser().getUserType().equals("Location Employee")) {
            textview.setText("My Location: " + umt.getCurrentUser().getUserLocation());
        }

        Button viewLocations = (Button) findViewById(R.id.viewLocationsButton);

        if(umt.getCurrentUser().getUserType().equals("Location Employee")) {
            viewLocations.setText("View Other Locations");
        }

        viewLocations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LocationList.class);
                startActivity(intent);
            }
        });

        Button search = (Button) findViewById(R.id.search);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        //adding middle button to access data entry for donations page
        Button enterDonations = (Button) findViewById(R.id.viewDonationEntryPage);
        Button viewDonationList = (Button) findViewById(R.id.viewDonationList);

//        if(umt.getCurrentUser().getUserType().equals("Admin")) {
//            EnterDonations.setVisibility(View.VISIBLE);
//            ViewDonationList.setVisibility(View.VISIBLE);
//        }

        if(umt.getCurrentUser().getUserType().equals("Location Employee")) {
            enterDonations.setVisibility(View.VISIBLE);
            viewDonationList.setVisibility(View.VISIBLE);
        } else {
            enterDonations.setVisibility(View.INVISIBLE);
            viewDonationList.setVisibility(View.INVISIBLE);
        }

        enterDonations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DonationEntryActivity.class);
                startActivity(intent);
            }
        });

        viewDonationList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DonationList.class);
                startActivity(intent);
            }
        });


        viewLocations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LocationList.class);
                startActivity(intent);
            }
        });

        Button viewMap = (Button) findViewById(R.id.ViewMap);

        viewMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });

        Button logout = (Button) findViewById(R.id.logoutButton);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                umt.doLogout();
                Intent intent = new Intent(MainActivity.this, HomeScreen.class);
                startActivity(intent);
            }
        });

    }



}

package com.scrumdog.donationtracker.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;
import java.util.List;
import java.util.ArrayList;

import com.scrumdog.donationtracker.R;
import com.scrumdog.donationtracker.model.Location;
import com.scrumdog.donationtracker.model.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    private Button Logout;
    private Button ViewLocations;
    private Button EnterDonations;
    static ArrayList<Location> locations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewLocations = (Button) findViewById(R.id.viewLocationsButton);

        ViewLocations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LocationList.class);
                startActivity(intent);
            }
        });

        //adding middle button to access data entry for donations page
        EnterDonations = (Button) findViewById(R.id.viewDonationEntryPage);

        if(User.getCurrentUser().getUserType().equals("Location Employee")) {
            EnterDonations.setVisibility(View.VISIBLE);
        }

        EnterDonations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DonationEntryActivity.class);
                startActivity(intent);
            }
        });

        //If the current user is an Employee, show the Add Donation Button
        //if (User.getUserType().equals("Location Employee")){
            //EnterDonations.setVisibility(View.VISIBLE);
        //}


        ViewLocations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LocationList.class);
                startActivity(intent);
            }
        });

        Logout = (Button) findViewById(R.id.logoutButton);

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User.setCurrentUser(null);
                Intent intent = new Intent(MainActivity.this, HomeScreen.class);
                startActivity(intent);
            }
        });

    }

}

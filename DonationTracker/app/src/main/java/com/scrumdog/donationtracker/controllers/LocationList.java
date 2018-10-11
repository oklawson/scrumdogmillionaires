package com.scrumdog.donationtracker.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.scrumdog.donationtracker.R;
import com.scrumdog.donationtracker.model.Location;

public class LocationList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_list);
    }

    int numLocations = Location._locations.size();

}

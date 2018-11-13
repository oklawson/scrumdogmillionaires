package com.scrumdog.donationtracker.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.scrumdog.donationtracker.R;


public class DetailedLocation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_location);

        TextView locationName = (TextView) findViewById(R.id.LocationName);
//        TextView locationType = (TextView) findViewById(R.id.LocationType);
//        TextView latitude = (TextView) findViewById(R.id.Latitude);
//        TextView longitude = (TextView) findViewById(R.id.Longitude);
//        TextView address = (TextView) findViewById(R.id.Address);
//        TextView phoneNumber = (TextView) findViewById(R.id.PhoneNumber);
        TextView DLocationType = (TextView) findViewById(R.id.DLocationType);
        TextView DLatitude = (TextView) findViewById(R.id.DLocationLatitude);
        TextView DLongitude = (TextView) findViewById(R.id.DLocationLongitude);
        TextView DAddress = (TextView) findViewById(R.id.DLocationAddress);
        TextView DPhoneNumber = (TextView) findViewById(R.id.DLocationPhone);

        locationName.setText(LocationList.locationName);
        DLocationType.setText(LocationList.locationType);
        DLatitude.setText(String.format(String.valueOf(LocationList.latitude)));
        DLongitude.setText(String.format(String.valueOf(LocationList.longitude)));
        DAddress.setText(LocationList.address);
        DPhoneNumber.setText(LocationList.phoneNumber);
    }

}

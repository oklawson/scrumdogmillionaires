package com.scrumdog.donationtracker.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.scrumdog.donationtracker.R;

public class DetailedLocation extends AppCompatActivity {

    private TextView LocationName;
    private TextView LocationType;
    private TextView Latitude;
    private TextView Longitude;
    private TextView Address;
    private TextView PhoneNumber;
    private TextView DLocationType;
    private TextView DLatitude;
    private TextView DLongitude;
    private TextView DAddress;
    private TextView DPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_location);

        LocationName = (TextView) findViewById(R.id.LocationName);
        LocationType = (TextView) findViewById(R.id.LocationType);
        Latitude = (TextView) findViewById(R.id.Latitude);
        Longitude = (TextView) findViewById(R.id.Longitude);
        Address = (TextView) findViewById(R.id.Address);
        PhoneNumber = (TextView) findViewById(R.id.PhoneNumber);
        DLocationType = (TextView) findViewById(R.id.DLocationType);
        DLatitude = (TextView) findViewById(R.id.DLocationLatitude);
        DLongitude = (TextView) findViewById(R.id.DLocationLongitude);
        DAddress = (TextView) findViewById(R.id.DLocationAddress);
        DPhoneNumber = (TextView) findViewById(R.id.DLocationPhone);

        LocationName.setText(LocationList.locationName);
        DLocationType.setText(LocationList.locationType);
        DLatitude.setText(Double.toString(LocationList.latitude));
        DLongitude.setText(Double.toString(LocationList.longitude));
        DAddress.setText(LocationList.address);
        DPhoneNumber.setText(LocationList.phoneNumber);
    }

}

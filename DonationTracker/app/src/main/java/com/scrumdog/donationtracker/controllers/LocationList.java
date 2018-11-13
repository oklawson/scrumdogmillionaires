package com.scrumdog.donationtracker.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.scrumdog.donationtracker.R;
import com.scrumdog.donationtracker.model.Location;


public class LocationList extends AppCompatActivity {

    public static String locationName;
    public static String locationType;
    public static double longitude;
    public static double latitude;
    public static String address;
    public static String phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            SDFUtils.readSDFile(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_list);

        String location1 = Location.locations.get(0).getName();
        String location2 = Location.locations.get(1).getName();
        String location3 = Location.locations.get(2).getName();
        String location4 = Location.locations.get(3).getName();
        String location5 = Location.locations.get(4).getName();
        String location6 = Location.locations.get(5).getName();

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        TextView location11 = (TextView) findViewById(R.id.Location1);
        TextView location21 = (TextView) findViewById(R.id.Location2);
        TextView location31 = (TextView) findViewById(R.id.Location3);
        TextView location41 = (TextView) findViewById(R.id.Location4);
        TextView location51 = (TextView) findViewById(R.id.Location5);
        TextView location61 = (TextView) findViewById(R.id.Location6);

        location11.setText(location1);
        location21.setText(location2);
        location31.setText(location3);
        location41.setText(location4);
        location51.setText(location5);
        location61.setText(location6);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                locationName = Location.locations.get(0).getName();
                locationType = Location.locations.get(0).getType();
                longitude = Location.locations.get(0).getLongitude();
                latitude = Location.locations.get(0).getLatitude();
                address = Location.locations.get(0).getAddress();
                phoneNumber = Location.locations.get(0).getPhoneNumber();
                Intent intent = new Intent(LocationList.this, DetailedLocation.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                locationName = Location.locations.get(1).getName();
                locationType = Location.locations.get(1).getType();
                longitude = Location.locations.get(1).getLongitude();
                latitude = Location.locations.get(1).getLatitude();
                address = Location.locations.get(1).getAddress();
                phoneNumber = Location.locations.get(1).getPhoneNumber();
                Intent intent = new Intent(LocationList.this, DetailedLocation.class);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                locationName = Location.locations.get(2).getName();
                locationType = Location.locations.get(2).getType();
                longitude = Location.locations.get(2).getLongitude();
                latitude = Location.locations.get(2).getLatitude();
                address = Location.locations.get(2).getAddress();
                phoneNumber = Location.locations.get(2).getPhoneNumber();
                Intent intent = new Intent(LocationList.this, DetailedLocation.class);
                startActivity(intent);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                locationName = Location.locations.get(3).getName();
                locationType = Location.locations.get(3).getType();
                longitude = Location.locations.get(3).getLongitude();
                latitude = Location.locations.get(3).getLatitude();
                address = Location.locations.get(3).getAddress();
                phoneNumber = Location.locations.get(3).getPhoneNumber();
                Intent intent = new Intent(LocationList.this, DetailedLocation.class);
                startActivity(intent);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                locationName = Location.locations.get(4).getName();
                locationType = Location.locations.get(4).getType();
                longitude = Location.locations.get(4).getLongitude();
                latitude = Location.locations.get(4).getLatitude();
                address = Location.locations.get(4).getAddress();
                phoneNumber = Location.locations.get(4).getPhoneNumber();
                Intent intent = new Intent(LocationList.this, DetailedLocation.class);
                startActivity(intent);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                locationName = Location.locations.get(5).getName();
                locationType = Location.locations.get(5).getType();
                longitude = Location.locations.get(5).getLongitude();
                latitude = Location.locations.get(5).getLatitude();
                address = Location.locations.get(5).getAddress();
                phoneNumber = Location.locations.get(5).getPhoneNumber();
                Intent intent = new Intent(LocationList.this, DetailedLocation.class);
                startActivity(intent);
            }
        });


    }
}

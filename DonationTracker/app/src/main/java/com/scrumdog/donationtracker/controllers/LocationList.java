package com.scrumdog.donationtracker.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.scrumdog.donationtracker.R;
import com.scrumdog.donationtracker.model.Location;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class LocationList extends AppCompatActivity {

    private TextView Location1;
    private TextView Location2;
    private TextView Location3;
    private TextView Location4;
    private TextView Location5;
    private TextView Location6;
    private Button Button1;
    private Button Button2;
    private Button Button3;
    private Button Button4;
    private Button Button5;
    private Button Button6;

    public static String locationName;
    public static String locationType;
    public static double longitude;
    public static double latitude;
    public static String address;
    public static String phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            this.readSDFile();
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

        Button1 = (Button) findViewById(R.id.button1);
        Button2 = (Button) findViewById(R.id.button2);
        Button3 = (Button) findViewById(R.id.button3);
        Button4 = (Button) findViewById(R.id.button4);
        Button5 = (Button) findViewById(R.id.button5);
        Button6 = (Button) findViewById(R.id.button6);
        Location1 = (TextView) findViewById(R.id.Location1);
        Location2 = (TextView) findViewById(R.id.Location2);
        Location3 = (TextView) findViewById(R.id.Location3);
        Location4 = (TextView) findViewById(R.id.Location4);
        Location5 = (TextView) findViewById(R.id.Location5);
        Location6 = (TextView) findViewById(R.id.Location6);

        Location1.setText(location1);
        Location2.setText(location2);
        Location3.setText(location3);
        Location4.setText(location4);
        Location5.setText(location5);
        Location6.setText(location6);


        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                locationName = Location.locations.get(0).getName();;
                locationType = Location.locations.get(0).getType();;
                longitude = Location.locations.get(0).getLongitude();;
                latitude = Location.locations.get(0).getLatitude();;
                address = Location.locations.get(0).getAddress();;
                phoneNumber = Location.locations.get(0).getPhoneNumber();
                Intent intent = new Intent(LocationList.this, DetailedLocation.class);
                startActivity(intent);
            }
        });

        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                locationName = Location.locations.get(1).getName();;
                locationType = Location.locations.get(1).getType();;
                longitude = Location.locations.get(1).getLongitude();;
                latitude = Location.locations.get(1).getLatitude();;
                address = Location.locations.get(1).getAddress();;
                phoneNumber = Location.locations.get(1).getPhoneNumber();
                Intent intent = new Intent(LocationList.this, DetailedLocation.class);
                startActivity(intent);
            }
        });

        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                locationName = Location.locations.get(2).getName();;
                locationType = Location.locations.get(2).getType();;
                longitude = Location.locations.get(2).getLongitude();;
                latitude = Location.locations.get(2).getLatitude();;
                address = Location.locations.get(2).getAddress();;
                phoneNumber = Location.locations.get(2).getPhoneNumber();
                Intent intent = new Intent(LocationList.this, DetailedLocation.class);
                startActivity(intent);
            }
        });

        Button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                locationName = Location.locations.get(3).getName();;
                locationType = Location.locations.get(3).getType();;
                longitude = Location.locations.get(3).getLongitude();;
                latitude = Location.locations.get(3).getLatitude();;
                address = Location.locations.get(3).getAddress();;
                phoneNumber = Location.locations.get(3).getPhoneNumber();
                Intent intent = new Intent(LocationList.this, DetailedLocation.class);
                startActivity(intent);
            }
        });

        Button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                locationName = Location.locations.get(4).getName();;
                locationType = Location.locations.get(4).getType();;
                longitude = Location.locations.get(4).getLongitude();;
                latitude = Location.locations.get(4).getLatitude();;
                address = Location.locations.get(4).getAddress();;
                phoneNumber = Location.locations.get(4).getPhoneNumber();
                Intent intent = new Intent(LocationList.this, DetailedLocation.class);
                startActivity(intent);
            }
        });

        Button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                locationName = Location.locations.get(5).getName();;
                locationType = Location.locations.get(5).getType();;
                longitude = Location.locations.get(5).getLongitude();;
                latitude = Location.locations.get(5).getLatitude();;
                address = Location.locations.get(5).getAddress();;
                phoneNumber = Location.locations.get(5).getPhoneNumber();
                Intent intent = new Intent(LocationList.this, DetailedLocation.class);
                startActivity(intent);
            }
        });


    }

    private void readSDFile() throws Exception {
        //SimpleModel model = SimpleModel.INSTANCE;

        //Open a stream on the raw file
        InputStream is = getResources().openRawResource(R.raw.locationdata);
        //From here we probably should call a model method and pass the InputStream
        //Wrap it in a BufferedReader so that we get the readLine() method
        BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

        String line;
        br.readLine(); //get rid of header line
        while ((line = br.readLine()) != null) {
            String[] tokens = line.split(",");
            Location newLocation = new Location();
            newLocation.setName(tokens[1]);
            newLocation.setType(tokens[8]);
            newLocation.setLongitude(Double.parseDouble(tokens[3]));
            newLocation.setLatitude(Double.parseDouble(tokens[2]));
            newLocation.setAddress(tokens[4]);
            newLocation.setPhoneNumber(tokens[9]);
            Location.locations.add(newLocation);
            //Location.legalLocations.add(newLocation.getName());

        }
        br.close();
    }
}

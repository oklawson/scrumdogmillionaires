package com.scrumdog.donationtracker.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

import com.scrumdog.donationtracker.R;
import com.scrumdog.donationtracker.model.Location;
import com.scrumdog.donationtracker.model.User;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class DonationEntryActivity extends AppCompatActivity {

    private EditText shortDescription;
    private EditText fullDescription;
    private Spinner category;
    private EditText dollarValue;
    private EditText comments;
    private TextView addedMessage;
    private Button addButton;
    //make a LocationList Dropdown
    //add a picture upload category?



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            this.readSDFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_entry);

        shortDescription = (EditText)findViewById(R.id.shortDescription);
        fullDescription = (EditText)findViewById(R.id.fullDescription);
        category = (Spinner)findViewById(R.id.category);
        dollarValue = (EditText)findViewById(R.id.dollarValue);
        comments = (EditText)findViewById(R.id.comments);
        addedMessage = (TextView)findViewById(R.id.addedMessage);  //idk why not working?
        addButton = (Button) findViewById(R.id.addButton);

        //make an array of available categories for drop down
        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, Donation.theCategories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category.setAdapter(adapter);

        //When click add button, adds item to ArrayList of Items
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String category = category.getSelectedItem().toString();
                    Donation newDonation = new Donation(shortDescription.getText().toString(), fullDescription.getText().toString(), dollarValue.getText().toString(), comments.getText().toString(),category);

                    //display "added!"
                    addedMessage.setVisibility(View.VISIBLE);

                    Intent intent = new Intent(DonationEntryActivity.this, MainActivity.class);
                    startActivity(intent);
                }
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

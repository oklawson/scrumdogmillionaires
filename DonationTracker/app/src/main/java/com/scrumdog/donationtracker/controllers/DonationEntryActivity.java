package com.scrumdog.donationtracker.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

import com.scrumdog.donationtracker.R;
import com.scrumdog.donationtracker.model.User;


import java.util.ArrayList;

public class DonationEntryActivity extends AppCompatActivity {

    private EditText ShortDescription;
    private EditText FullDescription;
    private Spinner Category;
    private EditText DollarValue;
    private EditText Comments;
    //make a LocationList Dropdown
    //add a picture upload category?


    //implement add when all entry boxes are completed
    private Button Add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_entry);

        ShortDescription = (EditText)findViewById(R.id.shortDescription);
        FullDescription = (EditText)findViewById(R.id.fullDescription);
        Category = (Spinner)findViewById(R.id.category);
        DollarValue = (EditText)findViewById(R.id.dollarValue);
        Comments = (EditText)findViewById(R.id.comments);

        //make an array of available categories for drop down
        String[] categories = {"Clothing", "Hat", "Kitchen", "Electronics", "Household", "Other"};
        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, categories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Category.setAdapter(adapter);
    }



}

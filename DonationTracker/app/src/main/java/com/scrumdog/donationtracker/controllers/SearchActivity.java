package com.scrumdog.donationtracker.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.scrumdog.donationtracker.R;
import com.scrumdog.donationtracker.model.Donation;
import com.scrumdog.donationtracker.model.Location;
import com.scrumdog.donationtracker.model.User;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Spinner;

import java.util.Arrays;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private EditText SearchBar;
    private Button SearchButton;
    private TextView SearchTitle;
    private Spinner FilterSpinner;
    private TextView FilterByText;
    private Spinner LocationSpinner;
    private TextView LocationFilterText;
    private TextView CategoryText;
    private Spinner CategorySpinner;

    private String userSearchWord;
    private String searchFilter;
    private String searchLocation;
    private Location searchLoc;
    private String category;

    public static List<String> filterOptions = Arrays.asList("None", "Category", "Item Name");
    public static List<String> locationOptions = Arrays.asList("All Locations", "AFD Station 4", "Boys & Girls Club", "Pathway Christian Ministires", "Pavilion of Hope Inc", "D&D Convenience Store", "Keep North Fulton Beautiful");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        SearchBar = (EditText)findViewById(R.id.searchBar);
        SearchButton = (Button)findViewById(R.id.searchButton);
        SearchTitle = (TextView) findViewById(R.id.SearchTitle);
        FilterSpinner = (Spinner) findViewById(R.id.filterSpinner);
        FilterByText = (TextView) findViewById(R.id.filterByText);
        LocationSpinner = (Spinner) findViewById(R.id.LocationSpinner);
        LocationFilterText = (TextView) findViewById(R.id.locationFilterText);
        CategoryText = (TextView) findViewById(R.id.CategoryText);
        CategorySpinner = (Spinner) findViewById(R.id.CategorySpinner);

        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, filterOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        FilterSpinner.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, locationOptions);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        LocationSpinner.setAdapter(adapter2);

        ArrayAdapter<String> adapter3 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, Donation.theCategories);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        CategorySpinner.setAdapter(adapter3);

        LocationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                searchLocation = LocationSpinner.getSelectedItem().toString();
                if (searchLocation.equals("All Locations")) {
                    searchLoc = null;
                } else {
                    searchLoc = Donation.findLocationByName(searchLocation);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        FilterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                searchFilter = FilterSpinner.getSelectedItem().toString();
                if (searchFilter.equals("Category")) {
                    CategoryText.setVisibility(View.VISIBLE);
                    CategorySpinner.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        CategorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                category = CategorySpinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        //read in user search from search bar

        SearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when search button is clicked, display search results
            }
        });
    }
}

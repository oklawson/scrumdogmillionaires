package com.scrumdog.donationtracker.controllers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.scrumdog.donationtracker.R;
import com.scrumdog.donationtracker.model.Donation;
import com.scrumdog.donationtracker.model.Location;
//import com.scrumdog.donationtracker.model.User;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
//import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Spinner;
//import android.text.TextWatcher;
//import android.text.Editable;

import java.util.Arrays;
import java.util.List;


public class SearchActivity extends AppCompatActivity {

    private EditText SearchBar;
    private Spinner LocationSpinner;
    private TextView CategoryText;
    private Spinner CategorySpinner;


    public static String userSearchWord;
    //public static String searchFilter;
    public static String searchLocation;
    //private static Location searchLoc;
    public static String searchCategory;

    //public static boolean userSearchEntered = false;
    public static boolean locationSelected = false;
    public static boolean categorySelected = false;
    public static boolean itemNameSelected = false;
    //public static boolean nameSearch = false;

    private static final List<String> filterOptions = Arrays.asList("None", "Category", "Item Name");
    private static final List<String> locationOptions = Arrays.asList("All Locations", "AFD Station 4", "Boys & Girls Club", "Pathway Christian Ministries", "Pavilion of Hope Inc", "D&D Convenience Store", "Keep North Fulton Beautiful");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        SearchBar = (EditText)findViewById(R.id.searchBar);
        Button searchButton = (Button) findViewById(R.id.searchButton);
        //TextView searchTitle = (TextView) findViewById(R.id.SearchTitle);
        Spinner filterSpinner = (Spinner) findViewById(R.id.filterSpinner);
        //TextView filterByText = (TextView) findViewById(R.id.filterByText);
        LocationSpinner = (Spinner) findViewById(R.id.LocationSpinner);
        //TextView locationFilterText = (TextView) findViewById(R.id.locationFilterText);
        CategoryText = (TextView) findViewById(R.id.CategoryText);
        CategorySpinner = (Spinner) findViewById(R.id.CategorySpinner);

        userSearchWord = SearchBar.getText().toString();

        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, filterOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filterSpinner.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, locationOptions);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        LocationSpinner.setAdapter(adapter2);

        ArrayAdapter<String> adapter3 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, Donation.theCategories);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        CategorySpinner.setAdapter(adapter3);

        LocationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    locationSelected = false;
                } else {
                    locationSelected = true;
                    searchLocation = LocationSpinner.getSelectedItem().toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        filterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        categorySelected = false;
                        itemNameSelected = false;
                        break;
                    case 1:
                        categorySelected = true;
                        itemNameSelected = false;
                        CategoryText.setVisibility(View.VISIBLE);
                        CategorySpinner.setVisibility(View.VISIBLE);
                        break;
                    default:
                        userSearchWord = SearchBar.getText().toString();
                        itemNameSelected = true;
                        categorySelected = false;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        CategorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                searchCategory = CategorySpinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        //read in user search from search bar

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(SearchActivity.this, SearchList.class);
                    startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SearchActivity.this, MainActivity.class);
        startActivity(intent);
    }

}

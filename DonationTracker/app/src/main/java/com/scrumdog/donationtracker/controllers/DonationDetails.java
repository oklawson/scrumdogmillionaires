package com.scrumdog.donationtracker.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.scrumdog.donationtracker.R;
//import com.scrumdog.donationtracker.controllers.DonationList;
import android.widget.TextView;
//import android.widget.Button;
//import android.view.View;


public class DonationDetails extends AppCompatActivity {

    private TextView ShortDescription;
    private TextView FullDescription;
    private TextView Location;
    private TextView Category;
    private TextView Value;
    private TextView TimeStamp;
    private TextView Comments;

    private TextView sShortDescription;
    private TextView sFullDescription;
    private TextView sLocation;
    private TextView sCategory;
    private TextView sValue;
    private TextView sTimeStamp;
    private TextView sComments;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_details);

        String source = getIntent().getStringExtra("Source");

        if (source.equals("from DonationList")) {
            ShortDescription = (TextView) findViewById(R.id.shortDescription);
            FullDescription = (TextView) findViewById(R.id.fullDescription);
            Location = (TextView) findViewById(R.id.Location);
            Category = (TextView) findViewById(R.id.category);
            Value = (TextView) findViewById(R.id.price);
            TimeStamp = (TextView) findViewById(R.id.timestamp);
            Comments = (TextView) findViewById(R.id.comments);

            ShortDescription.setText(DonationList.ShortDescription);
            FullDescription.setText(DonationList.FullDescription);
            Location.setText(DonationList.Loc);
            Category.setText(DonationList.Category);
            Value.setText(DonationList.Val);
            TimeStamp.setText(DonationList.TimeStamp);
            Comments.setText(DonationList.Comments);
        } else {
            sShortDescription = (TextView) findViewById(R.id.shortDescription);
            sFullDescription = (TextView) findViewById(R.id.fullDescription);
            sLocation = (TextView) findViewById(R.id.Location);
            sCategory = (TextView) findViewById(R.id.category);
            sValue = (TextView) findViewById(R.id.price);
            sTimeStamp = (TextView) findViewById(R.id.timestamp);
            sComments = (TextView) findViewById(R.id.comments);

            sShortDescription.setText(SearchList.ShortDescription);
            sFullDescription.setText(SearchList.FullDescription);
            sLocation.setText(SearchList.Loc);
            sCategory.setText(SearchList.Category);
            sValue.setText(SearchList.Val);
            sTimeStamp.setText(SearchList.TimeStamp);
            sComments.setText(SearchList.Comments);
        }

    }



}

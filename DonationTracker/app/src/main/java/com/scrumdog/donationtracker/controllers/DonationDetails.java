package com.scrumdog.donationtracker.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.scrumdog.donationtracker.R;
//import com.scrumdog.donationtracker.controllers.DonationList;
import android.widget.TextView;
//import android.widget.Button;
//import android.view.View;


public class DonationDetails extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_details);

        String source = getIntent().getStringExtra("Source");

        if (source.equals("from DonationList")) {
            TextView shortDescription = (TextView) findViewById(R.id.shortDescription);
            TextView fullDescription = (TextView) findViewById(R.id.fullDescription);
            TextView location = (TextView) findViewById(R.id.Location);
            TextView category = (TextView) findViewById(R.id.category);
            TextView value = (TextView) findViewById(R.id.price);
            TextView timeStamp = (TextView) findViewById(R.id.timestamp);
            TextView comments = (TextView) findViewById(R.id.comments);

            shortDescription.setText(DonationList.ShortDescription);
            fullDescription.setText(DonationList.FullDescription);
            location.setText(DonationList.Loc);
            category.setText(DonationList.Category);
            value.setText(DonationList.Val);
            timeStamp.setText(DonationList.TimeStamp);
            comments.setText(DonationList.Comments);
        } else {
            TextView sShortDescription = (TextView) findViewById(R.id.shortDescription);
            TextView sFullDescription = (TextView) findViewById(R.id.fullDescription);
            TextView sLocation = (TextView) findViewById(R.id.Location);
            TextView sCategory = (TextView) findViewById(R.id.category);
            TextView sValue = (TextView) findViewById(R.id.price);
            TextView sTimeStamp = (TextView) findViewById(R.id.timestamp);
            TextView sComments = (TextView) findViewById(R.id.comments);

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

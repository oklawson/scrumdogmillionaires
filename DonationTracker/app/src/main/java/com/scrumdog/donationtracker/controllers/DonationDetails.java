package com.scrumdog.donationtracker.controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.scrumdog.donationtracker.R;
import com.scrumdog.donationtracker.controllers.DonationList;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;

public class DonationDetails extends AppCompatActivity {

    private TextView ShortDescription;
    private TextView FullDescription;
    private TextView Location;
    private TextView Category;
    private TextView Value;
    private TextView TimeStamp;
    private TextView Comments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_details);

        ShortDescription = (TextView)findViewById(R.id.shortDescription);
        FullDescription = (TextView)findViewById(R.id.fullDescription);
        Location = (TextView)findViewById(R.id.Location);
        Category = (TextView)findViewById(R.id.category);
        Value = (TextView)findViewById(R.id.price);
        TimeStamp = (TextView)findViewById(R.id.timestamp);
        Comments = (TextView)findViewById(R.id.comments);


        ShortDescription.setText(DonationList.ShortDescription);
        FullDescription.setText(DonationList.FullDescription);
        Location.setText(DonationList.Loc);
        Category.setText(DonationList.Category);
        Value.setText(DonationList.Val);
        TimeStamp.setText(DonationList.TimeStamp);
        Comments.setText(DonationList.Comments);

    }



}

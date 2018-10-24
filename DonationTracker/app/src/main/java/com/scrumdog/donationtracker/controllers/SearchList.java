package com.scrumdog.donationtracker.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.scrumdog.donationtracker.R;
import com.scrumdog.donationtracker.controllers.SearchActivity;

public class SearchList extends AppCompatActivity {

    public static String ShortDescription;
    public static String FullDescription;
    public static String Loc;
    public static String Category;
    public static String Val;
    public static String TimeStamp;
    public static String Comments;


    View.OnClickListener getOnClickDoSomething(final Button button)  {
        return new View.OnClickListener() {
            public void onClick(View v) {
                int id = button.getId();
                ShortDescription = DonationEntryActivity.donations.get(id).getshortDescription();
                FullDescription = DonationEntryActivity.donations.get(id).getFullDescription();
                Loc = DonationEntryActivity.donations.get(id).getItemLocationS();
                Category = DonationEntryActivity.donations.get(id).getCategory();
                Val = DonationEntryActivity.donations.get(id).getdollarValue();
                TimeStamp = DonationEntryActivity.donations.get(id).getTimeStamp().toString();
                Comments = DonationEntryActivity.donations.get(id).getComments();
                Intent intent = new Intent(SearchList.this, DonationDetails.class);
                startActivity(intent);
            }
        };
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_list);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);  //Can also be done in xml by android:orientation="vertical"

        //user doesn't select location or filter or enter any search -> SHOW ALL ITEMS
        if (!SearchActivity.userSearchEntered && !SearchActivity.locationSelected && !SearchActivity.categorySelected) {
            if (DonationEntryActivity.donations.size() > 0) {

                for (int i = 0; i < DonationEntryActivity.donations.size(); i++) {
                    //if (DonationEntryActivity.donations.get(i).getCategory().equals("Clothing")) {
                        //DonationEntryActivity.donations.get(i).setListed(true);
                        LinearLayout row = new LinearLayout(this);
                        row.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));

                        //for (int j = 0; j < 2; j++) {
                        TextView tvTag = new TextView(this);
                        tvTag.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                        tvTag.setText(DonationEntryActivity.donations.get(i).toString());
                        tvTag.setId(i);
                        row.addView(tvTag);
                        Button btnTag = new Button(this);
                        btnTag.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                        btnTag.setText("View Details");
                        btnTag.setId(i);
                        row.addView(btnTag);
                        btnTag.setOnClickListener(getOnClickDoSomething(btnTag));

                        layout.addView(row);
                    //}
                }
                setContentView(layout);
            }
            SearchActivity.userSearchEntered = false;
            SearchActivity.locationSelected = false;
            SearchActivity.categorySelected = false;
            SearchActivity.itemNameSelected = false;
        }

        //user only selects a location -> SHOW ALL ITEMS AT THAT LOCATION
        if (!SearchActivity.userSearchEntered && SearchActivity.locationSelected && !SearchActivity.categorySelected) {
            if (DonationEntryActivity.donations.size() > 0) {

                for (int i = 0; i < DonationEntryActivity.donations.size(); i++) {
                    if (DonationEntryActivity.donations.get(i).getItemLocationS().equals(SearchActivity.searchLocation)) {
                    //DonationEntryActivity.donations.get(i).setListed(true);
                    LinearLayout row = new LinearLayout(this);
                    row.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));

                    //for (int j = 0; j < 2; j++) {
                    TextView tvTag = new TextView(this);
                    tvTag.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                    tvTag.setText(DonationEntryActivity.donations.get(i).toString());
                    tvTag.setId(i);
                    row.addView(tvTag);
                    Button btnTag = new Button(this);
                    btnTag.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                    btnTag.setText("View Details");
                    btnTag.setId(i);
                    row.addView(btnTag);
                    btnTag.setOnClickListener(getOnClickDoSomething(btnTag));

                    layout.addView(row);
                    }
                }
                setContentView(layout);
            }
            SearchActivity.userSearchEntered = false;
            SearchActivity.locationSelected = false;
            SearchActivity.categorySelected = false;
            SearchActivity.itemNameSelected = false;
        }

        //user only selects a category -> SHOW ALL ITEMS IN THAT CATEGORY
        if (!SearchActivity.userSearchEntered && !SearchActivity.locationSelected && SearchActivity.categorySelected) {
            if (DonationEntryActivity.donations.size() > 0) {

                for (int i = 0; i < DonationEntryActivity.donations.size(); i++) {
                    if (DonationEntryActivity.donations.get(i).getCategory().equals(SearchActivity.searchCategory)) {
                        //DonationEntryActivity.donations.get(i).setListed(true);
                        LinearLayout row = new LinearLayout(this);
                        row.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));

                        //for (int j = 0; j < 2; j++) {
                        TextView tvTag = new TextView(this);
                        tvTag.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                        tvTag.setText(DonationEntryActivity.donations.get(i).toString());
                        tvTag.setId(i);
                        row.addView(tvTag);
                        Button btnTag = new Button(this);
                        btnTag.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                        btnTag.setText("View Details");
                        btnTag.setId(i);
                        row.addView(btnTag);
                        btnTag.setOnClickListener(getOnClickDoSomething(btnTag));

                        layout.addView(row);
                    }
                }
                setContentView(layout);
            }
            SearchActivity.userSearchEntered = false;
            SearchActivity.locationSelected = false;
            SearchActivity.categorySelected = false;
            SearchActivity.itemNameSelected = false;
        }

        //user only selects a category and location -> SHOW ALL ITEMS IN THAT CATEGORY AT THAT LOCATION
        if (!SearchActivity.userSearchEntered && SearchActivity.locationSelected && SearchActivity.categorySelected) {
            if (DonationEntryActivity.donations.size() > 0) {

                for (int i = 0; i < DonationEntryActivity.donations.size(); i++) {
                    if (DonationEntryActivity.donations.get(i).getCategory().equals(SearchActivity.searchCategory)
                            && DonationEntryActivity.donations.get(i).getItemLocationS().equals(SearchActivity.searchLocation)) {
                        //DonationEntryActivity.donations.get(i).setListed(true);
                        LinearLayout row = new LinearLayout(this);
                        row.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));

                        //for (int j = 0; j < 2; j++) {
                        TextView tvTag = new TextView(this);
                        tvTag.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                        tvTag.setText(DonationEntryActivity.donations.get(i).toString());
                        tvTag.setId(i);
                        row.addView(tvTag);
                        Button btnTag = new Button(this);
                        btnTag.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                        btnTag.setText("View Details");
                        btnTag.setId(i);
                        row.addView(btnTag);
                        btnTag.setOnClickListener(getOnClickDoSomething(btnTag));

                        layout.addView(row);
                    }
                }
                setContentView(layout);
            }
            SearchActivity.userSearchEntered = false;
            SearchActivity.locationSelected = false;
            SearchActivity.categorySelected = false;
            SearchActivity.itemNameSelected = false;
        }

        //user selects item name search and enters name in search bar -> SHOW ALL ITEMS WITH THAT NAME
        if (SearchActivity.userSearchEntered && !SearchActivity.locationSelected && !SearchActivity.categorySelected) {
            if (SearchActivity.itemNameSelected) {
                if (DonationEntryActivity.donations.size() > 0) {

                    for (int i = 0; i < DonationEntryActivity.donations.size(); i++) {
                        if (DonationEntryActivity.donations.get(i).getshortDescription().equals(SearchActivity.userSearchWord)) {
                            //DonationEntryActivity.donations.get(i).setListed(true);
                            LinearLayout row = new LinearLayout(this);
                            row.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));

                            //for (int j = 0; j < 2; j++) {
                            TextView tvTag = new TextView(this);
                            tvTag.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                            tvTag.setText(DonationEntryActivity.donations.get(i).toString());
                            tvTag.setId(i);
                            row.addView(tvTag);
                            Button btnTag = new Button(this);
                            btnTag.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                            btnTag.setText("View Details");
                            btnTag.setId(i);
                            row.addView(btnTag);
                            btnTag.setOnClickListener(getOnClickDoSomething(btnTag));

                            layout.addView(row);
                        }
                    }
                    setContentView(layout);
                }
            }
            SearchActivity.userSearchEntered = false;
            SearchActivity.locationSelected = false;
            SearchActivity.categorySelected = false;
            SearchActivity.itemNameSelected = false;
        }

        //user selects item name search, category, and location -> SHOW ALL ITEMS WITH THAT CRITERIA
        if (SearchActivity.userSearchEntered && SearchActivity.locationSelected && SearchActivity.categorySelected) {
            if (SearchActivity.itemNameSelected) {
                if (DonationEntryActivity.donations.size() > 0) {

                    for (int i = 0; i < DonationEntryActivity.donations.size(); i++) {
                        if (DonationEntryActivity.donations.get(i).getshortDescription().equals(SearchActivity.userSearchWord)
                                && DonationEntryActivity.donations.get(i).getCategory().equals(SearchActivity.searchCategory)
                                && DonationEntryActivity.donations.get(i).getItemLocationS().equals(SearchActivity.searchLocation)) {
                            //DonationEntryActivity.donations.get(i).setListed(true);
                            LinearLayout row = new LinearLayout(this);
                            row.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));

                            //for (int j = 0; j < 2; j++) {
                            TextView tvTag = new TextView(this);
                            tvTag.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                            tvTag.setText(DonationEntryActivity.donations.get(i).toString());
                            tvTag.setId(i);
                            row.addView(tvTag);
                            Button btnTag = new Button(this);
                            btnTag.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                            btnTag.setText("View Details");
                            btnTag.setId(i);
                            row.addView(btnTag);
                            btnTag.setOnClickListener(getOnClickDoSomething(btnTag));

                            layout.addView(row);
                        }
                    }
                    setContentView(layout);
                }
            }
            SearchActivity.userSearchEntered = false;
            SearchActivity.locationSelected = false;
            SearchActivity.categorySelected = false;
            SearchActivity.itemNameSelected = false;
        }

        //user selects item name search and category  -> SHOW ALL ITEMS WITH THAT CRITERIA
        if (SearchActivity.userSearchEntered && SearchActivity.locationSelected && SearchActivity.categorySelected) {
            if (SearchActivity.itemNameSelected) {
                if (DonationEntryActivity.donations.size() > 0) {

                    for (int i = 0; i < DonationEntryActivity.donations.size(); i++) {
                        if (DonationEntryActivity.donations.get(i).getshortDescription().toLowerCase().equals(SearchActivity.userSearchWord)
                                && DonationEntryActivity.donations.get(i).getCategory().equals(SearchActivity.searchCategory)) {
                            //DonationEntryActivity.donations.get(i).setListed(true);
                            LinearLayout row = new LinearLayout(this);
                            row.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));

                            //for (int j = 0; j < 2; j++) {
                            TextView tvTag = new TextView(this);
                            tvTag.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                            tvTag.setText(DonationEntryActivity.donations.get(i).toString());
                            tvTag.setId(i);
                            row.addView(tvTag);
                            Button btnTag = new Button(this);
                            btnTag.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                            btnTag.setText("View Details");
                            btnTag.setId(i);
                            row.addView(btnTag);
                            btnTag.setOnClickListener(getOnClickDoSomething(btnTag));

                            layout.addView(row);
                        }
                    }
                    setContentView(layout);
                }
            }
            SearchActivity.userSearchEntered = false;
            SearchActivity.locationSelected = false;
            SearchActivity.categorySelected = false;
            SearchActivity.itemNameSelected = false;
        }

        //user selects item name search and location -> SHOW ALL ITEMS WITH THAT CRITERIA
        if (SearchActivity.userSearchEntered && SearchActivity.locationSelected && SearchActivity.categorySelected) {
            if (SearchActivity.itemNameSelected) {
                if (DonationEntryActivity.donations.size() > 0) {

                    for (int i = 0; i < DonationEntryActivity.donations.size(); i++) {
                        if (DonationEntryActivity.donations.get(i).getshortDescription().toLowerCase().equals(SearchActivity.userSearchWord)
                                && DonationEntryActivity.donations.get(i).getItemLocationS().equals(SearchActivity.searchLocation)) {
                            //DonationEntryActivity.donations.get(i).setListed(true);
                            LinearLayout row = new LinearLayout(this);
                            row.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));

                            //for (int j = 0; j < 2; j++) {
                            TextView tvTag = new TextView(this);
                            tvTag.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                            tvTag.setText(DonationEntryActivity.donations.get(i).toString());
                            tvTag.setId(i);
                            row.addView(tvTag);
                            Button btnTag = new Button(this);
                            btnTag.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                            btnTag.setText("View Details");
                            btnTag.setId(i);
                            row.addView(btnTag);
                            btnTag.setOnClickListener(getOnClickDoSomething(btnTag));

                            layout.addView(row);
                        }
                    }
                    setContentView(layout);
                }
            }
            SearchActivity.userSearchEntered = false;
            SearchActivity.locationSelected = false;
            SearchActivity.categorySelected = false;
            SearchActivity.itemNameSelected = false;
        }


    }


    }


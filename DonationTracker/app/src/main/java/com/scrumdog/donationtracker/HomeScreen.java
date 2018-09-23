package com.scrumdog.donationtracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }

    public void login(View view) {
        // Do something in response to button click
        startActivity(new Intent(HomeScreen.this, LoginActivity.class));
    }
}

package com.scrumdog.donationtracker.controllers;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
//import android.widget.Spinner;

import android.content.Intent;

//import com.scrumdog.donationtracker.model.User;
import com.scrumdog.donationtracker.model.UserManagement;
//import com.scrumdog.donationtracker.model.UserManager;


import com.scrumdog.donationtracker.R;


/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

        private EditText Username;
        private EditText Password;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            Username = (EditText)findViewById(R.id.etUsername);
            Password = (EditText)findViewById(R.id.etPassword);
            Button login = (Button) findViewById(R.id.btnLogin);
            Button cancel = (Button) findViewById(R.id.cancelButton);
        TextView invalidLogin = (TextView) findViewById(R.id.invalidLoginMessage);
            Button addDonation = (Button) findViewById(R.id.viewDonationEntryPage);


            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    UserManagement umt = UserManagement.getInstance();
                    Log.d("MYAPP","check umt login user: " + Username.getText().toString() + " pass: " + Password.getText().toString());
                    if (umt.doLogin(Username.getText().toString(), Password.getText().toString())) {
                        Log.d("MYAPP","login success");
                        umt.setCurrentUser(umt.getUserByID(Username.getText().toString()));
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                    // invalid login
                }
            });

            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(LoginActivity.this, HomeScreen.class);
                    startActivity(intent);
                }
            });
        }
}


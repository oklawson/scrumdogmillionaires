package com.scrumdog.donationtracker.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
//import android.widget.SimpleAdapter;
import android.view.View;
import android.view.View.OnClickListener;
//import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.scrumdog.donationtracker.R;
import com.scrumdog.donationtracker.model.User;
//import com.scrumdog.donationtracker.controllers.LoginActivity;
import com.scrumdog.donationtracker.model.UserManagement;
import java.io.File;


/**
 * A screen that offers registration via email/password.
 */
public class RegistrationActivity extends AppCompatActivity  {

        private EditText Name;
        private EditText Password;
        private EditText userID;
        private Spinner accountTypeSpinner;
        private Spinner specificLocationSpinner;
    private TextView invalidUsername;

        private final UserManagement umt = UserManagement.getInstance();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_registration);

            Name = (EditText)findViewById(R.id.etName);
            Password = (EditText)findViewById(R.id.etPassword);
            userID = (EditText)findViewById(R.id.etID);
            accountTypeSpinner = (Spinner)findViewById(R.id.accountTypeSpinner);
            specificLocationSpinner = (Spinner)findViewById(R.id.specificLocationSpinner);
            Button register = (Button) findViewById(R.id.btnRegister);
            Button cancel = (Button) findViewById(R.id.cancelButton);
            //TextView invalidRegistration = (TextView) findViewById(R.id.invalidRegistrationMessage);
            invalidUsername =(TextView)findViewById(R.id.invalidUsernameMessage);


            ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, User.legalUsers);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            accountTypeSpinner.setAdapter(adapter);

            ArrayAdapter<String> adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, User.legalUsersLocations);
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            specificLocationSpinner.setAdapter(adapter2);


            accountTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position == 1) {
                        specificLocationSpinner.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });




            register.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    String userLocation;
                    //username doesn't exist, so create new user
                    if(!validate(userID.getText().toString())) {
                        String userType = accountTypeSpinner.getSelectedItem().toString();
                        if (!userType.equals("Location Employee")) {
                            userLocation = null;
                        } else {
                            userLocation = specificLocationSpinner.getSelectedItem().toString();
                        }
                        umt.addNewUser(Name.getText().toString(), userID.getText().toString(), userType, userLocation, Password.getText().toString());
                        User newUser = new User(Name.getText().toString(), userID.getText().toString(), userType, userLocation, Password.getText().toString());
                        umt.saveJson(new File(getApplicationContext().getFilesDir(), UserManagement.DEFAULT_JSON_FILE_NAME));
                        //umt.doLogin(userID.getText().toString(), Password.getText().toString());
                        umt.setCurrentUser(newUser);
                        Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        invalidUsername.setVisibility(View.VISIBLE);
                    }
                    }
            });


            cancel.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(RegistrationActivity.this, HomeScreen.class);
                    startActivity(intent);
                }
            });
        }

        /**
        * check if username already exists
        *
        * @param userID is a string of the User's username
        */
        public boolean validate(String userID) {
            //if username does not already exist, return false
            if(umt.getUserByID(userID) == null) {
                return false;
            //if username does exist, return true
            } else {
                return true;
            }
        }

}


package com.scrumdog.donationtracker.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SimpleAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.scrumdog.donationtracker.R;
import com.scrumdog.donationtracker.model.User;
import com.scrumdog.donationtracker.controllers.LoginActivity;

/**
 * A screen that offers registration via email/password.
 */
public class RegistrationActivity extends AppCompatActivity  {

        private EditText Name;
        private EditText Password;
        private EditText userID;
        private Spinner accountTypeSpinner;
        private Spinner specificLocationSpinner;
        private Button Register;
        private Button Cancel;
        private TextView invalidRegistration;
        private TextView invalidUsername;
        private String usertype;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_registration);

            Name = (EditText)findViewById(R.id.etName);
            Password = (EditText)findViewById(R.id.etPassword);
            userID = (EditText)findViewById(R.id.etID);
            accountTypeSpinner = (Spinner)findViewById(R.id.accountTypeSpinner);
            specificLocationSpinner = (Spinner)findViewById(R.id.specificLocationSpinner);
            Register = (Button)findViewById(R.id.btnRegister);
            Cancel = (Button) findViewById(R.id.cancelButton);
            invalidRegistration =(TextView)findViewById(R.id.invalidRegistrationMessage);
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
                    //usertype = parent.getItemAtPosition(position).toString();
                    if (position == 1) {
                        specificLocationSpinner.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });




            Register.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    //username doesn't exist, so create new user
                    if(validate(userID.getText().toString()) == false) {
                        String userType = accountTypeSpinner.getSelectedItem().toString();
                        String userLocation = specificLocationSpinner.getSelectedItem().toString();
                        User newUser = new User(Name.getText().toString(), userID.getText().toString(), Password.getText().toString(), userType, userLocation);
                        Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        invalidUsername.setVisibility(View.VISIBLE);
                    }
                    }
            });


            Cancel.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(RegistrationActivity.this, HomeScreen.class);
                    startActivity(intent);
                }
            });
        }

        //check if username already exists
        private boolean validate(String userID) {
            //if username does not already exist, return false
            if(LoginActivity.findUserById(userID) == null) {
                return false;
            //if username does exist, return true
            } else {
                return true;
            }
        }

}


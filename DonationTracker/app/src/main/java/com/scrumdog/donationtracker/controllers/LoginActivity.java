package com.scrumdog.donationtracker.controllers;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Spinner;

import android.content.Intent;

import com.scrumdog.donationtracker.model.User;


import com.scrumdog.donationtracker.R;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

        private EditText Username;
        private EditText Password;
        private Button Login;
        private Button Cancel;
        private Button AddDonation;
        private TextView invalidLogin;
        public User currentUser;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            Username = (EditText)findViewById(R.id.etUsername);
            Password = (EditText)findViewById(R.id.etPassword);
            Login = (Button)findViewById(R.id.btnLogin);
            Cancel = (Button) findViewById(R.id.cancelButton);
            invalidLogin =(TextView)findViewById(R.id.invalidLoginMessage);
            AddDonation = (Button) findViewById(R.id.viewDonationEntryPage);


            Login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    validate(Username.getText().toString(), Password.getText().toString());
                }
            });

            Cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(LoginActivity.this, HomeScreen.class);
                    startActivity(intent);
                }
            });
        }

        /**
        * Finds a user using O(n) linear search given a unique user ID
        * @param userID
        * @return
        */
        public static User findUserById(String userID) {
            for (User u : User._users) {
                if (userID.equals(u.getID())) {
                 return u;
                }
            }
            return null;
        }

        private void validate(String userName, String userPassword){
            try {
                currentUser = findUserById(userName);
                if (userPassword.equals(currentUser.getPassword())) {
                    User.setCurrentUser(currentUser);
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    invalidLogin.setVisibility(View.VISIBLE);
                }
            } catch (Exception e) {
                invalidLogin.setVisibility(View.VISIBLE);
                return;
            }
        }

}


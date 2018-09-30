package com.scrumdog.donationtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A screen that offers registration via email/password.
 */
public class RegistrationActivity extends AppCompatActivity {

        private EditText Name;
        private EditText Password;
        private Button Register;
        private Button Cancel;
        private TextView invalidRegistration;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_registration);

            Name = (EditText)findViewById(R.id.etName);
            Password = (EditText)findViewById(R.id.etPassword);
            Register = (Button)findViewById(R.id.btnRegister);
            Cancel = (Button) findViewById(R.id.cancelButton);
            invalidRegistration =(TextView)findViewById(R.id.invalidRegistrationMessage);


            Register.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    validate(Name.getText().toString(), Password.getText().toString());
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

        private void validate(String userName, String userPassword){
            if((userName.equals("user")) && (userPassword.equals("pass"))){
                Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                startActivity(intent);
            } else {
                invalidRegistration.setVisibility(View.VISIBLE);
            }
        }

}


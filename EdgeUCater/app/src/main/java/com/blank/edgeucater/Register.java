package com.blank.edgeucater;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity implements View.OnClickListener{

    Button createButton;
    EditText firstName, lastName, studentID, email, password, confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);
        studentID = (EditText) findViewById(R.id.studentID);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        confirmPassword = (EditText) findViewById(R.id.confirmPassword);
        createButton = (Button) findViewById(R.id.createButton);

        createButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.createButton:

                String firstName = this.firstName.getText().toString();
                String lastName = this.lastName.getText().toString();
                int studentID = Integer.parseInt(this.studentID.getText().toString());
                String email = this.email.getText().toString();
                String password = this.password.getText().toString();
                String confirmPassword = this.confirmPassword.getText().toString();

                if(password.equals(confirmPassword)) {
                    User regData = new User(firstName, lastName, email, password, studentID);
                }


                break;
        }
    }

}

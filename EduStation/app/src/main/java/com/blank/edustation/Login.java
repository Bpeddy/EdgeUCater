package com.blank.edustation;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.widget.*;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Login extends AppCompatActivity implements View.OnClickListener{

    Button loginButton;
    EditText emailLogin, passwordLogin;
    TextView registerLink;
    UserLocalStore userLocalStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        emailLogin = (EditText) findViewById(R.id.emailLogin);
        passwordLogin = (EditText) findViewById(R.id.passwordLogin);
        loginButton = (Button) findViewById(R.id.loginButton);
        registerLink = (TextView) findViewById(R.id.registerLink);

        loginButton.setOnClickListener(this);
        registerLink.setOnClickListener(this);

        userLocalStore = new UserLocalStore(this);


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.loginButton:

                String email = emailLogin.getText().toString();
                String password = passwordLogin.getText().toString();

                User user = new User(email, password);

                authenticate(user);

                break;
            case R.id.registerLink:

                startActivity(new Intent(this, Register.class));

                break;
        }
    }

    private void authenticate(User user){
        ServerRequests serverRequest = new ServerRequests(this);
        serverRequest.fetchUserDataInBackground(user, new GetUserCallback() {
            @Override
            public void done(User returnedUser) {
                if(returnedUser == null){
                    showErrorPassword();
                } else{
                    logUserIn(returnedUser);
                }
            }
        });

    }

    private void showErrorPassword(){
        AlertDialog.Builder dBuilder = new AlertDialog.Builder(Login.this);
        dBuilder.setMessage("Wrong log in info!");
        dBuilder.setPositiveButton("OK", null);
        dBuilder.show();
    }

    private void logUserIn(User returnedUser){
        userLocalStore.storeUserData(returnedUser);
        userLocalStore.setLoggedIn(true);

        startActivity(new Intent(this, StartupMenu.class));
    }
}

package com.blank.edustation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class StartupMenu extends AppCompatActivity{

    AppCompatActivity parent = this;
    Button searchButton, ProfileButton;
    UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        userLocalStore = new UserLocalStore(this);
        userLocalStore = new UserLocalStore(this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        ProfileButton = (Button) findViewById(R.id.button2);
        ProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StartupMenu.this, TutorProfile.class);
                StartupMenu.this.startActivity(i);
            }
        });

        searchButton = (Button) findViewById(R.id.search);
        searchButton.setOnClickListener(new SearchButtonListener());
    }

    @Override
    protected void onStart(){
        super.onStart();
        if(!userLocalStore.getLoggedIn()){
            startActivity(new Intent(StartupMenu.this, Login.class));
        }
    }

    public class SearchButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.search:

                    startActivity(new Intent(parent, SearchMenu.class));

                    break;
            }
        }
    }
}

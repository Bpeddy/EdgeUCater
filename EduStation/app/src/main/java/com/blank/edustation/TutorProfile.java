package com.blank.edustation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TutorProfile extends AppCompatActivity {
    TextView name,major,age,email;
    Button calendarButton;
    AppCompatActivity parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_profile);
        parent = this;

        name = (TextView) findViewById(R.id.NameField);
        name.setText("Andy Android");
        name.setTextIsSelectable(false);


        major = (TextView) findViewById(R.id.MajorField);
        major.setText("Computer Science");
        major.setTextIsSelectable(false);
        // if(!major.isTextSelectable())Log.e("it workedddddd","");

        email = (TextView) findViewById(R.id.EmailField);
        email.setText("example@gmail.com");
        email.setTextIsSelectable(false);

        age = (TextView) findViewById(R.id.AgeField);
        age.setText("23");
        age.setTextIsSelectable(false);

        calendarButton = (Button) findViewById(R.id.calendarButton);
        calendarButton.setText("calendar");
        calendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TutorProfile.this, TutorCalendar.class);
                TutorProfile.this.startActivity(i);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_Profile) {
            startActivity(new Intent(parent, TutorProfile.class));
            return true;
        }
        if (id == R.id.action_Search) {
            startActivity(new Intent(parent, SearchMenu.class));
            return true;
        }
        if (id == R.id.action_Logout) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

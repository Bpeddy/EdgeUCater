package com.blank.edustation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class TutorCalendar extends AppCompatActivity {
    Button tutorSessions,studyGroups;
    AppCompatActivity parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_calendar);
        parent = this;

        tutorSessions= (Button) findViewById(R.id.button3);
        tutorSessions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TutorCalendar.this, ViewTutorSessions.class);
                TutorCalendar.this.startActivity(i);
            }
        });

        studyGroups = (Button) findViewById(R.id.button4);
        studyGroups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TutorCalendar.this, ViewStudyGroups.class);
                TutorCalendar.this.startActivity(i);
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

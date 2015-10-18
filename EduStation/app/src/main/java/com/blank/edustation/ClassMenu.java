package com.blank.edustation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class ClassMenu extends AppCompatActivity {

    Button button;
    AppCompatActivity parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ListView help = (ListView) findViewById(R.id.help);

        final List<String> categoryList=new ArrayList<String>();
        final List<String> helpList=new ArrayList<String>();
        button = (Button) findViewById(R.id.button);
        parent = this;

        Spinner categories = (Spinner) findViewById(R.id.categories);
        ArrayAdapter<String> adp1=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,categoryList);
        categoryList.add("Tutors");
        categoryList.add("Study Groups");
        categories.setAdapter(adp1);

        final ArrayAdapter<String> adp2=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,helpList);
        help.setAdapter(adp2);


        Intent intent = this.getIntent();
        String clasS = intent.getStringExtra("CLASS");

        categories.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView,
                                       int position, long id) {
                switch (position) {
                    case 0:
                        button.setText("Apply to Tutor");
                        helpList.clear();
                        helpList.add("Michael Moore Rating: Good");
                        helpList.add("Jonathan Rogers Rating: Good");
                        helpList.add("Brian Eddy Rating: Adequate");
                        adp2.notifyDataSetChanged();
                        break;
                    case 1:
                        button.setText("Create Study Group");
                        helpList.clear();
                        helpList.add("Exam Positions: 3");
                        helpList.add("Classes Positions: 4");
                        helpList.add("Project 2 Positions: 4");
                        adp2.notifyDataSetChanged();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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

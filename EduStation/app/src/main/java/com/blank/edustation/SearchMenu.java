package com.blank.edustation;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

import java.util.ArrayList;
import java.util.List;

public class SearchMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final List<String> majorList=new ArrayList<String>();
        final List<String> classesList=new ArrayList<String>();
        majorList.add("None");
        majorList.add("Computer Science");
        majorList.add("Software Engineering");


        final Spinner majors = (Spinner) findViewById(R.id.majors);
        final ListView classes = (ListView) findViewById(R.id.classes);

        ArrayAdapter<String> adp1=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,majorList);
        adp1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        majors.setAdapter(adp1);
        final ArrayAdapter<String> adp2=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,classesList);
        classes.setAdapter(adp2);

        majors.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                switch (position) {
                    case 0:
                        classesList.clear();
                        adp2.notifyDataSetChanged();
                        break;
                    case 1:
                        classesList.clear();
                        classesList.add("Object Oriented Programming");
                        classesList.add("Theory of Computation");
                        adp2.notifyDataSetChanged();
                        break;
                    case 2:
                        classesList.clear();
                        classesList.add("Software Engineering I");
                        classesList.add("Software Engineering II");
                        adp2.notifyDataSetChanged();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}

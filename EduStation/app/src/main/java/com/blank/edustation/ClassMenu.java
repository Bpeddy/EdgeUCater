package com.blank.edustation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class ClassMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ListView tutors = (ListView) findViewById(R.id.help);

        final List<String> categoryList=new ArrayList<String>();
        final List<String> tutorsList=new ArrayList<String>();
        final List<String> groupsList=new ArrayList<String>();

        Spinner categories = (Spinner) findViewById(R.id.categories);
        ArrayAdapter<String> adp2=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,categoryList);
        categoryList.add("Tutors");
        categoryList.add("Study Groups");
        categoryList.add("View Reports");
        categoryList.add("Previous Groups");
        categories.setAdapter(adp2);

        ArrayAdapter<String> adp1=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,tutorsList);
        tutorsList.add("Michael Moore Rating: ");
        tutorsList.add("Jonathan Rogers Rating: ");
        tutorsList.add("Brian Eddy Rating: ");
        tutors.setAdapter(adp1);

        Intent intent = this.getIntent();
        String clasS = intent.getStringExtra("CLASS");
    }

}

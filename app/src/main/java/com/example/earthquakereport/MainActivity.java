package com.example.earthquakereport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView listView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView  = findViewById(R.id.list);

        ArrayList<Earthquake> earthquakes = new ArrayList<Earthquake>();
        earthquakes.add(new Earthquake("1.1","San Fransico", "4 Feb 20021"));
        earthquakes.add(new Earthquake("1.1","San Fransico", "4 Feb 20021"));
        earthquakes.add(new Earthquake("2.3","San Fransico", "4 Feb 20021"));
        earthquakes.add(new Earthquake("5.2","San Fransico", "4 Feb 20021"));
        earthquakes.add(new Earthquake("3.1","San Fransico", "4 Feb 20021"));
        earthquakes.add(new Earthquake("2.1","San Fransico", "4 Feb 20021"));
        earthquakes.add(new Earthquake("4.1","San Fransico", "4 Feb 20021"));


        QuakeAdapter adapter  = new QuakeAdapter(this,earthquakes);

        listView.setAdapter(adapter);

    }
}

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

        ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthQuakes();



        QuakeAdapter adapter  = new QuakeAdapter(this,earthquakes);

        listView.setAdapter(adapter);

    }
}

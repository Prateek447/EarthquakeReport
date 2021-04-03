package com.example.earthquakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class QuakeAdapter extends ArrayAdapter<Earthquake> {

    public QuakeAdapter(Context context, ArrayList<Earthquake> list) {
        super(context, 0, list);
    }

    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Earthquake earthquake = getItem(position);

        TextView mag   =  listItemView.findViewById(R.id.first_text);

         mag.setText(earthquake.getMag());

         TextView place = listItemView.findViewById(R.id.second_text);

         place.setText(earthquake.getPlace());

         TextView date  =  listItemView.findViewById(R.id.third_text);

         date.setText(earthquake.getDate());

         return listItemView;
    }
}

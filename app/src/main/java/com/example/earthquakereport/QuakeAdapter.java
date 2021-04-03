package com.example.earthquakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class QuakeAdapter extends ArrayAdapter<Earthquake> {

    public QuakeAdapter(Context context, ArrayList<Earthquake> list) {
        super(context, 0, list);
    }


    private String  formateDate(Date dateObj){
        SimpleDateFormat dateFormat =  new SimpleDateFormat("LLL dd, yyyy");
        return  dateFormat.format(dateObj);
    }

    private String formateTime(Date dateObj){
        SimpleDateFormat dateFormat = new SimpleDateFormat("h:mm a");
        return dateFormat.format(dateObj);
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

         String offset_location ;
         String primary_location;
         int size = earthquake.getPlace().length();

         if(!earthquake.getPlace().contains("of")){
             offset_location = "Near the";
             primary_location=earthquake.getPlace();
         }
         else {
            int index =  earthquake.getPlace().indexOf("of");
            offset_location =  earthquake.getPlace().substring(0,index+2);

            primary_location =  earthquake.getPlace().substring(index+2,size);
         }


          TextView offset = listItemView.findViewById(R.id.location_offset);
         offset.setText(offset_location);
         TextView primary = listItemView.findViewById(R.id.primary_location);
         primary.setText(primary_location);

         Date dateObj = new Date(earthquake.getTimeInMilliSeconds());

         TextView date =  listItemView.findViewById(R.id.date);
         date.setText(formateDate(dateObj));

         TextView time = listItemView.findViewById(R.id.time);
         time.setText(formateTime(dateObj));

         return listItemView;
    }
}

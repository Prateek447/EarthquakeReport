package com.example.earthquakereport;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.core.content.ContextCompat;

import org.json.JSONObject;

import java.text.DecimalFormat;
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

    private String decimalFormate(double mag){
        DecimalFormat decimalFormat =  new DecimalFormat("0.0");
        return  decimalFormat.format(mag);
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }






    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Earthquake earthquake = getItem(position);


        TextView mag   =  listItemView.findViewById(R.id.magnitude);

         mag.setText(decimalFormate(earthquake.getMag()));


        GradientDrawable magnitudeCircle = (GradientDrawable) mag.getBackground();

        int magnitude =  getMagnitudeColor(earthquake.getMag());

        magnitudeCircle.setColor(magnitude);

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

            primary_location =  earthquake.getPlace().substring(index+3,size);
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

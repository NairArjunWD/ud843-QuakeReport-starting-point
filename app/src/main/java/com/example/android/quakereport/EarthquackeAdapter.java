package com.example.android.quakereport;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EarthquackeAdapter extends ArrayAdapter<EarthquakeList> {


    public EarthquackeAdapter(Activity context, ArrayList<EarthquakeList> list) {
        super(context, 0, list);

    }
    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.view, parent, false);
        }

        EarthquakeList e = getItem(position);

        TextView mag = (TextView) listItemView.findViewById(R.id.mag);

         mag.setText(e.getMag());

        TextView location = (TextView) listItemView.findViewById(R.id.city);
        location.setText(e.getLocation());

        TextView time = (TextView) listItemView.findViewById(R.id.date);
        Date dateObject = new Date(e.getTimeInMilliseconds());
        String formattedDate = formatDate(dateObject);
        String formattedTime = formatTime(dateObject);
        time.setText(formattedDate);
        TextView date = (TextView) listItemView.findViewById(R.id.date2);
        date.setText(formattedTime);

        return listItemView;



    }
    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
}

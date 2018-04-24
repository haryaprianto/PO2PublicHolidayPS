package com.example.a16022596.po2publicholidayps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HolidayAdapter extends ArrayAdapter<HolidayDetail>{

    private ArrayList<HolidayDetail> holiday;
    private Context context;
    private ImageView imgIcon;
    private TextView tvDate;
    private  TextView tvTitle;

    public HolidayAdapter(Context context, int resource, ArrayList<HolidayDetail> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        holiday = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }


    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvTitle = (TextView) rowView.findViewById(R.id.textViewTItle);
        // Get the TextView object
        tvDate = (TextView) rowView.findViewById(R.id.textViewDate);
        // Get the ImageView object
        imgIcon = (ImageView) rowView.findViewById(R.id.imageViewIcon);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the holiday at the same index.
        HolidayDetail currentTitle = holiday.get(position);
        // Set the TextView to show the food

        tvTitle.setText(currentTitle.getHolidayTitle());
        tvDate.setText((currentTitle.getHolidayDate()));
        // Set the image to star or nostar accordingly
        if(currentTitle.getHolidayTitle() == "New Year's Day") {
            imgIcon.setImageResource(R.drawable.newyear);
        }
        else if(currentTitle.getHolidayTitle() == "Labour Day") {
            imgIcon.setImageResource(R.drawable.labourday);
        }
        else if(currentTitle.getHolidayTitle() == "Chinese New Year") {
            imgIcon.setImageResource(R.drawable.cny);
        }
        else{
            imgIcon.setImageResource(R.drawable.goodfriday);
        }

        // Return the nicely done up View to the ListView
        return rowView;
    }



}

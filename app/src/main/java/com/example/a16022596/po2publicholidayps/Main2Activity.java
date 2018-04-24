package com.example.a16022596.po2publicholidayps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Main2Activity extends AppCompatActivity {
    TextView tvHoliday;
    ArrayList<HolidayDetail>holidays;
    ArrayList<HolidayDetail>holidaysReligion;
    ArrayAdapter aa;
    ListView lvDetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tvHoliday = (TextView)findViewById(R.id.textViewHoliday);
        lvDetail = (ListView)findViewById(R.id.listViewDetail);

        Intent iReceived = getIntent();
        String holidayTitle = iReceived.getStringExtra("title");
        tvHoliday.setText(holidayTitle);

        holidays = new ArrayList<HolidayDetail>();

        if(holidayTitle.equals("Secular")){
            holidays.add(new HolidayDetail("New Year's Day","1 Jan 2017"));
            holidays.add(new HolidayDetail("Labour Day","1 May 2017"));
        }
        else{
            holidays.add(new HolidayDetail("Chinese New Year","28-29 Jan 2017"));
            holidays.add(new HolidayDetail(" Good Friday","14 April 2017"));
        }
        aa = new HolidayAdapter(this,R.layout.row,holidays);
        lvDetail.setAdapter(aa);

        lvDetail.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HolidayDetail selectedDetail = holidays.get(position);


                Toast.makeText(Main2Activity.this, selectedDetail.getHolidayTitle()+ " Date: " + selectedDetail.getHolidayDate(),
                        Toast.LENGTH_LONG).show();

            }
        });

    }
}

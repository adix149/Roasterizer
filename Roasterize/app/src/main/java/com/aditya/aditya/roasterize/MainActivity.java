package com.aditya.aditya.roasterize;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SubmitTheDate(View v) {
        Log.d("ADI", "Submit button pressed ");
        Intent intent = new Intent(this, NamesActivity.class);
        DatePicker myDatePicker = (DatePicker) findViewById(R.id.datePicker);
        Date myDate = new GregorianCalendar(myDatePicker.getYear(),myDatePicker.getMonth(),1).getTime();
        Calendar cal = Calendar.getInstance();
        cal.setTime(myDate);
        cal.setFirstDayOfWeek(Calendar.SUNDAY);
        int myDay = cal.get(Calendar.DAY_OF_WEEK);
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        Bundle extras = new Bundle();
        extras.putString("STARTDAY",String.valueOf(myDay));
        extras.putString("NUMDAYS",String.valueOf(daysInMonth));
        Log.d("ADI", "Start day of the month is "+String.valueOf(myDay));
        intent.putExtras(extras);
        startActivity(intent);

    }





}

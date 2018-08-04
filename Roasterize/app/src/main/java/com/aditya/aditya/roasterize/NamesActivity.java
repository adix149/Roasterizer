package com.aditya.aditya.roasterize;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class NamesActivity extends AppCompatActivity {

    int numDaysInMonth;
    int startDayOfMonth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_names);

        Bundle inExtras = getIntent().getExtras();
        String startDayStr = inExtras.getString("STARTDAY");
        String numDaysStr = inExtras.getString("NUMDAYS");
        Log.d("ADI names", "Start day of the month is "+startDayStr);
        numDaysInMonth = Integer.parseInt(numDaysStr);
        startDayOfMonth = Integer.parseInt(startDayStr);


    }
    public void onRoasterizeSubmit (View v) {

        Log.d("ADI", "Add Roaster button pressed ");
        int numDocs=8;
        int DutyCnt=0;
        String nameId="DocName";
        String dutyId="DocNumDuties";

        Hashtable DocHash = new Hashtable();

       for (int i=1;i<=numDocs;i++)
       {
           String NameIDF=nameId+Integer.toString(i);
           String DutyIDF=dutyId+Integer.toString(i);

           int nid = getResources().getIdentifier(NameIDF, "id",getPackageName());
           int did = getResources().getIdentifier(DutyIDF, "id",getPackageName());
           EditText DocNameView = (EditText) findViewById(nid);
           EditText DocDutiesView = (EditText) findViewById(did);
           DocHash.put(DocNameView.getText().toString(),Integer.parseInt(DocDutiesView.getText().toString()));

       }

        Enumeration e = DocHash.keys();
        while (e.hasMoreElements()) {
            DutyCnt=DutyCnt+ (int)DocHash.get(e.nextElement());

        }

        if(DutyCnt!= 2*numDaysInMonth)
        {
            Toast.makeText(getApplicationContext(), "We need "+ Integer.toString(2*numDaysInMonth)+ " Duties. But you gave "+Integer.toString(DutyCnt), Toast.LENGTH_LONG).show();
        }
        else
        {

            DocHash.put("NumDays",numDaysInMonth);
            DocHash.put("StartDay",startDayOfMonth);
            Intent intent = new Intent(this, RoasterActivity.class);
            intent.putExtra("DOCHASH",DocHash );
            startActivity(intent);
        }
        DutyCnt=0;


    }


}

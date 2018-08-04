package com.aditya.aditya.roasterize;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;


public class RoasterActivity extends AppCompatActivity {

    int numDaysInMonth;
    int startDayOfMonth;

    HashMap <String,Integer> DocsHASH =new HashMap();
    List<String> validDocs ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roaster);

        Intent intent = getIntent();

        DocsHASH = (HashMap) intent.getSerializableExtra("DOCHASH") ;
       // TextView DocNameView = (TextView) findViewById(R.id.finaltxt);
       // DocNameView.setText(Integer.toString((Integer)DocsHASH.get("Thejaswini")));

        numDaysInMonth=(int)DocsHASH.get("NumDays");
        startDayOfMonth=(int)DocsHASH.get("StartDay");
        validDocs = new ArrayList<String>(DocsHASH.keySet());
        DocsHASH.remove("NumDays");
        DocsHASH.remove("StartDay");


        RoasterizeMe();
    }

    private void RoasterizeMe() {

        int maxtries=0;
        roaster r=new roaster(numDaysInMonth,startDayOfMonth,DocsHASH);
        do {

            try {
                r.assign_roaster();
                maxtries=10;
            }
            catch (Myexception e)
            {
                maxtries++;

            }
        } while (maxtries<10);

        System.out.println("hello");


    }


}



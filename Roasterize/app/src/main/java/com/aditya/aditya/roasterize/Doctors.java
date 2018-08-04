package com.aditya.aditya.roasterize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Aditya on 4/28/2016.
 */
public class Doctors {

    List<String> DocNames = new ArrayList<String>();
    List<Integer> DocDuties = new ArrayList<Integer>();
    int DutyCnt;

    HashMap<String,Integer> DocsH =new HashMap<String,Integer>();


    public Doctors(HashMap<String,Integer> dcHash)
    {


        for(HashMap.Entry<String, Integer> entry: dcHash.entrySet()) {
            DocNames.add(entry.getKey());
            DocDuties.add(entry.getValue());
        }

    }


    void print_doctors()
    {
        System.out.println("\n doctors of count "+DutyCnt+" in the roaster and their duties are");
        for (int i = 0; i< DutyCnt; i++)
        {
            System.out.println(DocNames.get(i)+"    "+DocDuties.get(i) );
        }

    }

    int get_doctors_cnt()
    {
        return DocNames.size();
    }

    Integer get_doctors_duties(Integer indx)
    {
        return DocDuties.get(indx);
    }

    String get_doctors_names(int indx)
    {
        return DocNames.get(indx);
    }


}

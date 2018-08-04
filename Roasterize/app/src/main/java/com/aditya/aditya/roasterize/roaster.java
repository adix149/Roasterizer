package com.aditya.aditya.roasterize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by Aditya on 4/28/2016.
 */
public class roaster {

    days month_days[];
    Doctors docs;
    List<Integer> Poss_Members = new ArrayList<Integer>();
    int numDaysInMonth;
    int startDayOfMonth;

    public roaster(int numDays, int startDay, HashMap<String,Integer> dHash)
    {
        docs=new Doctors(dHash);
        month_days =new days[numDays];
        System.out.println("\n  No of days in roaster "+ numDays);

        for(int i=0;i<docs.get_doctors_cnt();i++)
        {
            for(int j=0;j<docs.get_doctors_duties(i);j++)
            {
                Poss_Members.add(i);
            }
        }
        numDaysInMonth=numDays;
        startDayOfMonth=startDay;


    }

    public List<Integer> erase_val_all(List<Integer> v, int num)
    {
        v.removeAll(Arrays.asList(num));
        return v;
    }
    public List<Integer> erase_val(List<Integer> v, Integer num)
    {
        v.remove(Integer.valueOf(num));
        return v;
    }
    days randomize_indx(int D)
    {
        int A_indx;
        int B_indx;
        List<Integer> Valid_members = new ArrayList<Integer>();

        Valid_members.addAll(Poss_Members);
        Random ran = new Random();



        int A,B;
        days random_day=new days();
        do
        {
            A_indx = ran.nextInt(Valid_members.size());
            B_indx = ran.nextInt(Valid_members.size());
            A= Valid_members.get(A_indx);
            B= Valid_members.get(B_indx);
            System.out.println("the values of A is "+A +"and B is "+B);

        }while(!(random_day.assign_indx(D,A,B)));

        Poss_Members=erase_val(Poss_Members,A);
        Poss_Members=erase_val(Poss_Members,B);
        return (random_day) ; // random number between 0 and mem_cnt-1
    }

    days randomize_indx(int D, days previous) throws Myexception
    {
        int A_indx;
        int B_indx;
        List<Integer> Valid_members = new ArrayList<Integer>();
        Valid_members.addAll(Poss_Members);
        Random ran = new Random();



        Valid_members=erase_val_all(Valid_members, previous.get_A());
        Valid_members=erase_val_all(Valid_members, previous.get_B());


        int A,B;
        int repeatCnt=0;
        days random_day=new days();
        do {
            try {
                A_indx = ran.nextInt(Valid_members.size());
                B_indx = ran.nextInt(Valid_members.size());
            }
            catch(Exception e)
            {
                throw new Myexception();
            }

            A = Valid_members.get(A_indx);
            B = Valid_members.get(B_indx);
            if (A == B) repeatCnt++;
            System.out.println("the values of A is " + A + "and B is " + B);

        } while (!(random_day.assign_indx(D, A, B)) && repeatCnt < 4);

        if (repeatCnt>=4) throw new Myexception();

        Poss_Members=erase_val(Poss_Members,A);
        Poss_Members=erase_val(Poss_Members,B);
        return (random_day) ; // random number between 0 and mem_cnt-1
    }
    void assign_roaster() throws Myexception
    {

        days prev=new days();

        try {
            for (int i = 0; i < numDaysInMonth; i++) {
                if (i == 0) {
                    month_days[i] = randomize_indx(i);
                    month_days[i].print_day();
                    prev = month_days[i];
                } else {
                    month_days[i] = randomize_indx(i, prev);
                    month_days[i].print_day();
                    prev = month_days[i];
                }
            }
        }
        catch(Myexception e)
        {
            throw new Myexception();

        }

        for(int i=0;i<numDaysInMonth;i++)
        {
            for(int j=i;j<i+7&&j<numDaysInMonth;j++)
            {
                System.out.printf("%10s",docs.get_doctors_names(month_days[j].get_A()));
                System.out.printf("    ");

            }
            System.out.println();
            for(int j=i;j<i+7&&j<numDaysInMonth;j++)
            {
                System.out.printf("%10s",docs.get_doctors_names(month_days[j].get_B()));
                System.out.printf("    ");
            }
            System.out.println();
            System.out.println();
            System.out.println();
            i=i+6;
        }


    }
}

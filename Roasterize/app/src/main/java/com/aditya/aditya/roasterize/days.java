package com.aditya.aditya.roasterize;

/**
 * Created by Aditya on 4/28/2016.
 */
public class days {

    int date;
    int Mem_Indx_A,Mem_Indx_B;


    days()
    {
        date=0;
        Mem_Indx_A = -1 ;
        Mem_Indx_B = -1 ;
    }
    public int get_date()
    {
        return date;
    }
    public int get_A()
    {
        return Mem_Indx_A;
    }
    public int get_B()
    {
        return Mem_Indx_B;
    }

    public boolean assign_indx(int D ,int A,int B)
    {
        date= D;
        if(A!=B)
        {
            if(A<B)
            {
                Mem_Indx_A = A ;
                Mem_Indx_B = B ;
            }
            else if(A>B)
            {
                Mem_Indx_A = B ;
                Mem_Indx_B = A ;
            }
            return true;
        }

        else
            return false;
    }

    public void print_day()
    {
        System.out.println("\n The date is "+ date +" Member A index is " + Mem_Indx_A+" Member B index is  "+Mem_Indx_B);
    }

}



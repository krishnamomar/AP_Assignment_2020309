package com.aa_assignment;
import java.util.*;
import java.lang.*;

public class Hospital {

    String Name;
    ArrayList<Vaccine> vaccine_list = new ArrayList<>();
    ArrayList<Integer> day_number = new ArrayList<>();
    ArrayList<Integer> quantity_day = new ArrayList<>();
    Integer PinCode;
    Integer Hosp_iD;

    public void add_slot(Vaccine v, int qn, int dy){
        vaccine_list.add(v);
        day_number.add(dy);
        quantity_day.add(qn);
    }

    public String getName(){
        return Name;
    }

    public Integer getPin(){
        return PinCode;
    }

    public Integer getID(){
        return Hosp_iD;
    }

    public void book_slot(int x){
        quantity_day.set(x, quantity_day.get(x) - 1);
    }

    public ArrayList<Vaccine> getVaccine_list(){
        return vaccine_list;
    }

    public ArrayList<Integer> getDay_number(){
        return day_number;
    }

    public ArrayList<Integer> getQuantity_day(){
        return quantity_day;
    }



}

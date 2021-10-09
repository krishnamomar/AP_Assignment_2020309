package com.aa_assignment;
import java.util.*;
import java.lang.*;

public class Hospital {

    String Name;
    ArrayList<Vaccine> all_vaccine = new ArrayList<>();
    ArrayList<Integer> v_available = new ArrayList<>();
    ArrayList<Integer> day_number = new ArrayList<>();
    Integer PinCode;
    Integer Hosp_iD;

    public void add_slot(Vaccine vx, Integer qnt, Integer day){
        all_vaccine.add(vx);
        v_available.add(qnt);
        day_number.add(day);
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

}

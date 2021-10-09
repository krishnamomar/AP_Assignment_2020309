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

    public void remove_slot(Integer ind){
        Integer mm = v_available.get(ind);
        if (mm==1){
            all_vaccine.remove(ind);
            v_available.remove(ind);
            day_number.remove(ind);
            return;
        }
        else{
            v_available.set(ind, mm-1);
            return;
        }

    }

}

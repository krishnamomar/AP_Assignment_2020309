package com.aa_assignment;
import java.util.*;
import java.lang.*;

public class Hospital {

    String Name;
    HashMap<Vaccine, ArrayList<Integer>> vaccines_qnt_day = new HashMap<>();
    Integer PinCode;
    Integer Hosp_iD;

    public void add_slot(Vaccine v, int qn, int dy){
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(qn);
        tmp.add(dy);
        vaccines_qnt_day.put(v, tmp);
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

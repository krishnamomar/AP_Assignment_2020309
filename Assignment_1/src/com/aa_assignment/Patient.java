package com.aa_assignment;
import java.lang.*;

public class Patient {
    String name;
    Integer age;
    Long unqID;
    Vaccine vax = null;
    Integer doses_done = 0;
    Integer day_of_first = 0;

    public String getName(){
        return name;
    }

    public Integer getAge(){
        return age;
    }

    public Long getUnqID() {
        return unqID;
    }

    public Vaccine getvaccine(){
        return vax;
    }

    public Integer getDoses_done(){
        return doses_done;
    }

    public Integer getDay_of_first(){
        return  day_of_first;
    }


}

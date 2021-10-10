package com.aa_assignment;
import java.lang.*;

public class Patient {
    String name;
    Integer age;
    Long unqID;
    Vaccine vax;
    Integer doses_done;
    Integer day_of_first;

    public String getName(){
        return name;
    }

    public Integer getAge(){
        return age;
    }

    public Long getUnqID() {
        return unqID;
    }
}

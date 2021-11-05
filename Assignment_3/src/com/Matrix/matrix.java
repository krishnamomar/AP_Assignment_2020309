package com.Matrix;

import java.lang.*;
import java.util.ArrayList;

public class matrix {

    private String name;
    private ArrayList<ArrayList<Integer>> grid;

    public void setName(String nm){
        this.name = nm;
    }

    public void setGrid(ArrayList<ArrayList<Integer>> grd){
        this.grid = grd;

    }

    public String getName(){
        return name;
    }

    public ArrayList<ArrayList<Integer>> getGrid(){
        return grid;
    }
}

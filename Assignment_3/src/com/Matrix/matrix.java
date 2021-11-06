package com.Matrix;

import java.lang.*;
import java.util.ArrayList;

public class matrix {

    private String name;
    private ArrayList<ArrayList<Integer>> grid;
    private Integer row;
    private Integer column;

    public void setName(String nm){
        this.name = nm;
    }

    public void setGrid(ArrayList<ArrayList<Integer>> grd){
        this.grid = grd;
        this.row = grd.size();
        this.column = (grd.get(0)).size();
    }

    public String getName(){
        return name;
    }

    public ArrayList<ArrayList<Integer>> getGrid(){
        return grid;
    }

    public Integer getRow(){
        return row;
    }

    public Integer getColumn() {
        return column;
    }
}
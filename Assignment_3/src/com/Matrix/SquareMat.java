package com.Matrix;

import java.util.ArrayList;

public class SquareMat extends matrix{
    private String name;
    private ArrayList<ArrayList<Double>> grid;
    private Integer row;
    private Integer column;

    public void setName(String nm){
        this.name = nm;
    }

    public void setGrid(ArrayList<ArrayList<Double>> grd){
        this.grid = grd;
        this.row = grd.size();
        this.column = grd.size();
    }

    public String getName(){
        return name;
    }

    public ArrayList<ArrayList<Double>> getGrid(){
        return grid;
    }

    public Integer getRow(){
        return row;
    }

    public Integer getColumn() {
        return column;
    }

    @Override
    public Integer getMatType(){
        return 6;
    }
}

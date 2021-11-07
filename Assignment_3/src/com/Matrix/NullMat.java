package com.Matrix;

import java.util.ArrayList;

public class NullMat extends matrix{
    private String name;
    private Integer row;
    private Integer column;

    public void setName(String nm){
        this.name = nm;
    }

    @Override
    public void setGrid(ArrayList<ArrayList<Double>> grd){
        this.row = grd.size();
        this.column = (grd.get(0)).size();
    }

    public String getName(){
        return name;
    }

    @Override
    public ArrayList<ArrayList<Double>> getGrid(){
        ArrayList<ArrayList<Double>> crnt = new ArrayList<>();
        for (int i=0; i<row; i++){
            ArrayList<Double> x = new ArrayList<>();
            for (int j=0; j<column; j++){
                x.add(0.0);
            }
            crnt.add(x);
        }
        return crnt;
    }

    public Integer getRow(){
        return row;
    }

    public Integer getColumn() {
        return column;
    }
}

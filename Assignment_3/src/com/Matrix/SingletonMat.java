package com.Matrix;

import java.util.ArrayList;

public class SingletonMat extends SquareMat{
    private String name;
    private Double val;

    public void setName(String nm){
        this.name = nm;
    }

    @Override
    public void setGrid(ArrayList<ArrayList<Double>> grd){
        this.val = grd.get(0).get(0);
    }

    public String getName(){
        return name;
    }

    @Override
    public ArrayList<ArrayList<Double>> getGrid(){
        ArrayList<ArrayList<Double>> crnt = new ArrayList<>();
        ArrayList<Double> x = new ArrayList<>();
        x.add(val);
        crnt.add(x);
        return crnt;
    }

    @Override
    public Integer getRow(){
        return 1;
    }

    @Override
    public Integer getColumn() {
        return 1;
    }

    @Override
    public Integer getMatType(){
        return 8;
    }
}

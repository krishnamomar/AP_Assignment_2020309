package com.Matrix;

import java.util.ArrayList;

public class RowMat extends matrix{
    private String name;
    private ArrayList<Double> grid;
    private Integer row;
    private Integer column;

    public void setName(String nm){
        this.name = nm;
    }

    public String getName(){
        return name;
    }

    public Integer getRow(){
        return row;
    }

    public Integer getColumn() {
        return column;
    }

    @Override
    public void setGrid(ArrayList<ArrayList<Double>> grd){
        this.row = 1;
        this.column = grd.get(0).size();

        ArrayList<Double> crnt = new ArrayList<>();
        for (int i=0; i<column; i++){
            crnt.add(grd.get(0).get(i));
        }

        this.grid = crnt;
    }

    @Override
    public ArrayList<ArrayList<Double>> getGrid(){
        ArrayList<ArrayList<Double>> crnt = new ArrayList<>();

        ArrayList<Double> x = new ArrayList<>();
        crnt.add(x);

        for (int i=0; i<column; i++){
            crnt.get(0).add(grid.get(i));
        }

        return crnt;
    }

    @Override
    public Integer getMatType(){
        return 2;
    }
}

package com.Matrix;

import java.util.ArrayList;
import java.lang.*;

public class DiagnolMat extends matrix{
    private String name;
    private ArrayList<Integer> grid;
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
    public void setGrid(ArrayList<ArrayList<Integer>> grd){
        this.row = grd.size();
        this.column = grd.size();

        ArrayList<Integer> crnt = new ArrayList<>();
        for (int i=0; i<row; i++){
            crnt.add(grd.get(i).get(i));
        }

        this.grid = crnt;
    }

    @Override
    public ArrayList<ArrayList<Integer>> getGrid(){
        ArrayList<ArrayList<Integer>> crnt = new ArrayList<>();

        for (int i=0; i<row; i++){
            ArrayList<Integer> x = new ArrayList<>();
            crnt.add(x);
        }

        for (int i=0; i<row; i++){
            for (int j=0; j<row; j++){
                if (i==j){
                    crnt.get(i).add(grid.get(i));
                }
                else{
                    crnt.get(i).add(0);
                }
            }
        }

        return crnt;
    }
}

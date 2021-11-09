package com.Matrix;

import java.util.ArrayList;

public class ScalarMat extends DiagnolMat{
    private String name;
    private Integer row;
    private Integer column;
    private Double val;

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
        this.val = grd.get(0).get(0);
        this.row = grd.size();
        this.column = grd.size();
    }

    @Override
    public ArrayList<ArrayList<Double>> getGrid(){

        ArrayList<ArrayList<Double>> crnt = new ArrayList<>();

        for (int i=0; i<row; i++){
            ArrayList<Double> x = new ArrayList<>();
            crnt.add(x);
        }

        for (int i=0; i<row; i++){
            for (int j=0; j<row; j++){
                if (i==j){
                    crnt.get(i).add(val);
                }
                else{
                    crnt.get(i).add(0.0);
                }
            }
        }

        return crnt;
    }

    @Override
    public Integer getMatType(){
        return 11;
    }
}

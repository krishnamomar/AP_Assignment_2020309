package com.Image_Process;

import java.lang.*;
import java.util.ArrayList;

public class Color_Image {
    private ArrayList<ArrayList<ArrayList<Integer>>> Matrix;
    //the inner Array goes R,G,B
    private Integer Row;
    private Integer Column;
    private String Name;

    public ArrayList<ArrayList<ArrayList<Integer>>> getMatrix() {
        return Matrix;
    }

    public void setMatrix(ArrayList<ArrayList<ArrayList<Integer>>> matrix){
        this.Matrix = matrix;
    }

    public Integer getColumn() {
        return Column;
    }

    public Integer getRow() {
        return Row;
    }

    public void setColumn(Integer column) {
        this.Column = column;
    }

    public void setRow(Integer row) {
        this.Row = row;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }
}
